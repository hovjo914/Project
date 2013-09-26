<%-- 
    Document   : index
    Created on : Sep 12, 2013, 4:14:09 PM
    Author     : johnl_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="stylesheet" type="text/css" href="Style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><center>Login Page</center></title>
    </head>
    <body>
        <%@include file = "/WEB-INF/jspf/NavigationMenu.jspf" %>
        <h1> Menu Heading Partial </h1>
        <a href ="/shopping/AddCustomer.html"> Add a new Customer </a><br>
        <a href ="/shopping/restricted/ViewCustomers.jsp"> View All Customers </a>

    </body>
</html>
