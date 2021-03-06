package com.forum.controller;

import com.forum.dao.PostMapper;
import com.forum.entity.Post;
import com.forum.entity.User;
import com.forum.service.api.SystemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cusb-forum")
public class SystemController {
    @Autowired
    SystemService systemService;
    @Autowired
    PostMapper postDao;

    Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping(value = "/yangzhi")
    public String yangzhi(Model map) {
        List<Post> list = systemService.listPostOfForum("t1");
        map.addAttribute("list",list);
        return "yangzhi";
    }

    @GetMapping(value = "/yangsheng")
    public String yangsheng(Model map) {
        List<Post> list = systemService.listPostOfForum("t2");
        map.addAttribute("list",list);
        return "yangsheng";
    }

    @GetMapping(value = "/ziyuan")
    public String ziyuan(Model map) {
        List<Post> list = systemService.listPostOfForum("t3");
        map.addAttribute("list",list);
        return "ziyuan";
    }
}
