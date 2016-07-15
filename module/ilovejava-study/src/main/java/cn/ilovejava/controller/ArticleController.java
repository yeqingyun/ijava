package cn.ilovejava.controller;

import cn.ilovejava.constant.BlogModule;
import cn.ilovejava.entity.Article;
import cn.ilovejava.function.SerializeFunction;
import cn.ilovejava.service.ArticleService;
import cn.ilovejava.util.JsonResult;
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
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

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
    public String indexJavaBlogList(){
        Pageable pageable = new PageRequest(0, 10);
        return JSON.toJSONString(articleService.findByModuleCodeOrderByPublishTimeDesc(BlogModule.blog_java.name(), pageable).getContent());
    }

    @RequestMapping(value = "/IndexJavaScriptBlogList",method=RequestMethod.GET)
    @ResponseBody
    public String indexJavaScriptBlogList(){
        Pageable pageable = new PageRequest(0, 10);
        return JSON.toJSONString(articleService.findByModuleCodeOrderByPublishTimeDesc(BlogModule.blog_javaScript.name(),pageable).getContent());
    }
    @RequestMapping(value = "/IndexLinuxBlogList",method=RequestMethod.GET)
    @ResponseBody
    public String indexLinuxBlogList(){
        Pageable pageable = new PageRequest(0, 10);
        return JSON.toJSONString(articleService.findByModuleCodeOrderByPublishTimeDesc(BlogModule.blog_linux.name(),pageable).getContent());
    }
    @RequestMapping(value = "/IndexDataStructureBlogList",method=RequestMethod.GET)
    @ResponseBody
    public String indexDataStructureBlogList(){
        Pageable pageable = new PageRequest(0, 10);
        return JSON.toJSONString(articleService.findByModuleCodeOrderByPublishTimeDesc(BlogModule.blog_dataStructure.name(),pageable).getContent());
    }

    @RequestMapping(value = "/IndexArithmeticBlogList",method=RequestMethod.GET)
    @ResponseBody
    public String indexArithmeticBlogList(){
        Pageable pageable = new PageRequest(0, 10);
        return JSON.toJSONString(articleService.findByModuleCodeOrderByPublishTimeDesc(BlogModule.blog_arithmetic.name(),pageable).getContent());
    }
    @RequestMapping(value = "/IndexDatabaseBlogList",method=RequestMethod.GET)
    @ResponseBody
    public String indexDatabaseBlogList(){
        Pageable pageable = new PageRequest(0, 10);
        return JSON.toJSONString(articleService.findByModuleCodeOrderByPublishTimeDesc(BlogModule.blog_database.name(),pageable).getContent());
    }
    @RequestMapping(value = "/IndexProgrammingIdeaBlogList",method=RequestMethod.GET)
    @ResponseBody
    public String indexProgrammingIdeaBlogList(){
        Pageable pageable = new PageRequest(0, 10);
        return JSON.toJSONString(articleService.findByModuleCodeOrderByPublishTimeDesc(BlogModule.blog_programmingIdea.name(),pageable).getContent());
    }
    @RequestMapping(value = "/IndexOperatingSystemBlogList",method=RequestMethod.GET)
    @ResponseBody
    public String indexOperatingSystemBlogList(){
        Pageable pageable = new PageRequest(0, 10);
        return JSON.toJSONString(articleService.findByModuleCodeOrderByPublishTimeDesc(BlogModule.blog_operatingSystem.name(),pageable).getContent());
    }
    @RequestMapping(value = "/IndexPageDesignBlogList",method=RequestMethod.GET)
    @ResponseBody
    public String indexPageDesignBlogList(){
        Pageable pageable = new PageRequest(0, 10);
        return JSON.toJSONString(articleService.findByModuleCodeOrderByPublishTimeDesc(BlogModule.blog_pageDesign.name(),pageable).getContent());
    }
    @RequestMapping(value = "/IndexWelcomeBlogList",method=RequestMethod.GET)
    @ResponseBody
    public String indexWelcomeBlogList(){
        Pageable pageable = new PageRequest(0, 10);
        return JSON.toJSONString(articleService.findOrderByLikeDesc(pageable).getContent());
    }

    @RequestMapping(value = "/IndexAllBlogList",method=RequestMethod.GET)
    @ResponseBody
    public String indexAllBlogList(){
        Pageable pageable = new PageRequest(0, 10);
        return JSON.toJSONString(articleService.findByModuleCodeOrderByPublishTimeDesc(BlogModule.blog_pageDesign.name(), pageable).getContent());
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
        article.setViewCount(article.getViewCount() + 1);
        articleService.update(article);
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
        modelMap.put("currentPage", page + 1);
        modelMap.put("totalPage", pageResult.getTotalPages());
        modelMap.put("type",type);
        for(Article article:pageResult.getContent()){
            String articleContent = filterHtml(article.getContent().getContentText());
            article.getContent().setContentText(articleContent);
        }
        return "more";
    }

    @RequestMapping(value="/blog/like",method=RequestMethod.POST)
    @ResponseBody
    public String more(long id,boolean like,HttpServletRequest request) throws IOException, ClassNotFoundException {
        String name = request.getRemoteAddr();
        JsonResult jr = new JsonResult();
        int result = SerializeFunction.likeAndIpAuth(id, name, like);
        if(result == 0){//之前不存在的
            Article article = articleService.findById(id);
            if(like){
                article.setLike(article.getLike()+1);
            }else{
                article.setDislike(article.getDislike()+1);
            }
            articleService.update(article);
            jr.setSuccess(true);
            jr.setMsg(like ? "看得出来，你很喜欢" : "很遗憾，下次你会喜欢的");
            //List<Long[]> ls = articleService.findLikeAndDisLikeById(id);
            jr.addData("like",article.getLike());
            jr.addData("dislike",article.getDislike());
        }else if(result == 1 && like){//已经喜欢过
            jr.setSuccess(false);
            jr.setMsg("你也太喜欢了...");
        }else if(result == 2 && !like){//已经不喜欢过
            jr.setSuccess(false);
            jr.setMsg("不至于这么讨厌吧");
        }else if(result == 1){//已经喜欢过了，又点击不喜欢
            jr.setSuccess(false);
            jr.setMsg("你已经喜欢过了，不能反悔哦");
        }else if(result == 2){//已经不喜欢过了，又点击喜欢
            jr.setSuccess(false);
            jr.setMsg("你已经讨厌过了，不能反悔哦");
        }
        return JSON.toJSONString(jr);
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