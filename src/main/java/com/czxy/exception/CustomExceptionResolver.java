package com.czxy.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author :almostTao
 * @date :Created in 2019/6/20 20:39
 */

public class CustomExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception ex) {

        //统一处理异常
        CustomException customException = null;
        // 如果是自定义异常直接类型转换赋值,并显示错误信息
        // 如果不是创建自定义异常,提示未知错误
        if(ex instanceof CustomException){
            customException = (CustomException) ex;
        } else {
            customException = new CustomException("系统错误，请与系统管理 员联系！");
        }

        //设置数据
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", customException.getMessage());
        modelAndView.setViewName("WEB-INF/error");

        return modelAndView;
    }
}
