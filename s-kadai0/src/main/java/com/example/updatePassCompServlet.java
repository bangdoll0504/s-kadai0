package com.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class updatePassCompServlet
 */
@WebServlet("/upPassComp")
public class updatePassCompServlet extends HttpServlet {
 private static final String DB_URL = "jdbc:mysql://localhost:3306/account";
 private static final String DB_USER = "root";
 private static final String DB_PASSWORD = "password";

 @Override
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     // レスポンスのエンコーディングを設定
     response.setContentType("text/html; charset=UTF-8");
     response.setCharacterEncoding("UTF-8");

     String password = request.getParameter("password");
     String userId = "admin";
     // MySQL JDBC ドライバをロード
     try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e) {
        e.printStackTrace();
        response.getWriter().println("ドライバーエラーが発生しました。<a href='updatePass.jsp'>再試行する</a>");
	}
     
     try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
         String sql = "UPDATE ユーザー SET pass = ? WHERE id = ?";
         PreparedStatement stmt = conn.prepareStatement(sql);
         stmt.setString(1, password);
         stmt.setString(2, userId);

         int rowsUpdated = stmt.executeUpdate();
         if (rowsUpdated > 0) {
             response.getWriter().println("終了しました。<a href='mainPage.jsp'>メインページへ</a>");
         } else {
             response.getWriter().println("データベースに登録できませんでした。<a href='updatePass.jsp'>再試行する</a>");
         }
     } catch (SQLException e) {
         e.printStackTrace();
         response.getWriter().println("データベースエラーが発生しました。<a href='updatePass.jsp'>再試行する</a>");
     }
 }
}
