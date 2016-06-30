package cn.ilovejava.controller;

import cn.ilovejava.entity.ArticleContent;
import cn.ilovejava.service.ArticleContentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import lombok.extern.log4j.Log4j;

/**
* Created by yeqy on 2016-06-30 15:15:35.
*/
@Log4j
@Controller
@RequestMapping("articleContent")
public class ArticleContentController{
    @Resource
    private ArticleContentService articleContentService;

    @RequestMapping("/list")
    public String articleContentList(){
        return "articleContent";
    }
}