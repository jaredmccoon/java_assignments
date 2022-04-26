<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>New JAVA APP</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div>
		<div>
			<h2>${oneBook.title}</h2>
			<a href="/books">back to the shelves</a>
		</div>
		<div>
			<h3>${oneBook.user.userName} read ${oneBook.title} by ${oneBook.author}.</h3>
			<h3>Here are ${oneBook.user.userName}'s thoughts:</h3>
		</div>
		<div>
			<hr />
				<p>${oneBook.mythoughts}</p>
			<hr />
			<!-- if session id is equal to book user id  thens how edit button-->
			<c:if test="${user_id == oneBook.user.id}">
				<a href="/books/${oneBook.id}/edit"><button>Edit</button></a>
			</c:if>
		</div>
	</div>
</body>
</html>