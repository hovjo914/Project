


<!DOCTYPE html>
<html>
    <head><link rel="stylesheet" type="text/css" href="/shopping/style.css">
        <title>Customer System</title></head>
    <body>
        <h1>Enter a new Customer</h1>

        <form action="/shopping/CreateAccountServlet" method="post">
            <fieldset id="bob"> 
                <legend>Customer Details</legend>
                <label>Customer name:<input type="text" name="customername"/></label>
                <label>Password:<input type="text" name="password"/></label>
                <label>Address:<input type="text" name="address"/></label>
                <label> Credit Card Details:<input type="text" name="creditCard"/></label>
                <button type="submit">Add Customer</button>
            </fieldset>
        </form>

        <br>
        <br>
        <br>
        <%@include file = "/WEB-INF/jspf/NavigationMenu.jspf" %>

    </body>
</html>
