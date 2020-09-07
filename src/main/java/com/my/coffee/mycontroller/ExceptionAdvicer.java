package com.my.coffee.mycontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * @Auther: wangjw
 * @Date: 2019/8/13 15:44
 * @Description:统一异常页面处理跳转
 */
@ControllerAdvice
public class ExceptionAdvicer {

    private static final Logger logger = LoggerFactory.getLogger(Exception.class);

    @ExceptionHandler(NoHandlerFoundException.class)
    public String noFound(NoHandlerFoundException e) {
        logger.error("找不到："+e.getMessage());
        return "/error/404.html";
    }

    @ExceptionHandler(Exception.class)
    public String exception(Exception e) {
        logger.error("出现异常："+e.getMessage());
        return "/error/500.html";
    }
}
