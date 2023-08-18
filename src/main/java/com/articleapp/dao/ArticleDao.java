package com.articleapp.dao;

import com.articleapp.model.Article;

import java.util.List;

public interface ArticleDao {
    void insertArticle(Article article);
    List<Article> selectUserArticles(String username);
    List<Article> selectAllArticles();
   Article getArticle(int id);
    void updateArticle(Article todo);
    void deleteArticle(int id);
}
