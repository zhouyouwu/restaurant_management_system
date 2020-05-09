package org.zhouyouwu.service;

import com.google.gson.Gson;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.zhouyouwu.beans.Article;
import org.zhouyouwu.mapper.ArticleMapper;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class ArticleService {
    private SqlSession mSqlSession;
    private Gson mGson;

    public ArticleService(){
        try {
            String resource = "/mybatis-config.xml";
            Reader reader = Resources.getResourceAsReader(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            mSqlSession = sqlSession;
        }catch (IOException e){
            e.printStackTrace();
        }
        Gson gson = new Gson();
        mGson = gson;
    }
    /**用于从数据库读取文章链接返回
     * @return json
     */
    public String getArticleList(){
        ArticleMapper articleMapper = mSqlSession.getMapper(ArticleMapper.class);
        List<Article> articleList = articleMapper.getArticleList();
        String json = mGson.toJson(articleList);
        mSqlSession.close();
        return json;
    }

    /**通过id读文章信息
     *
     * @param articleId
     * @return
     */
    public String getArticleById(String articleId){
        ArticleMapper articleMapper = mSqlSession.getMapper(ArticleMapper.class);
        Article article = articleMapper.getArticleById(articleId);
        String json = mGson.toJson(article);
        mSqlSession.close();
        return json;
    }

    /**添加文章信息，返回成功与否的信息
     * @param article
     * @return boolean
     */
    public boolean addArticle(Article article){
        ArticleMapper articleMapper = mSqlSession.getMapper(ArticleMapper.class);
        if(articleMapper.addArticle(article) > 0){
            mSqlSession.commit();
            mSqlSession.close();
            return true;
        }
        mSqlSession.close();
        return false;
    }

    /**删除文章信息
     *
     * @param articleId
     * @return
     */
    public boolean deleteArticle(String articleId){
        ArticleMapper articleMapper = mSqlSession.getMapper(ArticleMapper.class);
        if(articleMapper.deleteArticle(articleId) > 0){
            mSqlSession.commit();
            mSqlSession.close();
            return true;
        }
        mSqlSession.close();
        return false;
    }
}
