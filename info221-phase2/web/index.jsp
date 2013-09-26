<%-- 
    Document   : index
    Created on : Sep 12, 2013, 4:14:09 PM
    Author     : johnl_000
--%>
<%   // changed logIn to LoginServlet
// get the status code to see why the log in page was requested
    Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
// default message to display to the user
    String message = "Please log in to continue.";
// if the status code was 401 (UNAUTHORIZED) then extract the message
// from the request
    if (statusCode != null
            && statusCode == HttpServletResponse.SC_UNAUTHORIZED) {
        message =
                request.getAttribute("javax.servlet.error.message").toString();
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="stylesheet" type="text/css" href="Style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><center>Login Page</center></title>
    </head>
    <body>
         
        <h1> Menu Heading Partial </h1>
        <p><%=message%></p><br>
        <%@include file = "/WEB-INF/jspf/NavigationMenu.jspf" %>


    </body>
</html>
