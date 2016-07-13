package cn.ilovejava.controller;

import cn.ilovejava.constant.BlogModule;
import cn.ilovejava.entity.Article;
import cn.ilovejava.service.ArticleService;
import com.alibaba.fastjson.JSON;
import lombok.extern.log4j.Log4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

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


    /**
     * 加载首页各个博客模块的展示数据
     * @return DataJson
     */
    @RequestMapping(value = "/IndexJavaBlogList",method=RequestMethod.GET)
    @ResponseBody
    public String IndexJavaBlogList(){
        Pageable pageable = new PageRequest(0, 10);
        return JSON.toJSONString(articleService.findByModuleCodeOrderByPublishTimeDesc(BlogModule.blog_java.name(), pageable).getContent());
    }

    @RequestMapping(value = "/IndexJavaScriptBlogList",method=RequestMethod.GET)
    @ResponseBody
    public String IndexJavaScriptBlogList(){
        Pageable pageable = new PageRequest(0, 10);
        return JSON.toJSONString(articleService.findByModuleCodeOrderByPublishTimeDesc(BlogModule.blog_javaScript.name(),pageable).getContent());
    }
    @RequestMapping(value = "/IndexLinuxBlogList",method=RequestMethod.GET)
    @ResponseBody
    public String IndexLinuxBlogList(){
        Pageable pageable = new PageRequest(0, 10);
        return JSON.toJSONString(articleService.findByModuleCodeOrderByPublishTimeDesc(BlogModule.blog_linux.name(),pageable).getContent());
    }
    @RequestMapping(value = "/IndexDataStructureBlogList",method=RequestMethod.GET)
    @ResponseBody
    public String IndexDataStructureBlogList(){
        Pageable pageable = new PageRequest(0, 10);
        return JSON.toJSONString(articleService.findByModuleCodeOrderByPublishTimeDesc(BlogModule.blog_dataStructure.name(),pageable).getContent());
    }

    @RequestMapping(value = "/IndexArithmeticBlogList",method=RequestMethod.GET)
    @ResponseBody
    public String IndexArithmeticBlogList(){
        Pageable pageable = new PageRequest(0, 10);
        return JSON.toJSONString(articleService.findByModuleCodeOrderByPublishTimeDesc(BlogModule.blog_arithmetic.name(),pageable).getContent());
    }
    @RequestMapping(value = "/IndexDatabaseBlogList",method=RequestMethod.GET)
    @ResponseBody
    public String IndexDatabaseBlogList(){
        Pageable pageable = new PageRequest(0, 10);
        return JSON.toJSONString(articleService.findByModuleCodeOrderByPublishTimeDesc(BlogModule.blog_database.name(),pageable).getContent());
    }
    @RequestMapping(value = "/IndexProgrammingIdeaBlogList",method=RequestMethod.GET)
    @ResponseBody
    public String IndexProgrammingIdeaBlogList(){
        Pageable pageable = new PageRequest(0, 10);
        return JSON.toJSONString(articleService.findByModuleCodeOrderByPublishTimeDesc(BlogModule.blog_programmingIdea.name(),pageable).getContent());
    }
    @RequestMapping(value = "/IndexOperatingSystemBlogList",method=RequestMethod.GET)
    @ResponseBody
    public String IndexOperatingSystemBlogList(){
        Pageable pageable = new PageRequest(0, 10);
        return JSON.toJSONString(articleService.findByModuleCodeOrderByPublishTimeDesc(BlogModule.blog_operatingSystem.name(),pageable).getContent());
    }
    @RequestMapping(value = "/IndexPageDesignBlogList",method=RequestMethod.GET)
    @ResponseBody
    public String IndexPageDesignBlogList(){
        Pageable pageable = new PageRequest(0, 10);
        return JSON.toJSONString(articleService.findByModuleCodeOrderByPublishTimeDesc(BlogModule.blog_pageDesign.name(),pageable).getContent());
    }

    @RequestMapping(value = "/IndexAllBlogList",method=RequestMethod.GET)
    @ResponseBody
    public String IndexAllBlogList(){
        Pageable pageable = new PageRequest(0, 10);
        return JSON.toJSONString(articleService.findByModuleCodeOrderByPublishTimeDesc(BlogModule.blog_pageDesign.name(),pageable).getContent());
    }


    /**
     * 通过id读取文章跳转到文章页
     * @param id
     * @param modelMap
     * @return
     */
    @RequestMapping(value="/blog/{id}",method=RequestMethod.GET)
    public String get(@PathVariable("id") long id,ModelMap modelMap){
        Article article = articleService.findById(id);
        modelMap.put("art", article);
        return "blog";
    }

    /**
     * 通过类型读取文章跳转到“更多”页
     * @param type 类型
     * @param modelMap
     * @return
     */
    @RequestMapping(value="/blog/more/{type}/{page}",method=RequestMethod.GET)
    public String more(@PathVariable("type") String type,@PathVariable(value = "page") Integer page,ModelMap modelMap){
        Page<Article> pageResult ;
        int size = 7;
        Pageable pageParam = new PageRequest(page, size);
        Long l = System.currentTimeMillis();
        if(!StringUtils.isEmpty(type)&&type.equals("new"))
            pageResult = articleService.findOrderByPublishTimeDesc(pageParam);
        else
            pageResult = articleService.findByModuleCodeOrderByPublishTimeDesc(type, pageParam);
        System.out.println(System.currentTimeMillis()-l);
        modelMap.put("page", pageResult);
        modelMap.put("currentPage", page+1);
        modelMap.put("totalPage",pageResult.getTotalPages());
        modelMap.put("type",type);
        for(Article article:pageResult.getContent()){
            String articleContent = filterHtml(article.getContent().getContentText());
            article.getContent().setContentText(articleContent);
        }
        return "more";
    }

    private String filterHtml(String s){
        if(!StringUtils.isEmpty(s)){
            String str=s.replaceAll("<[.[^<]]*>","");
            return str;
        }else{
            return s;
        }
    }


    @ExceptionHandler
    public void exceptionHandler(Exception ex){
        ex.printStackTrace();
    }
}