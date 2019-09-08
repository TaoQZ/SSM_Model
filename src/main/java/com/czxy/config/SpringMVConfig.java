package com.czxy.config;

import com.czxy.interceptor.MyInterceptor1;
import com.czxy.interceptor.MyInterceptor2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.annotation.Resource;

/**
 * @author :almostTao
 * @date :Created in 2019/6/18 17:41
 */

@Configuration
@ComponentScan("com.czxy.controller")
@EnableWebMvc
public class SpringMVConfig implements WebMvcConfigurer {

    @Resource
//    @Autowired
    private MyInterceptor1 myInterceptor1;

    @Resource
    private MyInterceptor2 myInterceptor2;

    /**
     * controller 的返回的请求路径的前后缀 WebMvcConfigurer 接口的方法 也可传入自定义的视图解析器
     * @param registry
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/",".jsp");
//        也可传入自定义的视图解析器
//        registry.viewResolver(internalResourceViewResolver());
    }

    /**
     * controller 的返回的请求路径的前后缀
     */
    @Bean
    public InternalResourceViewResolver internalResourceViewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/");
        viewResolver.setSuffix(".jsp");
        System.out.println("222222222");
        return viewResolver;
    }

    /**
     * 添加拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        InterceptorRegistration interceptorRegistration1 = registry.addInterceptor(myInterceptor1);
//        InterceptorRegistration interceptorRegistration2 = registry.addInterceptor(myInterceptor2);
//        interceptorRegistration1.addPathPatterns("/**");
//        interceptorRegistration2.addPathPatterns("/**");

//        registry.addInterceptor(myInterceptor).addPathPatterns("/**").excludePathPatterns("/**/*.js","/**/*.css","/**/*.png","/**/*.jpg","/**/font/**");

    }

    /**
     * 虚拟路径映射
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        System.out.println("添加映射路径");
        registry.addResourceHandler("/upload/**").addResourceLocations("file:D:/temp/upload/");
    }


}
