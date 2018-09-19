package com.forum.controller;

import com.forum.dao.PostMapper;
import com.forum.dao.UserMapper;
import com.forum.entity.Post;
import com.forum.entity.User;
import com.forum.service.api.CusbService;
import com.forum.service.api.ManagerService;
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
    CusbService cusbService;
    @Autowired
    SystemService systemService;
    @Autowired
    ManagerService managerService;
    @Autowired
    PostMapper postDao;
    @Autowired
    UserMapper userDao;

    Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping(value = "/yangzhi")
    public String yangzhi(Model map) {
        List<Post> list = systemService.listPostOfForum("t1");
        List<Post> listtop = new ArrayList<>();
        for(Post t:list){
            if(t.getStatus()/100 == 2){
                listtop.add(t);
            }
        }
        for(Post t:listtop){
            list.remove(t);
        }
        map.addAttribute("listtop",listtop);
        map.addAttribute("list",list);
        return "yangzhi";
    }

    @GetMapping(value = "/yangzhimanager")
    public String yangzhinamager(Model map) {
        List<Post> list = systemService.listPostOfForum("t1");
        List<Post> listtop = new ArrayList<>();
        for(Post t:list){
            if(t.getStatus()/100 == 2){
                listtop.add(t);
            }
        }
        for(Post t:listtop){
            list.remove(t);
        }
        map.addAttribute("listtop",listtop);
        map.addAttribute("list",list);
        return "yangzhimanager";
    }

    @GetMapping(value = "/yangsheng")
    public String yangsheng(Model map) {
        List<Post> list = systemService.listPostOfForum("t2");
        List<Post> listtop = new ArrayList<>();
        for(Post t:list){
            if(t.getStatus()/100 == 2){
                listtop.add(t);
            }
        }
        for(Post t:listtop){
            list.remove(t);
        }
        map.addAttribute("listtop",listtop);
        map.addAttribute("list",list);
        return "yangsheng";
    }

    @GetMapping(value = "/yangshengmanager")
    public String yangshengmanager(Model map) {
        List<Post> list = systemService.listPostOfForum("t2");
        List<Post> listtop = new ArrayList<>();
        for(Post t:list){
            if(t.getStatus()/100 == 2){
                listtop.add(t);
            }
        }
        for(Post t:listtop){
            list.remove(t);
        }
        map.addAttribute("listtop",listtop);
        map.addAttribute("list",list);
        return "yangshengmanager";
    }

    @GetMapping(value = "/ziyuan")
    public String ziyuan(Model map) {
        List<Post> list = systemService.listPostOfForum("t3");
        List<Post> listtop = new ArrayList<>();
        for(Post t:list){
            if(t.getStatus()/100 == 2){
                listtop.add(t);
            }
        }
        for(Post t:listtop){
            list.remove(t);
        }
        map.addAttribute("listtop",listtop);
        map.addAttribute("list",list);
        return "ziyuan";
    }
    @GetMapping(value = "/ziyuanmanager")
    public String ziyuanmanager(Model map) {
        List<Post> list = systemService.listPostOfForum("t3");
        List<Post> listtop = new ArrayList<>();
        for(Post t:list){
            if(t.getStatus()/100 == 2){
                listtop.add(t);
            }
        }
        for(Post t:listtop){
            list.remove(t);
        }
        map.addAttribute("listtop",listtop);
        map.addAttribute("list",list);
        return "ziyuanmanager";
    }

    @GetMapping(value = "/disablesendmsg")
    public String disablesendmsg(Model map) {
//        List<Post> list = systemService.listPostOfForum("t2");
//        map.addAttribute("list",list);
        return "disablesendmsg";
    }

    @GetMapping(value = "/enablesendmsg")
    public String enablesendmsg(Model map) {
//        List<Post> list = systemService.listPostOfForum("t2");
//        map.addAttribute("list",list);
        return "enablesendmsg";
    }

    @GetMapping(value = "/showfloor")
    public String showFloor(Model map){
//        cusbService.replyPost();
        return "showfloor";
    }
}
