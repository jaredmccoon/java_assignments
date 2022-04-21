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
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>
		<c:out value="${dojo.name}" />
		Location Ninjas
	</h1>
	<table>
		<thead>
			<tr>
				<td><h5>First Name</h5></td>
				<td><h5>Last Name</h5></td>
				<td><h5>Age</h5></td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${dojo.ninjas }" var="d">
				<tr>
					<td> <c:out value="${d.firstName }" /> </td>
					<td> <c:out value="${d.lastName }" /> </td>
					<td> <c:out value=" ${d.age }" /> </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>