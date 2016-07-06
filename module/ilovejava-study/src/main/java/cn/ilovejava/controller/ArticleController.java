package cn.ilovejava.controller;

import cn.ilovejava.entity.Article;
import cn.ilovejava.service.ArticleService;
import com.alibaba.fastjson.JSON;
import lombok.extern.log4j.Log4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
* Created by yeqy on 2016-06-30 15:15:35.
*/
@Log4j
@Controller
@RequestMapping("article")
public class ArticleController{
    @Resource
    private ArticleService<Article> articleService;

    @RequestMapping("/indexList")
    @ResponseBody
    public String articleList(){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(0, 10);
        return JSON.toJSONString(articleService.findOrderByPublishTimeDesc(pageable));
    }

    @RequestMapping(value = "/getById",method= RequestMethod.GET)
    public String get(long id,ModelMap modelMap){
        Article article = articleService.findById(id);
        modelMap.put("art", article);
        return "blog1";
    }


}