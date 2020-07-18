<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${book.title } - online books store</title>
<link rel="stylesheet" href="http://127.0.0.1:8887/css/style.css">
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	
	<div class="center">
		<table class="book" >
			<tr>
				<td colspan="3" align="left" >
					<p id="book_title"> ${book.title} </p>
						by <span id="book_author"> ${book.author} </span>
				</td>
			</tr>
			<tr>
				<td rowspan="2"]>
					<img class="book_large" 
						src="data:image//jpg;base64, ${book.base64Image}">
				</td>
				<td valign="top" align="left">
					Rating *****
				</td>
				<td valign="top" rowspan="2" width="20%">
					<h2>$${book.price}</h2>
					<br/><br/>
					<button type="submit">Add to Cart</button>
				</td>
			</tr>
			<tr>
				<td id="book_description">
					${book.descripton}
				</td>
			</tr>
			<tr>
				<td>
					&nbsp;
				</td>
			</tr>
			<tr>
				<td>
					<h2>Customer Reviews</h2>
				</td>
				<td colspan="2" align="center">
					<button>Write a Customer Review</button>
				</td>
			</tr>
		</table>
	
	</div>
	
	<jsp:directive.include file="footer.jsp" />
</body>
</html>