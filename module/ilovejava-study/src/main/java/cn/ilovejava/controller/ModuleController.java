package cn.ilovejava.controller;

import cn.ilovejava.service.ModuleService;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
* Created by yeqy on 2016-06-26 20:21:17.
*/
@Log4j
@Controller
@RequestMapping("module")
public class ModuleController{
    @Resource
    private ModuleService moduleService;

    @RequestMapping("/list")
    public String moduleList(){
        return "module";
    }
}