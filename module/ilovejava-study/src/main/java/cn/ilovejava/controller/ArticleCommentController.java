package cn.ilovejava.controller;

import cn.ilovejava.entity.ArticleComment;
import cn.ilovejava.service.ArticleCommentService;
import com.alibaba.fastjson.JSON;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* Created by yeqy on 2016-07-13 16:35:11.
*/
@Log4j
@Controller
@RequestMapping("articleComment")
public class ArticleCommentController{
    @Resource
    private ArticleCommentService<ArticleComment> articleCommentService;

    @RequestMapping(value = "/list/{articleId}",method=RequestMethod.GET)
    @ResponseBody
    public String articleCommentList(@PathVariable("articleId") long id){
        List<ArticleComment> list = articleCommentService.findArticleCommentByArticleIdOrderByDate(id);
        return JSON.toJSONString(list);
    }

    @RequestMapping(value = "/commitComment",method= RequestMethod.POST)//
    @ResponseBody
    public String commitComment(ArticleComment articleComment,HttpServletRequest request){
        if(articleComment.getArticle().getId()==null){
            //return JSON.toJSONString(new JsonResult(false,"文章不存在"));
            return "false";
        }
        String tempName = request.getRemoteAddr();
        articleComment.setName(tempName);
        articleComment.setIsTourist(true);
        articleCommentService.insert(articleComment);
        //List<ArticleComment> list = articleCommentService.findArticleCommentByArticleIdOrderByDate(articleComment.getArticle().getId());
        //return JSON.toJSONString(new JsonResult(true,"评论成功"));
        return "true";
    }




    @ExceptionHandler
    public void exceptionHandler(Exception ex){
        ex.printStackTrace();
    }
}