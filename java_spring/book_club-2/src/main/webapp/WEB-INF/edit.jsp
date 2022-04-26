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
	<div class="container">
		<div class="d-flex justify-content-between">
			<h2>Add a Book to Your Shelf!</h2>
			<a href="/books">back to the shelves</a>
		</div>
		<div class="form-group">
			<form:form action="/books/${book.id}" method="put" modelAttribute="book">
			<form:errors path="*"/> 
			
				<p>
					<form:label path="title" for="title">Title</form:label>
					<form:errors path="title" />
					<form:input class="form-control" id="title" path="title" />
				</p>
				
				<p>
					<form:label path="author" for="author">author</form:label>
					<form:errors path="author" />
					<form:input class="form-control" id="author" path="author" />
				</p>
				
				<p>
					<form:label path="mythoughts">My Thoughts:</form:label>
					<form:errors path="mythoughts" />
					<form:input path="mythoughts" />
				</p>
				
				<input class="btn btn-primary" type="submit" value="Submit" />
			</form:form>
		</div>
	</div>
</body>
</html>ml>