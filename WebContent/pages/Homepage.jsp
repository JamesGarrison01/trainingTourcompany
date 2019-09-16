<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/Homepage.css">
    <img src="<%=request.getContextPath()%>/img/tataLogo.png" alt="Tata Logo" width="20%" height="20%">
    <a href="img/tataLogo"></a>
</head>
<body>
	<div class="homePageClass">
		<div class="bodyClass">
			<div class="linksClass">
				<a href="<%=request.getContextPath()%>/pages/TestDriveBooking.jsp">Book a Test Drive</a>
				<a href="<%=request.getContextPath()%>/pages/CancelBooking.jsp">Cancel a Test Drive</a>
				<a href="<%=request.getContextPath()%>/pages/ViewBookings.jsp">Search For A Test Drive</a>		
			</div>
		</div>
	</div>

</body>
<footer>
	<a href="www.tatamotors.com">www.tatamotors.com</a>
</footer>
</html>