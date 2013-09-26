<%-- 
    Document   : CreateAccount
    Created on : Sep 26, 2013, 8:58:13 PM
    Author     : Desktop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Create a Customer Account</h1>
        <form action="CreateAccountServlet" Method="post">
            <fieldset> 
                <legend> Account Details </legend>
                <label> User Name:<input type="text" name ="username"></label>
                <label> Name:<input type="text" name ="name"></label>
                <label> Address:<textarea name ="address" rows="4" cols="0"></textarea></label>
                <label> Credit Card: <input type="text" name ="creditcard"></label>
                <label> Password: <input type="submit"> Create Account </button>
                    </fieldset>
                    </form>
                    </body>
                    </html>
