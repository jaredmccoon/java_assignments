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
	<div class="container mx-auto mt-5">
		<div class="col-6 mx-auto">
			<h2>Update this Expense:</h2>
			<a href="/expenses" class="text-decoration-none">Go Home</a>
			<form:form action="/expenses/${expense.id}" method="POST" modelAttribute="expense" class="rounded bg-info px-4 py-4">
				<input type="hidden" name="_method" value="PUT" />
				<div class="input-group mb-3">
					<span class="input-group-text">Name:</span>
					<form:input type="text" path="expenseName" class="form-control" />
				</div>
				<div><form:errors path="expenseName" /></div>
				<div class="input-group mb-3">
					<span class="input-group-text">Vendor:</span>
					<form:input type="text" path="vendor" class="form-control" />
				</div>
				<div><form:errors path="vendor" /></div>
				<div class="input-group mb-3">
					<span class="input-group-text">Charge:</span>
					<form:input type="number" path="charge" class="form-control" />
				</div>
				<div><form:errors path="charge" /></div>
				<div class="mb-3">
					<form:label path="description" class="form-label">Description:</form:label>
					<form:textarea path="description" class="form-control" />
				</div>
				<div><form:errors path="description" /></div>
				<div class="text-end">
					<input type="submit" value="Submit" class="col-2 btn btn-sm btn-secondary me-2" />
				</div>
			</form:form>
			<form:form action="/expenses/${expense.id}" method="post" class="px-2 pt-4 pb-2">
    			<input type="hidden" name="_method" value="delete">
    			<input type="submit" value="Delete" class="col-2 btn btn-sm btn-danger">
			</form:form>
		</div>
	</div>

</body>
</html>