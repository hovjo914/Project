<%-- 
    Document   : ViewProducts
    Created on : 26/09/2013, 12:54:59 PM
    Author     : hovjo914
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="dao.*, domain.*, java.util.*"%>
<!DOCTYPE html>
<link rel="stylesheet" type="text/css" href="/shopping/style.css">
<html><body>

        <h1> Products</h1>
        <% Collection<Product> products = new ProductJdbcDao().getAll();%>
        <table id='producttable' border="1">
            <thead>
                <tr>
                    <th id='productid'>Product ID</th>
                    <th>Product Name</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Quantity</th>


                </tr>
            </thead>
            <tbody>

                <% for (Product product : products) {%>

                <tr>
                    <td id='productid'><%= product.getProductID()%></td>
                    <td><%= product.getName()%></td>
                    <td><%= product.getDescription()%></td>
                    <td><%= product.getPrice()%></td>
                    <td><%= product.getQuantity()%> </td>
                    <td><a href="/restricted/Buy.jsp"><button type ='button'>Buy</a></button></td>
                </tr>

                <% }%>

            </tbody>
        </table>


        <br>
        <br>
        <br>
        <%@include file = "/WEB-INF/jspf/NavigationMenu.jspf" %>

    </body>
</html>
