package cn.ilovejava.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* Created by yeqy on 2016-06-30 15:15:35.
*/
@Log4j
@Controller
@RequestMapping("helloMessage")
public class HelloMessageController{
    @RequestMapping("/list")
    public String helloMessageList(){
        return "helloMessage";
    }
}