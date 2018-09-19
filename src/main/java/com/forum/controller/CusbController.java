package com.forum.controller;

import com.forum.common.ForumException;
import com.forum.common.ForumResult;
import com.forum.entity.*;
import com.forum.common.ForumResultCode;
import com.forum.dao.PostMapper;
import com.forum.dao.UserMapper;
import com.forum.entity.Forum;
import com.forum.entity.User;
import com.forum.service.api.CusbService;
import com.forum.service.api.ManagerService;
import com.forum.service.api.SystemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
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
    @Autowired
    PostMapper postDao;

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

    @ResponseBody
    @RequestMapping("/disablesendmsg")
    public String disablesendmsg(@RequestParam String userId, @RequestParam String forumId) {
        managerService.noSpeaking(userId, 2);
        return "成功";
    }

    @ResponseBody
    @RequestMapping("/enablesendmsg")
    public String enablesendmsg(@RequestParam String userId, @RequestParam String forumId) {
        managerService.noSpeaking(userId, 1);
        return "成功";
    }

    @ResponseBody
    @RequestMapping("/deletePost")
    public String deletePost(@RequestParam String postId) {
        System.out.println(postId);
        managerService.deletePost(postId);
        return "成功";
    }

    @ResponseBody
    @RequestMapping("/setPostTop")
    public String setPostTop(@RequestParam String postId) {
        managerService.setPostTop(postId);
        return "成功";
    }

    @RequestMapping("/updatePostPage")
    public String updatePostPage(@RequestParam String postId) {

        Post post;
        post = postDao.selectByPrimaryKey(postId);

        return "成功";
    }


}