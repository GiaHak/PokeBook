<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<!-- for Bootstrap CSS -->
	<link rel="stylesheet"
	href="/webjars/bootstrap/5.0.1/css/bootstrap.min.css" />

	<!-- YOUR own local CSS -->
	<link rel="stylesheet" href="/css/main.css"/>
	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/5.0.1/js/bootstrap.min.js"></script>
	<title>PokeBook Expenses</title>
</head>
<body>
<h1>PokeBook Expenses</h1>

<table class="table">
  <thead>
    <tr>
     <th scope="col">ID</th>
      <th scope="col">Expense</th>
      <th scope="col">Vendor</th>
      <th scope="col">Amount</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
      <c:forEach var="x" items="${pokes}">
   <tr>
   <td><a href="/expense/details/${x.id}"> <c:out value="${x.id}"/></a></td>
   <td> <c:out value="${x.expense}"/></td>
   <td> <c:out value="${x.vendor}"/></td>
   <td> <c:out value="${x.amount}"/></td>
   <td><a href="/expense/edit/${x.id }">Edit</a> 
   <form action="/destroy/${x.id}" method="post">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Delete">
</form>
   </td>
  
</tr>
</c:forEach>
</table>
<h1>Track expenses</h1>
<form:form action= "/expense" method = "POST" modelAttribute="poke">
    <p>
        <form:label path="expense">Expense Name:</form:label>
        <form:errors path="expense"/>
        <form:input path="expense"/>
    </p>
    <p>
        <form:label path="vendor">Vendor:</form:label>
        <form:errors path="vendor"/>
        <form:input path="vendor"/>
    </p>
    <p>
        <form:label path="amount">Amount:</form:label>
        <form:errors path="amount"/>     
        <form:input type="number" path="amount"/>
    </p>    
    <p>
        <form:label path="description">Description:</form:label>
        <form:errors path="description"/>
        <form:textarea path="description"/>
    </p>
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>
