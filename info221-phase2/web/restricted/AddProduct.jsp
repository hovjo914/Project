


<!DOCTYPE html>
<html>
    <head><link rel="stylesheet" type="text/css" href="/shopping/style.css">
        <title>Product System</title></head>
    <body>
        <h1>Enter a new Product</h1>

        <form action="/shopping/AddProductServlet" method="post">
            <fieldset id="productmenu"> 
                <legend>Product Details</legend>
                <label>Product ID:</label><input type="text" name="productid"/>
                <label>Product Name:</label><input type="text" name="productname"/>
                <label>Description:</label><input type="text" name="description"/>
                <label>Category:</label><input type="text" name="category"/>
                <label>Price:</label><input id="b" type="text" name="price"/>
                <label>Quantity:</label><input id="b" type="text" name="quantity"/>
                <label>---------------------------------------------------</label>
                <button type="submit">Add Product</button>
            </fieldset>
        </form>

        <br>
        <br>
        <br>
        <%@include file = "/WEB-INF/jspf/NavigationMenu.jspf" %>

    </body>
</html>
