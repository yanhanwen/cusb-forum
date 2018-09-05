package com.forum.controller;

import com.forum.service.api.CusbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/cusb-forum")
public class CusbController {
    @Autowired
    CusbService cusbService;

    @PostMapping("/login")
    public void login(@RequestParam String userId,@RequestParam String userPwd){
        int result = cusbService.login(userId,userPwd);
        //todo,页面跳转逻辑，和返回信息
    }
}
