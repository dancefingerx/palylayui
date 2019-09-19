package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xnz
 * @date 2019/8/30 19:27
 */
@Controller
public class TestController {

    @RequestMapping("/test1")
//    @ResponseBody
    public String test1(HttpServletRequest request){
        request.setAttribute("say","hello world sdfcdsa");
        System.out.println("aaaaaaaaaaaaaaaaadddddddddddddddddddddddddddda");
//        return new ModelAndView("/test1.html");
        return "test1.html";
    }

    @GetMapping(value = {"/","/index"})
    public ModelAndView index() {
        System.out.println("========");
        return new ModelAndView("test1.html");
    }
}
