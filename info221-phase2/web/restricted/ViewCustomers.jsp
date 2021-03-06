<!DOCTYPE html>

<%@page import="java.util.*,dao.*,domain.*" %>

<html>

    <head>
        <link rel="stylesheet" type="text/css" href="/shopping/style.css">
        <title>Customer Management System</title>
    </head>

    <body>
        <h1>Customer Report</h1>

        <%
            Collection<Customer> customers =
                    new CustomerJdbcDao().getAll();
        %>

        <table id="productmenu" border="1">
            <thead>
                <tr>
                    <th>Customer Name</th>
                    <th>Address</th>
                    <th>password</th>
                    <th>Credit Card</th>

                </tr>
            </thead>
            <tbody>

                <% for (Customer customer : customers) {%>

                <tr>
                    <td><%=customer.getUserName()%></td>
                    <td><%=customer.getAddress()%></td>
                    <td><%=customer.getPassWord()%></td>
                    <td><%=customer.getCreditCard()%></td>
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
