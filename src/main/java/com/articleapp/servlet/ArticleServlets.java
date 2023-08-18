package com.articleapp.servlet;

import com.articleapp.dao.ArticleDaoImpl;
import com.articleapp.model.Article;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ArticleServlets", value = "/user/article")
public class ArticleServlets extends HttpServlet {
    private ArticleDaoImpl articleDao;

    @Override
    public void init() {

        articleDao=new ArticleDaoImpl();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/article.jsp").forward(request,response);
    }


}
