<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>Fruit Store</title>
</head>
<body>
	<div class="mx-auto" style="width: 500px">
		<h1 class="text-left text-primary">
		Fruit Store
		</h1>
		<div class="border border-primary border-5">
			<table class="table">
	  			<thead>
				    <tr>
				      <th scope="col">Name</th>
				      <th scope="col">Price</th>
				    </tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${ fruits }">
					<tr>
				      <td>${ item.getName() }</td>
				      <td>${ item.getPrice() }</td>
				    </tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>