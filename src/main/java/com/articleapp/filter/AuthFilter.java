package com.articleapp.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter(filterName ="AuthFilter", urlPatterns ="/user/*" )
public class AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse httpResponse=(HttpServletResponse)response;
        HttpServletRequest httpRequest=(HttpServletRequest)request;
        HttpSession session = httpRequest.getSession();
        if(session!=null){
            String name = (String) session.getAttribute("name");
            String username = (String) session.getAttribute("username");
            if(name!=null && username!=null){
                filterChain.doFilter(request,response);
            }else httpResponse.sendRedirect(httpRequest.getContextPath()+"/login.jsp");
        }else  httpResponse.sendRedirect(httpRequest.getContextPath()+"/login.jsp");
    }
}
