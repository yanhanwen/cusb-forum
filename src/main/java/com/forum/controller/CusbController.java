package com.forum.controller;

import com.forum.common.ForumException;
import com.forum.common.ForumResult;
import com.forum.common.ForumResultCode;
import com.forum.entity.Forum;
import com.forum.entity.User;
import com.forum.service.api.CusbService;
import com.forum.service.api.ManagerService;
import com.forum.dao.UserMapper;
import com.forum.service.api.SystemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/cusb-forum")
public class CusbController {
    @Autowired
    CusbService cusbService;
    @Autowired
    ManagerService managerService;
    @Autowired
    SystemService systemService;
    @Autowired
    UserMapper userDao;

    Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping(value = "/index")
    public String index(Model map) {
        List<User> list = cusbService.getActiveUserList();
        List<String> nameList = new ArrayList<>();
        for(User f:list){
            nameList.add(f.getUserName());
        }
        map.addAttribute("activeuserlist",nameList);
        return "index";
    }

    @RequestMapping("/login")
    public String login(@RequestParam String userId, @RequestParam String userPwd) {
        int result = cusbService.login(userId, userPwd);
        return "login";
    }

    @ResponseBody
    @RequestMapping("/regist")
    public String regist(@RequestParam String userId, @RequestParam String userPwd, @RequestParam String userName,
                         @RequestParam String sex, @RequestParam String age, @RequestParam String userAdd,
                         @RequestParam String userMail, @RequestParam String phone) {
        User user = new User();
        try{
            user.setLevel(0);//0为普通用户
            user.setStatus(1);//1为登陆状态
            if(userDao.selectByPrimaryKey(userId) != null){
                return "id重复";//重复
            }
            user.setUserId(userId);
            user.setUserPwd(userPwd);
            user.setUserName(userName);
            Integer t = Integer.parseInt(age);
            user.setAge(t);
            if(t<0){
                return "年龄错误";
            }
            if(sex != null && sex.equals("男")){
                user.setSex(0);
            } else if (sex != null && sex.equals("女")){
                user.setSex(1);
            } else {
                throw new ForumException(ForumResultCode.PARAM_INVALID);
            }
            user.setUserAdd(userAdd);
            user.setUserMail(userMail);
            user.setPhone(phone);
            cusbService.regist(user);
        } catch (Exception e) {
            logger.info("param has null userId:{}",userId);
            return "参数错误";//错误
        }
        return "成功";
    }
    @PostMapping("/newForum")
    public void newForum(@RequestParam String forumName, @RequestParam String forumText,
                         @RequestParam String fid){
        Forum forum=new Forum();
        try{
            String forumId = UUID.randomUUID().toString().replaceAll("-", "");
            forum.setForumId(forumId);
            forum.setForumName(forumName);
            forum.setForumText(forumText);
            forum.setFid(fid);
        } catch (Exception e) {
            throw new ForumException(ForumResultCode.PARAM_MISS);
        }
        managerService.adminAddForum(forum);
    }

    @PostMapping("/deleteForum")
    public void deleteForum(@RequestParam String forumId){

        managerService.adminDeleteForum(forumId);
    }

    @PostMapping("/changeForum")
    public void changeForum(@RequestParam String forumId,@RequestParam String forumName, @RequestParam String forumText,
                         @RequestParam String fid){
        Forum forum=new Forum();
        try{
            forum.setForumId(forumId);
            forum.setForumName(forumName);
            forum.setForumText(forumText);
            forum.setFid(fid);
        } catch (Exception e) {
            throw new ForumException(ForumResultCode.PARAM_MISS);
        }
        managerService.adminChangeForum(forum);
    }


    @PostMapping("/logout")
    public void logout(@RequestParam String userId){
        int result = cusbService.logout(userId);
    }

    @GetMapping("/ActiveUserList")
    public List<User> getActiveUserList(){
        return cusbService.getActiveUserList();
    }



    @GetMapping(value = {"personal_center"})
    public String getUserInfo(Model map)
    {
        User user;
        user = cusbService.getUserById("1");
        map.addAttribute("id", user.getUserId());
        map.addAttribute("name", user.getUserName());
        if(user.getSex() == 0)
        {
            map.addAttribute("sex", "男");
        }
        else
        {
            map.addAttribute("sex", "女");
        }
        map.addAttribute("age", user.getAge());
        map.addAttribute("addr", user.getUserAdd());
        map.addAttribute("email", user.getUserMail());
        map.addAttribute("phone", user.getPhone());
        return "personal_center";
    }

    @GetMapping(value = {"modify"})
    public String getModifyInfo(Model map)
    {
        User user;
        user = cusbService.getUserById("1");
        map.addAttribute("id", user.getUserId());
        map.addAttribute("name", user.getUserName());
        if(user.getSex() == 0)
        {
            map.addAttribute("sex", "男");
        }
        else
        {
            map.addAttribute("sex", "女");
        }
        map.addAttribute("age", user.getAge());
        map.addAttribute("addr", user.getUserAdd());
        map.addAttribute("email", user.getUserMail());
        map.addAttribute("phone", user.getPhone());
        return "modify";
    }


    @RequestMapping("/modifyUserInfo")
    public String modifyUserInfo(@RequestParam String userName,
                         @RequestParam String sex, @RequestParam String age, @RequestParam String userAdd,
                         @RequestParam String userMail, @RequestParam String phone) {
        User user;
        user = cusbService.getUserById("1");
        try{
            user.setUserName(userName);
            Integer t = Integer.parseInt(age);
            user.setAge(t);
            if(t<0){
                return "年龄错误";
            }
            if(sex != null && sex.equals("男"))
            {
                user.setSex(0);
            }
            else if(sex != null && sex.equals("女"))
            {
                user.setSex(1);
            }
            else
            {
                throw new ForumException(ForumResultCode.PARAM_INVALID);
            }
            user.setUserAdd(userAdd);
            user.setUserMail(userMail);
            user.setPhone(phone);
            cusbService.modifyInfo(user);
        } catch (Exception e) {
            return "参数错误";//错误
        }
        return "redirect:personal_center";
    }

    @GetMapping(value = "new-post")
    public String postAPost(Model map)
    {
        return "new-post";
    }

    @RequestMapping("/newPost")
    public String newPost(@RequestParam String title, @RequestParam String content, @RequestParam String forum)
    {
        String postId = cusbService.faPost("1", forum, title);
        cusbService.replyPost("1", postId, content);
        return "redirect:personal_center";
    }




    @ExceptionHandler(ForumException.class)
    @ResponseBody
    public ForumResult<Map<String, Object>> ForumExceptionHandler(ForumException e) {
        logger.warn("error code:{}, message:{}", e.getCode(),e.getMessage());

        Map<String, Object> errorData = new HashMap<>();
        errorData.put("errCode", e.getCode());
        errorData.put("errMsg", e.getMessage());

        ForumResult result = new ForumResult<>(errorData);
        return result;
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ForumResult runtimeExceptionHanlder(RuntimeException e){
        logger.error("error: ", e);
        return new ForumResult(ForumResultCode.SERVER_ERROR);
    }
}