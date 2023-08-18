package com.articleapp.controller;

import com.articleapp.dao.UserDaoImpl;
import com.articleapp.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {
    private UserDaoImpl userDao;
    @Override
    public void init() {
        userDao = new UserDaoImpl();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password =request.getParameter("password");
        User user = userDao.getUser(username, password);
        if(user!=null){
            request.getSession().setAttribute("name",user.getName());
            request.getSession().setAttribute("username",user.getUsername());
            response.sendRedirect("user/article");
        }else{
            request.setAttribute("loginError", "Username or Password is incorrect!");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }
}
