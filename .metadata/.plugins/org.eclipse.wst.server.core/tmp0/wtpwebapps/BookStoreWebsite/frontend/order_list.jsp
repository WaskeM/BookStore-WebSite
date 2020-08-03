<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="http://127.0.0.1:8887/css/style.css">	

	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.1/dist/jquery.validate.min.js" ></script>


	<title>My Order History - BookStore WebStore</title>

</head>
<body>
	<jsp:directive.include file="header.jsp" />
	
	<div align="center">
		<h2 class="pageheading">My Orders History</h2>
	</div>

	<c:if test="${fn:length(listOrders) == 0}">
		<div align="center">
			<h3>You have not placed any orders.</h3>
		</div>
	</c:if>
	
	
	<c:if test="${fn:length(listOrders) > 0}">
	<div align="center">
		<table border="1" cellpadding="5">
			<tr>
				<th>Index</th>
				<th>Order ID</th>
				<th>Quantity</th>
				<th>Total Amount</th>
				<th>Order Date</th>
				<th>Status</th>
				<th>Actions</th>
			</tr>	
			<c:forEach var="order" items="${listOrders}" varStatus="status">
			<tr>
				<td>${status.index + 1}</td>
				<td>${order.orderId}</td>
				<td>${order.bookCopies}</td>
				<fmt:setLocale value="en_US"/>
				<td> <fmt:formatNumber value= "${order.total}" type="currency" /></td>	
				<td>${order.orderDate}</td>
				<td>${order.status}</td>
				<td>
					<a href="show_order_detail?id=${order.orderId}"> View Details</a> &nbsp;
				</td>
			</tr>
			</c:forEach>
		</table>
	</div>
	</c:if>
	
	<div align="center">

	</div>
	

	<jsp:directive.include file="footer.jsp" />

	
</body>
</html>