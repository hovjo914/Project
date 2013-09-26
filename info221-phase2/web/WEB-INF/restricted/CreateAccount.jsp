<%-- any content can be specified here e.g.: --%>
<%@page import="domain.Customer"%>
<%@ page pageEncoding="UTF-8" %>

<%
    Customer customer = (Customer) session.getAttribute("customer");

    if (customer == null) {
%>

<a href="/shopping/logIn.jsp">Log In</a>

<%} else {%>

<a href="/shopping/index.jsp">Home Page</a><br>
<a href="/shopping/restricted/ViewProducts.jsp"> View Products </a><br>
<a href="/shopping/LogOut"> Log Out </a>  <br> 
<a href ="/shopping/restricted/CreateAccount.jsp"> Add a new Customer </a><br>
<a href ="/shopping/restricted/ViewCustomers.jsp"> View All Customers </a><br>

<%}%>

