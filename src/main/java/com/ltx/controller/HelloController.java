package com.ltx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Rain on 2017/1/12.
 */
@Controller
public class HelloController {

    //返回基本信息
    @RequestMapping("/hello1")
    public void helloWorld(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //输出字符串
        response.getWriter().append("hello world");
    }

    //通过 视图解析器  渲染成   html
    @RequestMapping("/hello2")
    public String helloWorld2(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return "index";
    }
}
