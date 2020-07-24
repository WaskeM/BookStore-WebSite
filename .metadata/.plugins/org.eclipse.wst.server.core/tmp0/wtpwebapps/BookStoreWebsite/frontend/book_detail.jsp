<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>   
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${book.title } - online books store</title>
<link rel="stylesheet" href="http://127.0.0.1:8887/css/style.css">
<script type="text/javascript" src="http://127.0.0.1:8887/js/jquery-3.4.1.min.js" ></script>
<script type="text/javascript" src="http://127.0.0.1:8887/js/jquery.validate.min.js" ></script>
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
				<td rowspan="2" valign="top">
					<img class="book_large" src="data:image//jpg;base64, ${book.base64Image}">
				</td>
				<td valign="top" align="left" >
					<jsp:directive.include file="book_rating.jsp" /> &nbsp; &nbsp;
					<a href="#reviews">${fn:length(book.reviews)} Reviews</a>
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
					<h2><a id="reviews">Customer Reviews</a></h2>
				</td>
				<td colspan="2" align="center">
					<button id="buttonWriteReview">Write a Customer Review</button>
				</td>
			</tr>
			
			<tr>
				<td colspan = "3" align="left">
					<table class="normal">
						<c:forEach items = "${book.reviews}" var="review">
							<tr>
								<td>
									<c:forTokens items= "${review.stars}" delims="," var="star">
										<c:if test="${star eq 'off'}">
											<img src="images/rating_off.png" width="20" height="20" />
										</c:if>
										<c:if test="${star eq 'on'}">
											<img src="images/rating_on.png" width="20" height="20" />
										</c:if>
									</c:forTokens>
									- <b>${review.headline}</b>
								</td>
							</tr>
							<tr>
								<td>
									by ${review.customer.fullName} on ${review.reviewTime}
								</td>
							</tr>
							<tr>
								<td><i>${review.comment}</i></td>
							</tr>
							<tr>
								<td>&nbsp;</td>
							</tr>
							
						</c:forEach>
					</table>
				</td>
			</tr>
			
		</table>
	
	</div>
	
	<jsp:directive.include file="footer.jsp" />
	<script type="text/javascript">
	$(document).ready(function() {
		$("#buttonWriteReview").click(function(){
			window.location = 'write_review?book_id=' + ${book.bookId};
		});
	});
	</script> 
</body>
</html>