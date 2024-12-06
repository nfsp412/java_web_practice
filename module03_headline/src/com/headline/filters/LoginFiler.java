package com.headline.filters;

import com.headline.common.Result;
import com.headline.common.ResultCodeEnum;
import com.headline.utils.JwtHelper;
import com.headline.utils.WebUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/headline/*")
public class LoginFiler implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String token = request.getHeader("token");
        Boolean flag = false;
        if (token !=null){
            if (!JwtHelper.isExpiration(token)){
                //token不为空,并且没过期,放行请求
                flag = true;
            }
        }
        if (flag){
            filterChain.doFilter(request,response);
        }else {
            WebUtil.writeJson(response, Result.build(null, ResultCodeEnum.NOT_LOGIN));
        }
    }
}
