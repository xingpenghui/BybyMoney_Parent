package com.feri.byby.common.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 *@Author feri
 *@Date Created in 2018/11/28 11:47
 * 实现跨域处理  基于请求消息头
 */
public class CROSFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpServletResponse response=(HttpServletResponse) servletResponse;
        response.addHeader("Access-Control-Allow-Origin",request.getHeader("Origin"));
        response.addHeader("Access-Control-Allow-Methods","GET,POST,PUT,DELETE");
        response.addHeader("Access-Control-Max-Age","2000");
        response.addHeader("Access-Control-Allow-Headers","Origin,Accept,X-Request-with,Content-Type");
        response.addHeader("Access-Control-Allow-Credentials","true");
        filterChain.doFilter(request,response);
    }

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void destroy() {

    }
}
