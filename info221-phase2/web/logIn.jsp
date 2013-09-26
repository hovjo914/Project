<!--
To change this template, choose Tools | Templates
and open the template in the editor.
-->
<!DOCTYPE html>

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


<html>
    <head>
        <title></title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>

        <p><%=message%></p><!-- display the message to the user -->
        <form action="LoginServlet" method="post">

        </form>

        <fieldset>
            <legend> Login Details </legend>
            <label> User Name:<input type="text" name="username"></label>
            <label> Password:<input type="password" name="password"></label>
            <button type="submit">Login</button>
        </fieldset>
    </form>


</body>
</html>
