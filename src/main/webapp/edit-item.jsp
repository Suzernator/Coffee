<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to Cafe Suze!</title>
</head>
<body>
<form action="editItemServlet" method="post">
Customer name:<input type="text" name="name" value="${itemToEdit.name}">
Drink item:<input type="text" name="drink" value="${itemToEdit.drink}">
<input type="hidden" name="number" value="${itemToEdit.number}">
<input type="submit" value="Save Edited Order">
</form>
</body>
</html>