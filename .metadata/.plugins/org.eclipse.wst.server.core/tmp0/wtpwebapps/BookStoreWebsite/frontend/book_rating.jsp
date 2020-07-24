<c:forTokens items= "${book.ratingStars}" delims="," var="star">
	<c:if test="${star eq 'off'}">
		<img src="images/rating_off.png" width="30" height="30" />
	</c:if>
	<c:if test="${star eq 'on'}">
		<img src="images/rating_on.png" width="30" height="30" />
	</c:if>
	<c:if test="${star eq 'half'}">
		<img src="images/rating_half.png" width="30" height="30" />
	</c:if>
</c:forTokens>