<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>OmikujiForm</title>
	
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	
	<script type="text/javascript" src="/js/script.js"></script>
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>

<body>
	<div class="container-fluid">
		<div class="container mx-auto my-5">
			<form action="/post" method="POST" class="col-6 my-3 py-3 mx-auto">
				<div class="mb-3">
					<label for="number" class="form-label">Pick any number between 5 and 25:</label>
					<input type="number" name="number" id="number" min="5" max="25" class="form-control" />
				</div>
				<div class="mb-3">
					<label for="city" class="form-label">Enter the name of any city:</label>
					<input type="text" name="city" id="city" class="form-control" />
				</div>
				<div class="mb-3">
					<label for="person" class="form-label">Enter the name of any real person:</label>
					<input type="text" name="person" id="person" class="form-control" />
				</div>
				<div class="mb-3">
					<label for="hobby" class="form-label">Enter a professional endeavor or hobby:</label>
					<input type="text" name="hobby" id="hobby" class="form-control" />
				</div>
				<div class="mb-3">
					<label for="thing" class="form-label">Enter any type of living thing:</label>
					<input type="text" name="thing" id="thing" class="form-control" />
				</div>
				<div class="mb-3">
					<label for="something" class="form-label">Say something nice to someone:</label>
					<textarea name="something" id="something" cols="30" rows="10" class="form-control"></textarea>
				</div>
				<div class="form-group">
		   			<button type="submit" class="btn btn-primary">Send</button>
		  		</div>	  	
			</form>
		</div>
	</div>
</body>
</html>