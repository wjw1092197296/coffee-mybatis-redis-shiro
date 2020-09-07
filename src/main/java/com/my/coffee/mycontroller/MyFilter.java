package com.my.coffee.mycontroller;


import javax.servlet.*;
import java.io.IOException;

/**
 * @Auther: wangjw
 * @Date: 2019/8/20 15:24
 * @Description:
 */
public class MyFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter 初始化。。。");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("进入filter的doFilter 。。。");
        System.out.println(servletRequest.getCharacterEncoding());
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
