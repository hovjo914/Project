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
        <table border="1">
            <thead>
                <tr>
                    <th>Product ID</th>
                    <th>Product Name</th>
                    <th>Description</th>
                    <th>Category</th>
                    <th>Price</th>
                    <th>Quantity</th>

                </tr>
            </thead>
            <tbody>

                <% for (Product product : products) {%>

                <tr>
                 <td><%= product.getProductID()%></td>
                <td><%= product.getName()%></td>
                <td><%= product.getDescription()%></td>
                 <td><%= product.getCategory()%></td>
                <td><%= product.getPrice()%></td>
                <td><%= product.getQuantity()%> </td>
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
