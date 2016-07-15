package cn.ilovejava.controller;

import cn.ilovejava.entity.UserDiligence;
import cn.ilovejava.service.UserDiligenceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import lombok.extern.log4j.Log4j;

/**
* Created by yeqy on 2016-07-15 16:59:25.
*/
@Log4j
@Controller
@RequestMapping("userDiligence")
public class UserDiligenceController{
    @Resource
    private UserDiligenceService<UserDiligence> userDiligenceService;

    @RequestMapping("/list")
    public String userDiligenceList(){
        return "userDiligence";
    }
}