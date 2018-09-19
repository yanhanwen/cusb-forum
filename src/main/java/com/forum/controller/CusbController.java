package com.forum.controller;

import com.forum.common.ForumException;
import com.forum.common.ForumResult;
import com.forum.common.ForumResultCode;
import com.forum.entity.Forum;
import com.forum.entity.User;
import com.forum.service.api.CusbService;
import com.forum.service.api.ManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/cusb-forum")
public class CusbController {
    @Autowired
    CusbService cusbService;
    @Autowired
    ManagerService managerService;

    Logger logger = LoggerFactory.getLogger(getClass());

    @PostMapping("/login")
    public void login(@RequestParam String userId, @RequestParam String userPwd) {
        int result = cusbService.login(userId, userPwd);
        //todo,页面跳转逻辑，和返回信息
    }

    @PostMapping("/regist")
    public void regist(@RequestParam String userId, @RequestParam String userPwd,@RequestParam String userName,
                       @RequestParam int sex,@RequestParam int age,@RequestParam String userAdd,
                       @RequestParam String userMail,@RequestParam String phone) {
        User user = new User();
        try{
            user.setLevel(0);//0为普通用户
            user.setStatus(1);//1为登陆状态
            user.setUserId(userId);
            user.setUserPwd(userPwd);
            user.setUserName(userName);
            user.setSex(sex);
            user.setAge(age);
            user.setUserAdd(userAdd);
            user.setUserMail(userMail);
            user.setPhone(phone);
        } catch (Exception e) {
            logger.info("param has null userId:{}",userId);
            throw new ForumException(ForumResultCode.PARAM_MISS);
        }
        int result = cusbService.regist(user);
        //todo,页面跳转逻辑，和返回信息
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