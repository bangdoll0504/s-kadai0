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
<!-- upPassCheck.jsp -->
<!DOCTYPE html>
<html>
<head>
    <title>パスワード変更確認</title>
</head>
<body>
    <h2>パスワード変更確認</h2>
    
    <p>パスワードを変更しますか？</p>
    <form action="upPassComp" method="post">
        <!-- パスワードを非表示で表示 -->
        <input type="hidden" name="password" value="${password}">
        <input type="submit" value="はい">
    </form>
</body>
</html>
