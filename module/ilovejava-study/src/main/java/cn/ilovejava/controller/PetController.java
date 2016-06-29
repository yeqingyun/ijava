package cn.ilovejava.controller;

import cn.ilovejava.service.PetService;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
* Created by yeqy on 2016-06-26 20:20:57.
*/
@Log4j
@Controller
@RequestMapping("pet")
public class PetController{
    @Resource
    private PetService petService;

    @RequestMapping("/list")
    public String petList(){
        return "pet";
    }
}