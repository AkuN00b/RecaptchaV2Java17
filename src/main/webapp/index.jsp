<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2023-03-16
  Time: 오전 1:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" %>
<%@ page import = "java.util.ResourceBundle" %>
<% String key = ResourceBundle.getBundle("config").getString("6LeESgMlAAAAALNRGO2Q8Km9448o86cqJ16SG0Xe"); %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <script src="https://www.google.com/recaptcha/api.js?hl=es-419" async defer></script>
</head>
<body>
<form action="LoginServlet" method="post">
    <label>Username:</label><input type="text" name="user"><br>
    <label>Password:</label><input type="password" name="pwd"><br>
    <div class="g-recaptcha" data-sitekey="<%=key%>"></div>
    <br>
    <input type="submit" value="Login">
</form>
</body>
</html>
