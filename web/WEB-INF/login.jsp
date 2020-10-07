<%-- 
    Document   : login
    Created on : Oct 7, 2020, 9:00:38 AM
    Author     : 730676
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form method="post" action="login">
            <label> Username:</label><input type="text" name="user_name" value="">
            <br>
            <label> Password:</label><input type="text" name="user_pass" value="">
            <br>
            <input type="submit" value="Log in">
            <p>${message}</p>            
    </body>
</html>
