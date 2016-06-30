package cn.ilovejava.controller;

import cn.ilovejava.entity.Greeting;
import cn.ilovejava.entity.HelloMessage;
import lombok.extern.log4j.Log4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
 
@Controller
@Log4j
public class GreetingController {
 
 
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        //log.info("socket in ");
        return new Greeting(message.getName());
    }
 
}