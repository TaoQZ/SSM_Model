package com.czxy.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author :almostTao
 * @date :Created in 2019/6/24 9:27
 */
@Component
public class MyInterceptor1 implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("在Controller方法之前执行1");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("Controller方法执行后并且在视图之前执行1");
        String viewName = modelAndView.getViewName();
        System.out.println("前"+viewName);
        modelAndView.setViewName("Test3");
        String viewName1 = modelAndView.getViewName();
        System.out.println("后"+viewName1);
        System.out.println("Controller方法执行后并且在视图之前执行1");

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("jsp执行后执行1");
    }
}
