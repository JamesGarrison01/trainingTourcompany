<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/Homepage.css">
    <img src="<%=request.getContextPath()%>/img/tataLogo.png" alt="Tata Logo" width="20%" height="20%">
</head>
<body>
	<form name="viewBook" action="<%=request.getContextPath()%>/TestDriveServlet" method="post">
		<input type="hidden" id="page" name="page" value="cancelPage">
		<div class="cancelMainClass">
			<div class="cancelSubClass">
				<label name="cancelIDLabel">Input ID to cancel</label>
				<input type="text" name="cancelText">
			</div>
			<div class="cancelBtns">
				<input type="submit" name="cancelBtn" value="Cancel Book">
			</div>
			<div class="results">
				<p>${param.message}</p>
				<a href="<%=request.getContextPath()%>/pages/Homepage.jsp">Return Home</a>
			</div>
		</div>
	</form>
	
</body>
<footer>
	<a href="www.tatamotors.com">www.tatamotors.com</a>
</footer>
</html>