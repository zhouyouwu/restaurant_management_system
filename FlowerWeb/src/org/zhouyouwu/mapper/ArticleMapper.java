package org.zhouyouwu.mapper;

import org.zhouyouwu.beans.Article;

import java.util.List;

public interface ArticleMapper {
    public List<Article> getArticleList();
    public Article getArticleById(String articleId);
    public int addArticle(Article article);
    public int deleteArticle(String articleId);
}
