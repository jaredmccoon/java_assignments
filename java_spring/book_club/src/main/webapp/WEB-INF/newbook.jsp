<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
		<h1>New Book</h1>
		<hr />
		<a href="/home">/home</a>
		<a href="/books">/books</a>
		<p></p>
		<p>
			${thisLoggedInUser.id }
		</p>
		
		
		<form:form action="/books" method="post" modelAttribute="book">
		<form:errors path="*"/> 

			<p>
				<form:label path="title">Title</form:label>
				<form:errors path="title" />
				<form:input path="title" placeholder="placeholder"/>
			</p>
			<p>
				<form:label path="author">author</form:label>
				<form:errors path="author" />
				<form:input path="author" placeholder="placeholder"/>
			</p>
			<p>
				<form:label path="mythoughts">My Thoughts:</form:label>
				<form:errors path="mythoughts" />
				<form:input path="mythoughts" placeholder="placeholder"/>
			</p>
			

			<input type="submit" value="Submit" />
		</form:form>
		<hr />
		
		<!-- loop though all the books -->
		<c:forEach items="${alldabooks }" var="book">
			<li>
				${book.title }
			</li>
		</c:forEach>
	</div>

</body>
</html>