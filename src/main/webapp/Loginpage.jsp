
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>College Management System</title>

    <link rel="stylesheet" href="login.css">
</head>
<body>


<div class="container">
    <div class="head">
        <h2>Student Login</h2>
    </div>
    <div class="con-child">
        <form action="backend" method="post">
            <div class="form-pg">
                <label for="id">Student id</label>
                <input type="text" id="id" name="id" required>
                <label for="email">Email</label>
                <input type="email" id="email" name="email">
                <label for="pass">Password</label>
                <input type="password" id="pass" name="pass" required>
                <button type="submit">Login</button>
            </div>        
            </form>
            <%
    String text = (String) request.getAttribute("msg");

    if (text != null && !text.trim().isEmpty()) {
%>     
        <h3 style="color: red;" class="err-msg"><%= text %></h3>
      
<%
    }
%>
 
<a href="sigin.jsp">Create new Account</a>
  </div>
</div>
<%@include file="footer.html" %>

</body>
</html>
