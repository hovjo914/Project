


<!DOCTYPE html>
<html>
    <head><link rel="stylesheet" type="text/css" href="Style.css">
        <title>Customer System</title></head>
    <body>
        <h1>Enter a new Customer</h1>

        <form action="/shopping/AddProductServlet" method="post">
            <fieldset id="bob"> 
                <legend>Product Details</legend>
                <label>Product ID:<input type="text" name="productid"/></label>
                <label>Product Name:<input type="text" name="productname"/></label>
                <label>Description:<input type="text" name="description"/></label>
                <label>Category:<input type="text" name="category"/></label>
                <label>Price<input type="text" name="price"/></label>
                <label>Quantity<input type="text" name="quantity"/></label>
                <button type="submit">Add Product</button>
            </fieldset>
        </form>

        <br>
        <br>
        <br>
        <%@include file = "/WEB-INF/jspf/NavigationMenu.jspf" %>

    </body>
</html>
