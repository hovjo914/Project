<%-- 
    Document   : ViewProducts
    Created on : 26/09/2013, 12:54:59 PM
    Author     : hovjo914
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="dao.*, domain.*, java.util.*"%>
<!DOCTYPE html>
<html><body>
        <%@include file = "/WEB-INF/jspf/NavigationMenu.jspf" %>
        <h1> Products></h1>
        <% Collection<Product> products = new ProductJdbcDao().getAll(); %>

        <table>
            <% for (Product product : products) {%>
            <tr>
                <td><%= product.getProductID()%></td>
                <td><%= product.getName()%></td>
                <td><%= product.getDescription()%></td>
                <td><%= product.getPrice() %></td>
                <td><%= product.getQuantity()%> </td>

            </tr> 
            <%}%>

        </table>
    </body>
</html>
