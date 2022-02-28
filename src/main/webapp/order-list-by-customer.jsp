<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Orders</title>
</head>
<body>
<form method = "post" action = "orderNavigationServlet">
<table>
<c:forEach items = "${requestScope.allOrders}" var="currentorder">
<tr>
	<td><input type = "radio" name = "number" value = "${currentorder.number}"></td>
	<td><h2>${currentorder.listName}</h2></td></tr>
	<tr><td colspan = "3">Order Date: ${currentorder.orderDate}</td></tr>
	<tr><td colspan = "3">Customer: ${currentorder.customer.customerName}</td></tr>
	<c:forEach var = "listVal" items = "${currentorder.listOfDrinks}">
		<tr><td></td><td colspan = "3">${listVal.name}, ${listVal.drink}</td></tr></c:forEach>
</c:forEach>
</table>
<input type = "submit" value = "edit" name = "doThisToOrder">
<input type = "submit" value = "delete" name = "doThisToOrder"> 
<input type = "submit" value = "add" name = "doThisToOrder">
</form>
<a href="addItemsForOrderServlet">Create a new order</a>
<a href="index.html">Add a new drink</a>
</body>
</html>