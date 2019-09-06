package com.czxy.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @author :almostTao
 * @date :Created in 2019/6/18 17:42
 */
public class WebInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        //1 初始化spring容器
        AnnotationConfigWebApplicationContext appliation = new AnnotationConfigWebApplicationContext();
        appliation.register(SpringConfig.class);
        appliation.register(MyBatisConfig.class);
        appliation.register(SpringMVConfig.class);
        appliation.setServletContext(servletContext);

        //2 post乱码配置
        FilterRegistration.Dynamic encodingFilter = servletContext.addFilter("CharacterEncodingFilter", new CharacterEncodingFilter("UTF-8"));
        encodingFilter.addMappingForUrlPatterns(null, true, "/*");

        //3 前端控制器
        ServletRegistration.Dynamic springMvcServlet = servletContext.addServlet("springmvc", new DispatcherServlet(appliation));
        springMvcServlet.addMapping("*.action");
        springMvcServlet.setLoadOnStartup(2);
    }

}
