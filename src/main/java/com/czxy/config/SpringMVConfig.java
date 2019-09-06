package com.czxy.config;

import com.czxy.interceptor.MyInterceptor1;
import com.czxy.interceptor.MyInterceptor2;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;

/**
 * @author :almostTao
 * @date :Created in 2019/6/18 17:41
 */

@Configuration
@ComponentScan("com.czxy.controller")
@EnableWebMvc
public class SpringMVConfig extends WebMvcConfigurerAdapter {

    @Resource
//    @Autowired
    private MyInterceptor1 myInterceptor1;

    @Resource
    private MyInterceptor2 myInterceptor2;

//    @Bean
//    public InternalResourceViewResolver internalResourceViewResolver(){
//        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//        viewResolver.setPrefix("/WEB-INF/jsp/");
//        viewResolver.setSuffix(".jsp");
//        return viewResolver;
//    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        InterceptorRegistration interceptorRegistration1 = registry.addInterceptor(myInterceptor1);
//        InterceptorRegistration interceptorRegistration2 = registry.addInterceptor(myInterceptor2);
//        interceptorRegistration1.addPathPatterns("/**");
//        interceptorRegistration2.addPathPatterns("/**");
    }


}
