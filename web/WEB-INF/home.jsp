<%-- 
    Document   : home
    Created on : Oct 7, 2020, 9:00:47 AM
    Author     : 730676
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h1>Home Page</h1>
        <h3>Hello ${u.username}.</h3>
        <a href="home?logout=logout">Log out</a>
    </body>
</html>
