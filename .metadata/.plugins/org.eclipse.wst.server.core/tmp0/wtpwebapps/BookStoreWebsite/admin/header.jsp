<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div align="center">
	<div>
		<a href="${pageContext.request.contextPath}/admin/">
			<img src="http://127.0.0.1:8887/pictures/NET-knjizara-admin-Logo.jpg" />
		</a>
	</div>
	<div>
		Welcome, <c:out value="${sessionScope.useremail}"></c:out> | <a href="logout">Logout</a>
		<br/><br/>
	</div>
	<div id="headermenu">
		<div>
			<a href="list_users">
				<img src="http://icons.iconarchive.com/icons/custom-icon-design/pretty-office-8/32/User-blue-icon.png" /><br/>Users
			</a> 
		</div>
		
		<div>
			<a href="list_category">
				<img src="http://icons.iconarchive.com/icons/fatcow/farm-fresh/32/category-icon.png" /><br/>Categories
			</a> 
		</div>
		
		<div>
			<a href="list_books">
				<img src="http://icons.iconarchive.com/icons/robinweatherall/library/32/books-icon.png" /><br/>Books
			</a> 
		</div>
		
		<div>
			<a href="list_customer">
				<img src="http://icons.iconarchive.com/icons/custom-icon-design/pretty-office-8/32/Users-icon.png" /><br/>Customers
			</a> 
		</div>
		
		<div>
			<a href="list_review">
				<img src="http://icons.iconarchive.com/icons/seanau/stockicons/32/review-icon.png" /><br/>Reviews
			</a> 
		</div>
		
		<div>
			<a href="list_order">
				<img src="http://icons.iconarchive.com/icons/fasticon/shop-cart/32/shop-cart-icon.png" /><br/>Orders
			</a> 
		</div>
	</div>
</div>