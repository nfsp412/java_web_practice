package com.bigdata.boot.pkg01.config;

import com.bigdata.boot.pkg01.bean.People;
import com.bigdata.boot.pkg01.bean.Pet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StringUtils;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;
import org.springframework.web.accept.ParameterContentNegotiationStrategy;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author sunpeng
 * @version v1.0
 * @package spring_project
 * @name WebConfig
 * @create 2024/7/22 6:55
 */

@Configuration(proxyBeanMethods = false)
public class WebConfig /*implements WebMvcConfigurer */ {
    //    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        HiddenHttpMethodFilter filter = new HiddenHttpMethodFilter();
        filter.setMethodParam("_m");
        return filter;
    }

//    @Override
//    public void configurePathMatch(PathMatchConfigurer configurer) {
//        UrlPathHelper urlPathHelper = new UrlPathHelper();
//        urlPathHelper.setRemoveSemicolonContent(false);
//        configurer.setUrlPathHelper(urlPathHelper);
//    }

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            /**
             * 自定义内容协商策略
             * @param configurer
             */
            @Override
            public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
                HashMap<String, MediaType> map = new HashMap<>();
                // 添加支持的参数解析对应的媒体类型kv
                map.put("json", MediaType.APPLICATION_JSON);
                map.put("xml", MediaType.APPLICATION_XML);
                map.put("gg", MediaType.parseMediaType("application/x-guigu"));
                ParameterContentNegotiationStrategy strategy = new ParameterContentNegotiationStrategy(map);
                HeaderContentNegotiationStrategy strategy1 = new HeaderContentNegotiationStrategy();
                configurer.strategies(Arrays.asList(strategy, strategy1));
            }

            @Override
            public void configurePathMatch(PathMatchConfigurer configurer) {
                UrlPathHelper urlPathHelper = new UrlPathHelper();
                urlPathHelper.setRemoveSemicolonContent(false);
                configurer.setUrlPathHelper(urlPathHelper);
            }

            @Override
            public void addFormatters(FormatterRegistry registry) {
                registry.addConverter(new Converter<String, Pet>() {
                    @Override
                    public Pet convert(String source) {
                        if (!StringUtils.isEmpty(source)) {
                            String[] split = source.split(",");
                            String name = split[0];
                            double weight = Double.parseDouble(split[1]);
                            return new Pet(name, weight);
                        }
                        return null;
                    }
                });
            }

            /**
             * 该方法指的是额外添加自定义的MessageConverter
             * @param converters the list of configured converters to extend.
             */
            @Override
            public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
                converters.add(new HttpMessageConverter<People>() {
                    /**
                     * 返回是否能够从浏览器读取请求数据
                     * @param clazz the class to test for readability
                     * @param mediaType the media type to read (can be {@code null} if not specified);
                     * typically the value of a {@code Content-Type} header.
                     * @return
                     */
                    @Override
                    public boolean canRead(Class<?> clazz, MediaType mediaType) {
                        //不支持读取
                        return false;
                    }

                    /**
                     *
                     * @param clazz the class to test for writability
                     * @param mediaType the media type to write (can be {@code null} if not specified);
                     * typically the value of an {@code Accept} header.
                     * @return
                     */
                    @Override
                    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
                        return clazz.isAssignableFrom(People.class);
                    }

                    /**
                     *
                     * @return
                     */
                    @Override
                    public List<MediaType> getSupportedMediaTypes() {
                        //获取支持的媒体类型
                        List<MediaType> mediaTypes = MediaType.parseMediaTypes("application/x-guigu");
                        return mediaTypes;
                    }

                    /**
                     *
                     * @param clazz the type of object to return. This type must have previously been passed to the
                     * {@link #canRead canRead} method of this interface, which must have returned {@code true}.
                     * @param inputMessage the HTTP input message to read from
                     * @return
                     * @throws IOException
                     * @throws HttpMessageNotReadableException
                     */
                    @Override
                    public People read(Class<? extends People> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
                        return null;
                    }

                    /**
                     *
                     * @param people the object to write to the output message. The type of this object must have previously been
                     * passed to the {@link #canWrite canWrite} method of this interface, which must have returned {@code true}.
                     * @param contentType the content type to use when writing. May be {@code null} to indicate that the
                     * default content type of the converter must be used. If not {@code null}, this media type must have
                     * previously been passed to the {@link #canWrite canWrite} method of this interface, which must have
                     * returned {@code true}.
                     * @param outputMessage the message to write to
                     * @throws IOException
                     * @throws HttpMessageNotWritableException
                     */
                    @Override
                    public void write(People people,
                                      MediaType contentType,
                                      HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
                        //
                        String s = people.getUser() + ";" + people.getPassword() + ";" + people.getPet();
                        OutputStream body = outputMessage.getBody();
                        body.write(s.getBytes());
                    }
                });
            }
        };
    }
}
