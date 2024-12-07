package org.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

/**
 * 代替spring.xml
 * 1.扫描组件
 * 2.默认Servlet
 * 3.mvc的注解驱动
 * 4.视图解析器
 * 5.文件上传解析器
 * 6.视图解析器 Thymeleaf
 * 拦截器和异常处理省略
 */
@Configuration //1
@ComponentScan("org.example")
@EnableWebMvc //3
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) { //2
        configurer.enable();
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) { //4
        registry.addViewController("/").setViewName("index");
    }

    @Bean
    public CommonsMultipartResolver multipartResolver() { //5
        return new CommonsMultipartResolver();
    }

    @Bean
    public ITemplateResolver templateResolver() { //6
        WebApplicationContext currentWebApplicationContext = ContextLoader.getCurrentWebApplicationContext();
        ServletContextTemplateResolver servletContextTemplateResolver = new ServletContextTemplateResolver(
                currentWebApplicationContext.getServletContext()
        );
        servletContextTemplateResolver.setPrefix("/WEB-INF/templates/");
        servletContextTemplateResolver.setSuffix(".html");
        servletContextTemplateResolver.setCharacterEncoding("utf-8");
        servletContextTemplateResolver.setTemplateMode(TemplateMode.HTML);
        return servletContextTemplateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine(ITemplateResolver templateResolver) {//6
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        return templateEngine;
    }

    @Bean
    public ViewResolver viewResolver(SpringTemplateEngine templateEngine) {//6
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setCharacterEncoding("UTF-8");
        viewResolver.setTemplateEngine(templateEngine);
        return viewResolver;
    }
}
