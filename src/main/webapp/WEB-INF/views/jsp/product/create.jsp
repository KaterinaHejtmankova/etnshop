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
	<h2>New Product</h2>
	<c:if test="${errors != null}">
        <div class="alert alert-danger" role="alert">
            <c:forEach items="${errors.errorMessages}" var="error">
                        ${error}</br>
            </c:forEach>
        </div>
	</c:if>
    <form method="POST" action="/etnshop/product/saveNew" modelAttribute="product">
       <table>
        <tr>
            <td><label path="name">Name</label></td>
            <td><input type="text" name="name"/></td>
        </tr>
        <tr>
            <td><label path="serialNumber">Serial Number</label></td>
            <td><input  type="number" name="serialNumber"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" class="btn btn-success" value="Submit"/>
            </td>
        </tr>
    </table>
    </form>
	<hr>
	<p>
	    <a class="btn btn-primary btn-lg" href="/etnshop/product/list" role="button">Products</a>
		<a class="btn btn-primary btn-lg" href="/etnshop" role="button">Back to homepage</a>
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