<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, com.bean.Book"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/Homepage.css">
    <img src="<%=request.getContextPath()%>/img/tataLogo.png" alt="Tata Logo" width="20%" height="20%">
</head>
<body>
	<div class="viewBookingsClass">
		<form name="viewBook" action="<%=request.getContextPath()%>/TestDriveServlet" method="post">
		<input type="hidden" id="page" name="page" value="viewDatePage">
		<div class="viewDateClass">
			<label name="viewDateLabel">Select A Date</label>
			<input type="date" name="viewDateDate" value="mm/DD/YYYY">
		</div>
		<div class="viewDateBtns">
			<input type="submit" name="viewDateBtn" value="Search Date">
		</div>
		</form>
		<form name="viewBook" action="<%=request.getContextPath()%>/TestDriveServlet" method="post">
			<input type="hidden" id="page" name="page" value="viewAllPage">
			<div class="viewAllBtns">
				<input type="submit" name="viewAllBtn" value="View All">
			</div>
		</form>
	</div>
	<div class ="viewResultsClass">
					<p>${param.message}</p>
						<br><br>
						<table name="searchResultsTable">
							<tr>
								<th>ID</th>
								<th>Name</th>
								<th>License No</th>
								<th>Vehicle Make</th>
								<th>Date</th>
							</tr>
							<%
							List<Book> bookList = (List<Book>)request.getAttribute("bookList");
							if(bookList != null) {
								int count = -1;
								for(Book book: bookList) {
									count++;
						%>
							<tr>
								<td><%= book.getBookingID() %></td>
								<td><%= book.getCustomerName()%></td>
								<td><%= book.getLicenseNO()%></td>
								<td><%= book.getVehicleMake()%></td>
								<td><%= book.getProposedDate()%></td>
							</tr>


							<%
								}
							}
						%>
					</table>
	
	</div>
</body>
<footer>
	<a href="www.tatamotors.com">www.tatamotors.com</a>
</footer>
</html>