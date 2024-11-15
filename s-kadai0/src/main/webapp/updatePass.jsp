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
<!-- updatePass.jsp -->
<!DOCTYPE html>
<html>
<head>
    <title>パスワード変更</title>
</head>
<body>
    <h2>パスワード変更</h2>
    
    <!-- エラーメッセージ表示用 -->
    <p style="color:red;">
        ${errorMessage}
    </p>

    <form action="upPassCheck" method="post">
        <label for="password1">新しいパスワード:</label>
        <input type="password" id="password1" name="password1" required><br><br>
        
        <label for="password2">パスワード確認:</label>
        <input type="password" id="password2" name="password2" required><br><br>
        
        <input type="submit" value="変更を確認する">
    </form>
</body>
</html>
