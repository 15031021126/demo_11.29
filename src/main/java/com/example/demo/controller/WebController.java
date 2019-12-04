package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class WebController {
    /**登录失败页面
     * http://localhost:8080/error
     * @return
     */
    @RequestMapping("/web_error")
    public String error() {
        System.out.println("error");
        return "error";
    }

    /**
     * 登录
     * @return
     */
    @RequestMapping("/web_login")
    public String login() {
        System.out.println("login");
        return "login";
    }

    /**
     * 注册
     * @return
     */
    @RequestMapping("/web_registered")
    public String registered() {
        System.out.println("registered");
        return "registered";
    }

    /**
     * 主页链接 http://localhost:8080/index
     * @return
     */
    @RequestMapping("/web_index")
    public String index() {
        System.out.println("index");
        return "index";
    }
}
