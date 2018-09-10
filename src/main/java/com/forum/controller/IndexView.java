package com.forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cusb-forum")
public class IndexView{
    @GetMapping(value = "/index")
    public String index() {
        return "index";
    }

    @GetMapping(value = "/login")
    public String toUpload() {
        return "login";
    }

    @GetMapping("/regist")
    public String login(){
        return "regist";
    }
}