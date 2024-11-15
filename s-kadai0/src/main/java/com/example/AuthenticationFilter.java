package com.example;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
@WebFilter("/*") // すべてのリクエストに対してフィルタを適用
public class AuthenticationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession(false);

        String loginURI = httpRequest.getContextPath() + "/index.jsp";
        String loginServletURI = httpRequest.getContextPath() + "/login";

        boolean loggedIn = (session != null && session.getAttribute("userId") != null);
        boolean loginRequest = httpRequest.getRequestURI().equals(loginURI) || httpRequest.getRequestURI().equals(loginServletURI);

        if (loggedIn || loginRequest) {
            chain.doFilter(request, response); // 認証済み、またはログインページへのリクエストなら通過
        } else {
            httpResponse.sendRedirect(loginURI); // 認証されていない場合はログインページへリダイレクト
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void destroy() {}
}