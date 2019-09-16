<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/Homepage.css">
    <img src="<%=request.getContextPath()%>/img/tataLogo.png" alt="Tata Logo" width="20%" height="20%">
</head>
<body>
	<form name="bookTest" action="<%=request.getContextPath()%>/TestDriveServlet" method="post" onSubmit="return formValidation();">
	<div class="testDriveClass">
		<p>	
			<%
				List<String> errorList = (List<String>)request.getAttribute("errorList");
				if(errorList != null) {
					for(String error : errorList) {
			%>
					<font color=red><%= error %></font>
			<%
				}
			}
			%>
		</p>
		<input type="hidden" id="page" name="page" value="testDrivePage">
		<div class="bodyClass">
			<div class="tableClass">
				<table>
					<tr>
					<th>Customer Name</th>
					<th>Drivers License No.</th>
					<th>Vehicle Make</th>
					<th>Test Drive Date</th></tr>
					<tr><td><input type="text" name="customerNameText" required></td>
					<td><input type="text" name="driveNoText" required></td>
					<td><select name="carMakeSelect" required>
							<option name="zestOption">Zest</option>
							<option name="safariOption">Safari</option>
							<option name="manzaOption">Manza</option>
						</select>
					</td>
					<td><input type="date" name="testDateDate" required></td></tr>
				</table>
			</div>
			<div class="testBtnClass">
				<input type="submit" name="testBtnSubmit">
			</div>
		</div>
	</div>
	</form>
</body>
<footer>
	<a href="www.tatamotors.com">www.tatamotors.com</a>
</footer>
</html>