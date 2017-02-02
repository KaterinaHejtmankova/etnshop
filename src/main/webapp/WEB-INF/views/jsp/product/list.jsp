<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>etnShop</title>

<spring:url value="/resources/core/css/hello.css" var="coreCss" />
<spring:url value="/resources/core/css/bootstrap.min.css"
	var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
</head>

<div class="container">
    <form action="/etnshop/product/search" method="get">
            <label path="name">Search Product: </label>
    		<input type="text" name="name">
    		<input type="submit" class="btn btn-success" value="Submit"/>
    	</form>
	<h2>Products</h2>
	<table class="table">
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Serial Number</th>
				<th>Edit</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${products}" var="product">
				<tr>
					<td>${product.id}</td>
					<td>${product.name}</td>
					<td>${product.serialNumber}</td>
					<td><a href="/etnshop/product/edit?id=${product.id}" role="button">Edit</a></td>
				</tr>

			</c:forEach>
		</tbody>
	</table>
	<hr>
	<p>
		<a class="btn btn-primary btn-lg" href="/etnshop" role="button">Back to homepage</a>
	</p>
	<p>
    	<a class="btn btn-primary btn-lg" href="/etnshop/product/create" role="button">Add new product</a>
    </p>
	<footer>
		<p>&copy; Etnetera a.s. 2017</p>
	</footer>
</div>

<spring:url value="/resources/core/css/bootstrap.min.js"
	var="bootstrapJs" />

<script src="${bootstrapJs}"></script>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</body>
</html>