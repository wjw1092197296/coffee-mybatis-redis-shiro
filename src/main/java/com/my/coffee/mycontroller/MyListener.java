package com.my.coffee.mycontroller;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @Auther: wangjw
 * @Date: 2019/8/20 15:44
 * @Description:
 */
public class MyListener implements HttpSessionListener{

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("MyListener创建 session。。。。");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

    }
}
