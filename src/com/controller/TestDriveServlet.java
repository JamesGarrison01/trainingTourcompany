package com.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Book;
import com.dao.BookingDAO;

/**
 * Servlet implementation class TestDriveServlet
 */
@WebServlet("/TestDriveServlet")
public class TestDriveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestDriveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		BookingDAO bookingDAO = new BookingDAO();
		
		if("testDrivePage".equals(page)) {
			String customerName = request.getParameter("customerNameText");
			String licenseNo = request.getParameter("driveNoText");
			String vehicleMake = request.getParameter("carMakeSelect");
			String proposedDate = request.getParameter("testDateDate");
			Date date= Date.valueOf(proposedDate);
			
			List<String> errorList = new ArrayList<>();
			Pattern pattern = Pattern.compile("^[0-9]+$");
			Matcher matcher = pattern.matcher(customerName);
			
			Pattern pattern2 = Pattern.compile("^[a-zA-Z0-9]+$");
			Matcher matcher2 = pattern.matcher(licenseNo);
			
			if(customerName.isEmpty()) {
				errorList.add("No Name Provided");
			}
			if(matcher.matches()) {
				errorList.add("Name Can Not Contain Numbers");
			}
			if(licenseNo.isEmpty()) {
				errorList.add("No License Provided");
			}
			if(matcher.matches()) {
				errorList.add("License Must contain Letters and Numbers");
			}
			if(vehicleMake.isEmpty()) {
				errorList.add("No Vehicle Make Provided");
			}
			if(proposedDate.isEmpty()) {
				errorList.add("No Date Provided");
			}
			if(!errorList.isEmpty()) {
				request.setAttribute("errorList", errorList);
				
				RequestDispatcher reqDispatch = request.getRequestDispatcher("pages/TestDriveBooking.jsp");
				reqDispatch.forward(request, response);
			}
			else {
			
			Book book = new Book();
			book.setCustomerName(customerName);
			book.setLicenseNO(licenseNo);
			book.setVehicleMake(vehicleMake);
			book.setProposedDate(date);
			
			if(bookingDAO.addBook(book) == 1) {
				RequestDispatcher reqDispatch = request.getRequestDispatcher("pages/Confirmation.jsp");
				reqDispatch.forward(request, response);
			}
			else {
				RequestDispatcher reqDispatch = request.getRequestDispatcher("pages/Error.jsp");
				reqDispatch.forward(request, response);
			}
			}
		}
		else if("viewDatePage".equals(page)) {
			String proposedDate = request.getParameter("viewDateDate");
			Date date= Date.valueOf(proposedDate);
			List<Book> bookList = new ArrayList<Book>();
			if(date.equals(null)) {
				String message = "<font color=red>Bad Date Provided</font>";
				response.sendRedirect("pages/ViewBookings.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
			}
			
			bookList = bookingDAO.searchByDate(date);
			
			if(bookList.isEmpty()) {
				String message = "<font color=red>No Tours Listed At Date</font>";
				response.sendRedirect("pages/ViewBookings.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
			}
			else {
				request.setAttribute("bookList", bookList);
				
				RequestDispatcher reqDispatch = request.getRequestDispatcher("pages/ViewBookings.jsp");
				reqDispatch.forward(request, response);
			}
		}
		else if("viewAllPage".equals(page)) {
			List<Book> bookList = new ArrayList<Book>();
			bookList = bookingDAO.returnAllBooks();
			
			if(bookList.isEmpty()) {
				String message = "<font color=red>No Tours Listed</font>";
				response.sendRedirect("pages/ViewBookings.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
			}
			else {
				request.setAttribute("bookList", bookList);
				
				RequestDispatcher reqDispatch = request.getRequestDispatcher("pages/ViewBookings.jsp");
				reqDispatch.forward(request, response);
			}
		}
		else if("cancelPage".equals(page)) {
			int confirm = 0;
			String newID = request.getParameter("cancelText");
			if(newID.equals(null)) {
				newID = "-1";
			}
			int bookId = Integer.parseInt(newID);
			confirm = bookingDAO.cancelBook(bookId);
			if(confirm == 0) {
				String message = "<font color=red>Tour Was Not Found</font>";
				response.sendRedirect("pages/CancelBooking.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
			}
			else {
				String message = "<font color=green>Tour Was Canceled</font>";
				response.sendRedirect("pages/CancelBooking.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
			}
		}
	}

}
