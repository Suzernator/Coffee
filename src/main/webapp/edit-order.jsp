<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit An Order</title>
</head>
<body>
<form action = "editOrderDetailsServlet" method = "post">
<input type= "hidden" name = "number" value = "${orderToEdit.number}">
Order Number: <input type = "text" name = "orderNumber" value = "${orderToEdit.orderNumber}"><br />

Order Date: <input type = "text" name = "month" placeholder = "mm" size = "4">
			<input type = "text" name = "day" placeholder = "dd" size = "4">
			<input type = "text" name = "year" placeholder = "yyyy" size = "4">
			
Customer Name: <input type = "text" name = "customerName" value = "${orderToEdit.customer.customerName}"> <br />

Available Drinks:<br />
<select name = "allItemsToAdd" multiple size = "6">
<c:forEach items = "${requestScope.allDrinks }" var = "currentitem">
	<option value = "${currentitem.number}">${currentitem.name}: ${currentitem.drink}</option>
</c:forEach>
</select>
<br />
<input type = "submit" value = "Edit Order and Add Drinks">
<a href = "index.html">Add New Drinks Instead.</a>
</form>
</body>
</html>