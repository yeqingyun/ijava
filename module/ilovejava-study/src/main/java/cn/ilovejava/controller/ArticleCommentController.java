package cn.ilovejava.controller;

import cn.ilovejava.entity.Article;
import cn.ilovejava.entity.ArticleComment;
import cn.ilovejava.service.ArticleCommentService;
import cn.ilovejava.service.ArticleService;
import cn.ilovejava.util.JsonResult;
import com.alibaba.fastjson.JSON;
import lombok.extern.log4j.Log4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by yeqy on 2016-07-13 16:35:11.
 */
@Log4j
@Controller
@RequestMapping("articleComment")
public class ArticleCommentController{
    @Resource
    private ArticleCommentService<ArticleComment> articleCommentService;
    @Resource
    private ArticleService<Article> articleService;

    @RequestMapping(value = "/list/{articleId}/{page}",method=RequestMethod.GET)
    @ResponseBody
    public String articleCommentList(@PathVariable("articleId") long id,@PathVariable("page")Integer page){
        //List<ArticleComment> list = articleCommentService.findArticleCommentByArticleIdOrderByDate(id);
        Pageable pageable = new PageRequest(page, 7);
        Page<ArticleComment> pageResult =  articleCommentService.findByArticleIdOrderByPublishTimeDesc(id,pageable);
        return JSON.toJSONString(pageResult);
    }

    @RequestMapping(value = "/commitComment",method= RequestMethod.POST)//
    @ResponseBody
    public String commitComment(ArticleComment articleComment,HttpServletRequest request){
        if(articleComment.getArticle()==null || articleComment.getArticle().getId() == null || articleService.findById(articleComment.getArticle().getId())== null){
            JsonResult jr = new JsonResult(false,"文章不存在或者已被删除");
            return JSON.toJSONString(jr);
            //return "false";
        }
        String tempName = request.getRemoteAddr();
        articleComment.setName(tempName);
        articleComment.setIsTourist(true);
        articleCommentService.insert(articleComment);
        return JSON.toJSONString(new JsonResult(true));
    }




    @ExceptionHandler
    public void exceptionHandler(Exception ex){
        ex.printStackTrace();
    }
}