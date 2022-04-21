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
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>New Ninja</h1>
	<form:form action="/create/ninja" method="post" modelAttribute="newNinja">
	<p>
		<form:select path="dojo">
			<c:forEach items="${dojos}" var="dojo">
				<form:option value="${dojo.id }">
					<c:out value="${dojo.name }"/>
				</form:option>
			</c:forEach>
		</form:select>
	</p>
	<p>
		<form:label path="firstName">First Name</form:label>
		<form:errors path="firstName" />
		<form:input path="firstName"/>
	</p>
	<p>
		<form:label path="lastName">Last Name</form:label>
		<form:errors path="lastName" />
		<form:input path="lastName"/>
	</p>
	<p>
		<form:label path="age">Age</form:label>
		<form:errors path="age" />
		<form:input path="age"/>
	</p>
	<input type="submit" value="submit" />
	</form:form>
</body>
</html>