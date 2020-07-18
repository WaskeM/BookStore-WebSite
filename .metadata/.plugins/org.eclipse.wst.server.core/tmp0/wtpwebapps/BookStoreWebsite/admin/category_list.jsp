 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="http://127.0.0.1:8887/css/style.css">
<script type="text/javascript" src="http://127.0.0.1:8887/js/jquery-3.4.1.min.js" ></script>
<script type="text/javascript" src="http://127.0.0.1:8887/js/jquery.validate.min.js" ></script>

	<!--  
		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.1/dist/jquery.validate.min.js" ></script>
	-->
<title>Manage Categories - BookStore Administration</title>

</head>
<body>
	<jsp:directive.include file="header.jsp" />
	
	<div align="center">
		<h2 class="pageheading">Categories Management</h2>
		<h3><a href="category_form.jsp">Create New Category</a></h3>
	</div>
	
	<c:if test="${message != null}">
	<div align="center">
		<h4 class="message">${message}</h4>
	</div>
	</c:if>
	
	<div align="center">
		<table border="1" cellpadding="5">
			<tr>
				<th>Index</th>
				<th>ID</th>
				<th>Name</th>
				<th>Actions</th>
			</tr>	
			<c:forEach var="cat" items="${listCategory}" varStatus="status">
			<tr>
				<td>${status.index + 1}</td>
				<td>${cat.categoryId}</td>
				<td>${cat.name}</td>
				<td>
					<a href="edit_category?id=${cat.categoryId}">Edit</a> &nbsp;
					<a href="javascript:void(0);" class="deleteLink" id="${cat.categoryId}">Delete</a>
				</td>
			</tr>
			</c:forEach>
		</table>
		
	</div>
	
	
	<div align="center">

	</div>
	

	<jsp:directive.include file="footer.jsp" />
	
	<script>
	
	$(document).ready(function() {
		$(".deleteLink").each(function() {
			$(this).on("click", function(){
				categoryId = $(this).attr("id");
				if (confirm("Are you sure you want to delete category with ID " + categoryId + " ?")){
					window.location = "delete_category?id=" + categoryId;
				}
			});
		});		
	});
	</script>
	
</body>
</html>