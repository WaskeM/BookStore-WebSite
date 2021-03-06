<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Write a Review - Online Book Store</title>
<link rel="stylesheet" href="http://127.0.0.1:8887/css/style.css">
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.1/dist/jquery.validate.min.js" ></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.3.2/jquery.rateyo.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.3.2/jquery.rateyo.min.js"></script>

</head>
<body>
	<jsp:directive.include file="header.jsp" />
	
	<div align="center">
		<form id="reviewForm">
			<table class="normal" width="60%">
				<tr>
					<td><h3>You already wrote a review for this book</h3></td>
					<td> &nbsp; </td>
					<td><h2>${loggedCustomer.fullName}</h2></td>
				</tr>
				<tr> 
					<td colspan="3">
						<hr/>
					</td>
				</tr>
				<tr>
					<td>
						<span id="book_title"> ${book.title}</span><br/>
						<a href="view_book?id=${book.bookId}">	
							<img class="book_large" src="data:image//jpg;base64, ${book.base64Image}">
						</a>
					</td>
					<td>
						<div id="rateYo"></div>
						<br/>
						<input type="text" name="headline" size="60" readonly="readonly" value= "${review.headline}">
						<br/>
						<br/>
						<textarea name="comment" rows="10" cols="70" readonly="readonly">${review.comment}</textarea>
					</td>
				</tr>
			</table>
		</form>
	</div>
	
	<jsp:directive.include file="footer.jsp" />
</body>
<script> type="text/javascript">

	$(document).ready(function() {
		
		$("#rateYo").rateYo({
			    starWidth: "40px",
			    fullStar: true,
			    rating: ${review.rating},
			    readOnly: true				    	 
	      });
	});
</script>
</html>