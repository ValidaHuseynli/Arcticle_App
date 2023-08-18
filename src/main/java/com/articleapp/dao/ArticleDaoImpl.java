package com.articleapp.dao;

import com.articleapp.model.Article;
import com.articleapp.utill.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ArticleDaoImpl implements ArticleDao {

    @Override
    public void insertArticle(Article article) {
        String INSERT_ARTICLE = "INSERT INTO article(title, article, username) VALUES (?,?,?);";
        try {
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT_ARTICLE);
            statement.setString(1, article.getTitle());
            statement.setString(2, article.getArticle());
            statement.setString(3, article.getUsername());

            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Article> selectUserArticles(String username) {
        String SELECT_USER_TODOS_SQL = "SELECT id, title,article, username, created_at, updated_at FROM article WHERE username=?" +
                "ORDER BY created_at DESC, updated_at DESC";
        List<Article> articles = new ArrayList<>();
        try {
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_USER_TODOS_SQL);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Article article = new Article();
                article.setId(resultSet.getInt("id"));
                article.setTitle(resultSet.getString("title"));
                article.setArticle(resultSet.getString("article"));
                article.setUsername(resultSet.getString("username"));
                article.setCreated_at(resultSet.getDate("created_at").toLocalDate());
                article.setUpdated_at(resultSet.getDate("updated_at").toLocalDate());

                articles.add(article);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return articles;
    }

    @Override
    public List<Article> selectAllArticles() {
        String SELECT_All_Articles = "SELECT id, title,article, username, created_at, updated_at FROM article " +
                "ORDER BY created_at DESC, updated_at DESC";
        List<Article> articles = new ArrayList<>();
        try {
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_All_Articles);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Article article = new Article();
                article.setId(resultSet.getInt("id"));
                article.setTitle(resultSet.getString("title"));
                article.setArticle(resultSet.getString("article"));
                article.setUsername(resultSet.getString("username"));
                article.setCreated_at(resultSet.getDate("created_at").toLocalDate());
                article.setUpdated_at(resultSet.getDate("updated_at").toLocalDate());

                articles.add(article);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return articles;
    }

    @Override
    public Article getArticle(int id) {
        String GET_ARTICLE_SQL = "SELECT id, title, article, username FROM article WHERE id=? ";
        Article article=null;

        try{
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(GET_ARTICLE_SQL);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                article=new Article();
                article.setId(resultSet.getInt("id"));
                article.setTitle(resultSet.getString("title"));
                article.setArticle(resultSet.getString("article"));
                article.setUsername(resultSet.getString("username"));
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return article;
    }

    @Override
    public void updateArticle(Article article) {
        String UPDATE_ARTICLE="UPDATE article SET title=?, article=? WHERE id=?;";
        try{
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_ARTICLE);
            statement.setString(1, article.getTitle());
            statement.setString(2, article.getArticle());
            statement.setInt(3,article.getId());

            statement.executeUpdate();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteArticle(int id) {
        String DELETE_ARTICLE="DELETE FROM article WHERE id=?;";
        try{
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_ARTICLE);
            statement.setInt(1,id);
            statement.executeUpdate();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
