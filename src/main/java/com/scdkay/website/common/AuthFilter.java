package com.scdkay.website.common;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 权限过滤器，未获取登录权限的抛出异常
 * Created by liurui on 2017/7/13.
 */
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        StringBuffer requestURL = httpServletRequest.getRequestURL();
        if (requestURL.indexOf("login") == -1 && httpServletRequest.getSession().getAttribute("userName") == null) {
            RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/html/login.html");
            rd.forward(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
