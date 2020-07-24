<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Create New Customer</title>
	<link rel="stylesheet" href="http://127.0.0.1:8887/css/style.css">	
	<!-- <link rel="stylesheet" href="http://127.0.0.1:8887/css/datapicker.css">  -->
		
	<link rel="stylesheet" href="http://127.0.0.1:8887/css/jquery-ui.min.css">	
	<link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="http://127.0.0.1:8887/css/richtext.min.css">
	
	
	<script type="text/javascript" src="http://127.0.0.1:8887/js/jquery-3.4.1.min.js" ></script>
	<script type="text/javascript" src="http://127.0.0.1:8887/js/jquery.validate.min.js" ></script>
	<script type="text/javascript" src="http://127.0.0.1:8887/jquery-ui/" ></script>
	<script type="text/javascript" src="http://127.0.0.1:8887/js/jquery-ui.js" ></script>
	<script type="text/javascript" src="http://127.0.0.1:8887/js/jquery.richtext.min.js" ></script>


</head>
<body>
	<jsp:directive.include file="header.jsp" />

	<div align="center">
		<h2 class="pageheading">
			<c:if test="${customer != null}">		
				Edit Customer
			</c:if>
			<c:if test="${customer == null}">
				Create New Customer
			</c:if>

		</h2>
	</div>

	<div align="center">
		<c:if test="${customer != null}">
			<form action="update_customer" method="post" id="customerForm">
				<input type="hidden" name="customerId" value="${customer.customerId}">
		</c:if>
		<c:if test="${customer == null}">
			<form action="create_customer" method="post" id="customerForm">
		</c:if>

		<table class="form">
			<tr>
				<td align="right">E-mail</td>
				<td align="left"><input type="text" id="email" name="email"
					size="45" value="${customer.email}" />
				</td>
			</tr>
			<tr>
				<td align="right">Full Name</td>
				<td align="left"><input type="text" id="fullName"
					name="fullName" size="45" value="${customer.fullName}" />
				</td>
			</tr>
			<tr>
				<td align="right">Password</td>
				<td align="left"><input type="text" id="password"
					name="password" size="45" value="${customer.password}" />
				</td>
			</tr>
			<tr>
				<td align="right">Confirm password</td>
				<td align="left"><input type="text" id="confirmPassword"
					name="confirmPassword" size="45" value="${customer.password}" />
				</td>
			</tr>
			<tr>
				<td align="right">Phone Number</td>
				<td align="left"><input type="text" id="phone"
					name="phone" size="20" value="${customer.phone}" />
				</td>
			</tr>
			<tr>
				<td align="right">Address</td>
				<td align="left"><input type="text" id="address"
					name="address" size="60" value="${customer.address}" />
				</td>
			</tr>
			<tr>
				<td align="right">City</td>
				<td align="left"><input type="text" id="city"
					name="city" size="45" value="${customer.city}" />
				</td>
			</tr>
			<tr>
				<td align="right">Zip Code</td>
				<td align="left"><input type="text" id="zipcode"
					name="zipcode" size="10" value="${customer.zipcode}" />
				</td>
			</tr>
			<tr>
				<td align="right">Country</td>
				<td align="left"><input type="text" id="country"
					name="country" size="45" value="${customer.country}" />
				</td>
			</tr>
			
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit">Save</button>&nbsp;&nbsp;&nbsp;
					<button id="buttonCancel">Cancel</button>
				</td>
			</tr>
		</table>
		</form>
	</div>

	<jsp:directive.include file="footer.jsp" />
</body>
<script type="text/javascript">

	$(document).ready(function() {
		$("#customerForm").validate({
			rules:{
				email: {
					required:true,
					email:true
				},
				fullName: "required",
				password: "required",
				confirmPassword: {
					required: true,
					equalTo: "#password"
				}, 
				phone: "required",
				address: "required",
				city: "required",
				zipcode: "required",
				country: "required",
			},
			messages: {
				email: { 
					required : "Please enter e-mail address",
					email: "Please enter a valid e-mail adress"
				},
				
				fullName: "Please enter full name",
				password: "Please enter password",
				confirmPassword:{
					required: "Please confirm password",
					equalTo: "Confirm password does not match password"
				},
				phone: "Please enter phone number",
				address: "Please enter address",
				city: "Please enter city",
				zipcode: "Please enter zip code",
				country: "Please enter country",
			}
		});
	
	$("#buttonCancel").click(function(){
		history.go(-1);
	});
});
	
</script>

</html>