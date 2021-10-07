<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<title>Insert title here</title>
</head>
<body>
<h1>Details of PokeBook</h1>
<a href= "/expense">home</a>

<h3> Expense Name:  <c:out value="${poke.expense}"></c:out> </h3>
<h3>Expense Description:  <c:out value="${poke.description}"></c:out> </h3>	
<h3> Vendor:  <c:out value="${poke.vendor}"></c:out> </h3>
<h3> Amount Spent:  <c:out value="${poke.amount}"></c:out> </h3>
</body>
</html>
