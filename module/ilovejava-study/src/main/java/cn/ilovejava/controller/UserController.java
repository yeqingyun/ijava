package cn.ilovejava.controller;

import cn.ilovejava.service.UserService;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
* Created by yeqy on 2016-06-26 20:21:14.
*/
@Log4j
@Controller
@RequestMapping("user")
public class UserController{
    @Resource
    private UserService userService;

    @RequestMapping("/list")
    public String userList(){
        return "user";
    }
}