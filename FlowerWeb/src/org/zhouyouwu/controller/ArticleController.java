package org.zhouyouwu.controller;

import lombok.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zhouyouwu.beans.Article;
import org.zhouyouwu.service.ArticleService;

import javax.validation.Valid;

/**用于获取数据库中文章信息
 *
 */
@Controller
public class ArticleController {
    @ResponseBody
    @RequestMapping(value = "/getArticle", method = RequestMethod.GET)
    public String getArticle(){
        ArticleService articleService = new ArticleService();
        String json = articleService.getArticleList();
        System.out.println(json);
        return json;
    }

    @Valid
    @RequestMapping(value = "/addArticle", method = RequestMethod.POST)
    public String addArticle(@NonNull Article article, Model model){
        ArticleService articleService = new ArticleService();
        if(articleService.addArticle(article)){
            model.addAttribute("message","ok");
            System.out.println("ok");
            return "result";
        }
        model.addAttribute("message","err");
        System.out.println("err");
        return "result";
    }

    @RequestMapping(value = "/addArticle", method = RequestMethod.GET)
    public String addArticle(){
        return "addArticle";
    }
}
