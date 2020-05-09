package org.zhouyouwu.beans;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("Article")
public class Article {
    private String articleId;
    private String articleTitle;
    private String articleUrl;

    public Article() {
    }

    public Article(String articleId, String articleTitle, String articleUrl){
        this.articleId = articleId;
        this.articleTitle = articleTitle;
        this.articleUrl = articleUrl;
    }
}
