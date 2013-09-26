<%-- 
    Document   : OtherError
    Created on : Sep 27, 2013, 10:15:21 AM
    Author     : Desktop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page isErrorPage="true"%>
<html>
<body>
<h1>Oops. Something unexpected happened.</h1>
<p><%=exception.getMessage()%></p>
<a href="javascript:history.back()">Back</a>
</body>
</html