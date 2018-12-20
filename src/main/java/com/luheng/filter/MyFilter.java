package com.luheng.filter;

import javax.servlet.*;
import java.io.IOException;

public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String paramName = filterConfig.getInitParameter("paramName");
        String paramValue = filterConfig.getInitParameter("paramValue");
        System.out.println("-----------------> 过滤器被初始化了,初始化参数是:" + paramName + "---" + paramValue);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("-----------------> 过滤器doFilter正在过滤请求 " + servletRequest.getLocalAddr());
    }

    @Override
    public void destroy() {
        System.out.println("-----------------> 过滤器被销毁了");
    }
}
