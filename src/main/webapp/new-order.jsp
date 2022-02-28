<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a new order</title>
</head>
<body>
<form action = "createNewOrderServlet" method = "post">
Customer Name: <input type = "text" name = "customerName"><br />

Current Drink List:<br />
<select name = "allItemsToAdd" multiple size = "6">
<c:forEach items = "${requestScope.allDrinks}" var = "currentitem">
	<option value = "${currentitem.number}">${currentitem.name}: ${currentitem.drink}</option>
</c:forEach>
</select>
<br />
<input type = "submit" value = "Create Order and Add Drinks">
</form>
<a href = "index.html">Add new drink instead?</a>
</body>
</html>