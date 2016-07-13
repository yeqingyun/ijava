package cn.ilovejava.controller;

import cn.ilovejava.entity.Module;
import cn.ilovejava.service.ModuleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import lombok.extern.log4j.Log4j;

/**
* Created by yeqy on 2016-07-13 16:35:11.
*/
@Log4j
@Controller
@RequestMapping("module")
public class ModuleController{
    @Resource
    private ModuleService<Module> moduleService;

    @RequestMapping("/list")
    public String moduleList(){
        return "module";
    }
}