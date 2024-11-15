<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%
    String userId = (String) session.getAttribute("userId");
    if (userId == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!-- mainPage.jsp -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>メインページ</title>
</head>
<body>
    <!-- 既存のタイトルとユーザー名の表示 -->
    <h2>メインページ</h2>
    <p>ようこそ、${userId}さん！</p>

    <!-- メニューの追加 -->
    <h3>メニュー</h3>
    <ul>
        <li><a href="updatePass.jsp">パスワード変更</a></li>
        <li><a href="logout">ログアウト</a></li>
    </ul>
</body>
</html>
