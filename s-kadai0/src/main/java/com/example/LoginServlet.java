package com.example;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
 private static final long serialVersionUID = 1L;

 @Override
 protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
     // リクエストからユーザーIDとパスワードを取得
     String userId = request.getParameter("userId");
     String password = request.getParameter("password");

     // パスワードが"pass"かどうかをチェック
     if ("pass".equals(password)) {
         // 認証成功時、ユーザーIDをリクエスト属性に設定し、mainPage.jspにフォワード
         request.setAttribute("userId", userId);
         request.getRequestDispatcher("mainPage.jsp").forward(request, response);
     } else {
         // 認証失敗時、errorPage.jspにフォワード
         request.getRequestDispatcher("errorPage.jsp").forward(request, response);
     }
 }
}

