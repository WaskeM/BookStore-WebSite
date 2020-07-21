<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="http://127.0.0.1:8887/css/style.css">	
	
	<!--  
	<script type="text/javascript" src="http://127.0.0.1:8887/js/jquery-3.4.1.min.js" ></script>
	<script type="text/javascript" src="http://127.0.0.1:8887/js/jquery.validate.min.js" ></script>
	-->
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.1/dist/jquery.validate.min.js" ></script>
	
	<!--
		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.1/dist/jquery.validate.min.js" ></script>
	-->
	<title>Manage Customers - BookStore Administration</title>

</head>
<body>
	<jsp:directive.include file="header.jsp" />
	
	<div align="center">
		<h2 class="pageheading">Customer Management</h2>
		<h3><a href="customer_form.jsp">Create New Customer</a></h3>
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
				<th>E-mail</th>
				<th>Full Name</th>
				<th>City</th>
				<th>County</th>
				<th>Register date</th>
				<th>Actions</th>
			</tr>	
			<c:forEach var="customer" items="${listCustomer}" varStatus="status">
			<tr>
				<td>${status.index + 1}</td>
				<td>${customer.customerId}</td>
				<td>${customer.email}</td>
				<td>${customer.fullName}</td>
				<td>${customer.city}</td>
				<td>${customer.country}</td>
				<td>${customer.registerDate}</td>
				<td>
					<a href="edit_customer?id=${customer.customerId}">Edit</a> &nbsp;
					<a href="javascript:void(0);" class="deleteLink" id="${customer.customerId}">Delete</a>
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
					customerId = $(this).attr("id");
					if (confirm("Are you sure you want to delete customer with ID " + customerId + " ?")){
						window.location = "delete_customer?id=" + customerId;
					}
				});
			});		
		});

	</script>
	
</body>
</html>