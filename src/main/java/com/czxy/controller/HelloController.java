package com.czxy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author :almostTao
 * @date :Created in 2019/8/14 23:15
 */
@Controller
public class HelloController {

    @RequestMapping("/use")
    @ResponseBody
    public String fun(){
        //language=JSON
        String s = "{\"name\": \"tom\"}";
        return s;
    }

    @RequestMapping("/page")
    public String page(){
        System.out.println("page");
        return "ok";
    }

}
