package com.example;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//UpdatePassServlet.java
@WebServlet("/upPassCheck")
public class updatePassServlet extends HttpServlet {

 @Override
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     String password1 = request.getParameter("password1");
     String password2 = request.getParameter("password2");

     if (password1 != null && password1.equals(password2)) {
         request.setAttribute("password", password1); // 一致した場合、パスワードをリクエストに設定
         request.getRequestDispatcher("upPassCheck.jsp").forward(request, response);
     } else {
         // 一致しない場合、エラーメッセージを設定して再度 `updatePass.jsp` に戻る
         request.setAttribute("errorMessage", "2つのパスワードが等しくありません。");
         request.getRequestDispatcher("updatePass.jsp").forward(request, response);
     }
 }
}
