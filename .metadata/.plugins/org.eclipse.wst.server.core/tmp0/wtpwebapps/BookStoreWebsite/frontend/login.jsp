<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Login</title>
<link rel="stylesheet" href="http://127.0.0.1:8887/css/style.css">
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.1/dist/jquery.validate.min.js" ></script>
<style type="text/css">

#headermenu {
	display: table;
}

#headermenu div {
	display: table-cell;
	padding-right: 20px;
}

a:link {
	color: cornflowrBLue;
	text-decoration: none;
}

a:visited {
	color: indigo;
}

a:hover {
	color: blue;
	text-decoration: underline;
}

a:active {
	color: red;
}

#headermenu a:link {
	font-size: larger;
}

.pageheading {
	color: darkblue;
}

table {
	border: 1px solid black;
	border-collapse: collapse
}

th, td {
	padding: 8px;
}

th {
	background: darkblue;
	color: cornsilk;
	font-size: larger;
}

table.form {
	border: 0;
	padding: 4px;
}

button {
	padding: 6px;
	border-radius: 5px;
}

button[type=submit] {
	font-weight: bold;
}

button:hover {
	background-color: white;
	color: green;
}

input {
	border: 1px solid;
	border-radius: 4px;
	border-color: green;
	height: 20px;
}

.message {
	font-style: italic;
	color: blue;
}

.error {
	color: red;
	margin: 5px;
	font-style: italic;
}

</style>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	
	<div align="center">
		<h1> My online BookStore </h1>
		<h2>Customer Login</h2>
		
	<c:if test="${message != null}">
		<div align="center">
			<h4 class="message">${message}</h4>
		</div>
	</c:if>
		
		<form action="login" id="loginForm" method="post">
			<table>
				<tr>
					<td>Email:</td>
					<td><input type="text" name="email" id="email" size="20"></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password" id="password" size="20"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button type="submit">Login</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
	
	<jsp:directive.include file="footer.jsp" />
</body>
<script> type="text/javascript">

	$(document).ready(function() {
		$("#loginForm").validate({
			rules:{
				email:{
					required: true,
					email:true
				},
				password: "required",
			},
			messages: {
				email: {
					email:"Please enter an valid email address!",
					required: "Please enter email!",
				},
				password: "Please enter password!",
			}
		});
	});
</script>
</html>