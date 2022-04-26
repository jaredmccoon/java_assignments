<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cool JAVA APP</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
	<h1>Edit Book</h1>
	book id = ${book.id }
	<hr />
	<form:form action="/books/${book.id}" 
				method="post"
				modelAttribute="book">
				
		<input type="hidden" name="_method" value="put">
		
		<p>
			<form:label path="title">Title</form:label>
			<form:errors path="title" />
			<form:input path="title" placeholder="hi" />
		</p>

		<p>
			<form:label path="author">Author:</form:label>
			<form:input path="author" class="form-control mb-3"  />
			<form:errors path="author" class="text-danger mb-3 d-inline-block" />
		</p> 
		<p>
			<form:label path="mythoughts">My Thoughts:</form:label>
			<form:errors path="mythoughts" />
			<form:input path="mythoughts" />
		</p>	
		<input type="submit" value="Submit" />
	</form:form>
</div>
</body>
</html>