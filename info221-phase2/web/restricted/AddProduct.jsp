


<!DOCTYPE html>
<html>
    <head><link rel="stylesheet" type="text/css" href="/shopping/Style.css">
        <title>Product System</title></head>
    <body>
        <h1>Enter a new Product</h1>

        <form action="/shopping/AddProductServlet" method="post">
            <fieldset id="bob"> 
                <legend>Product Details</legend>
                <label>Product ID:<input type="text" name="productid"/><br></label>
                <label>Product Name:<input type="text" name="productname"/><br></label>
                <label>Description:<input type="text" name="description"/><br></label>
                <label>Category:<input type="text" name="category"/><br></label>
                <label>Price:<input id="b" type="text" name="price"/><br></label>
                <label>Quantity:<input id="b" type="text" name="quantity"/></label>
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
