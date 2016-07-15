package cn.ilovejava.controller;

import cn.ilovejava.entity.User;
import cn.ilovejava.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import lombok.extern.log4j.Log4j;

/**
* Created by yeqy on 2016-07-15 16:59:24.
*/
@Log4j
@Controller
@RequestMapping("user")
public class UserController{
    @Resource
    private UserService<User> userService;

    @RequestMapping("/list")
    public String userList(){
        return "user";
    }
}