package com.articleapp.controller;

import com.articleapp.dao.UserDaoImpl;
import com.articleapp.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterController", value = "/register")
public class RegisterController extends HttpServlet {
    private UserDaoImpl userDao;

    @Override
    public void init() {
        userDao=new UserDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("register.jsp");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user=new User();
        user.setName(name);
        user.setSurname(surname);
        user.setUsername(username);
        user.setPassword(password);

        try{
            userDao.register(user);
            request.getSession().setAttribute("name", name);
            request.getSession().setAttribute("username", username);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        response.sendRedirect("user/article");
    }
}
