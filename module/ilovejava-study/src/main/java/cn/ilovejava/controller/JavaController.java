package cn.ilovejava.controller;

import cn.ilovejava.service.JavaService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
* Created by yeqy on 2016-06-26 20:21:08.
*/
@Log4j
@Controller
@RequestMapping("java")
public class JavaController{
    public static int onLineCount = 0;
    @Autowired
    private SimpMessagingTemplate messagingTemplate;
    @Resource
    private JavaService javaService;

    @RequestMapping("/list")
    public String javaList(){
        return "java";
    }

    @SubscribeMapping("/chat.participants")
    public int retrieveParticipants() {
        return onLineCount;
    }
}