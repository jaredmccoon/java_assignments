<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>

	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	
	<script type="text/javascript" src="/js/script.js"></script>
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>

<body>
	<div class="container-fluid">
		<div class="container mt-4 mx-auto">
			<h2>Expense Details:</h2>
			<div class="my-3">
				<a href="/expenses" class="text-decoration-none">Go Home</a>
			</div>
			<div class="col-10 mx-auto">
				<p><span class="h4">Expense Name:</span> <c:out value="${expense.expenseName}" /></p>
				<table class="table">
					<tbody>
						<tr>
							<th>Vendor:</th>
							<td><c:out value="${expense.vendor}" /></td>
						</tr>
						<tr>
							<th>Charge:</th>
							<td>$<c:out value="${expense.charge}" />.00</td>
						</tr>
						<tr>
							<th>Description:</th>
							<td><c:out value="${expense.description}" /></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</body>
</html>