package com.forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/cusb-forum")
public class IndexView{
    @RequestMapping("/login")
    public String login() {
        return "login";
    }
    @RequestMapping("/regist")
    public String regist() {
        return "regist";
    }
}