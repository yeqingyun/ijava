package cn.ilovejava.controller;

import cn.ilovejava.entity.ArticleContent;
import cn.ilovejava.service.ArticleContentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import lombok.extern.log4j.Log4j;

/**
* Created by yeqy on 2016-07-15 16:59:25.
*/
@Log4j
@Controller
@RequestMapping("articleContent")
public class ArticleContentController{
    @Resource
    private ArticleContentService<ArticleContent> articleContentService;

    @RequestMapping("/list")
    public String articleContentList(){
        return "articleContent";
    }
}