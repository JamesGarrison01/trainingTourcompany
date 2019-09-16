package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Book;
import com.util.DBUtil;

public class BookingDAO {

	/*
	 * Adds a book to the SQL Database under tbl_booking
	 * Checks make sure it is not already listed
	 * returns 1 if valid any other number invalid
	 */
	public int addBook(Book book) {
		int bookValid = 0;

		Connection con = null;
		try {
			
			con  = DBUtil.getConnect();

			String checkDupe = "Select customername, licenseno from tbl_booking where Customername = ? AND LicenseNo = ?";
			PreparedStatement pstmt = con.prepareStatement(checkDupe);
			pstmt.setString(1, book.getCustomerName());
			pstmt.setString(2, book.getLicenseNO());
			String customerNameCheck = "";
			String licenseCheck = "";	
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				 customerNameCheck = rs.getString("CustomerName");
				 licenseCheck = rs.getString("LicenseNo");
			}
			
			if(!customerNameCheck.equals(book.getCustomerName()))  {
				if(licenseCheck.equals(book.getLicenseNO())) {
					bookValid = -1;
				}
				else {
					String query = "INSERT INTO tbl_booking (Customername, LicenseNo, VehicleMake,"
							+ "ProposedDate) VALUES (?,?,?,?)";
					PreparedStatement ps = con.prepareStatement(query);
					
					ps.setString(1, book.getCustomerName());
					ps.setString(2, book.getLicenseNO());
					ps.setString(3, book.getVehicleMake());
					ps.setDate(4, book.getProposedDate());
					
					if(ps.executeUpdate() == 1) {
						bookValid++;
					}
				}
			}
		} catch (SQLException e) {
	
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				DBUtil.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
			
		return bookValid;
		
	}

	/*
	 * Searches a for a book by a given date 
	 * returns book list that was gathered even if that list is empty
	 */
	public List<Book> searchByDate(Date date) {
		List<Book> bookList = new ArrayList<Book>();
		
		Connection con = null;
		try {
			
			con  = DBUtil.getConnect();
			
			String query = "select * from TBL_Booking where proposeddate = ?";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setDate(1, date);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Book book = new Book();
				book.setBookingID(rs.getInt("BookingID"));
				book.setCustomerName(rs.getString("CustomerName"));
				book.setLicenseNO(rs.getString("LicenseNo"));
				book.setVehicleMake(rs.getString("VehicleMake"));
				book.setProposedDate(rs.getDate("ProposedDate"));
				bookList.add(book);
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				DBUtil.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return bookList;
	}

	/*
	 * Returns all books that are listed in sql database
	 */
	public List<Book> returnAllBooks() {
		List<Book> bookList = new ArrayList<Book>();
		
		Connection con = null;
		try {
			
			con  = DBUtil.getConnect();
			
			String query = "select * from TBL_Booking";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Book book = new Book();
				book.setBookingID(rs.getInt("BookingID"));
				book.setCustomerName(rs.getString("CustomerName"));
				book.setLicenseNO(rs.getString("LicenseNo"));
				book.setVehicleMake(rs.getString("VehicleMake"));
				book.setProposedDate(rs.getDate("ProposedDate"));
				bookList.add(book);
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				DBUtil.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return bookList;
	}

	/*
	 * Cancels a book with a given book id
	 */
	public int cancelBook(int bookId) {
		int validation = 0;
		
		Connection con = null;
		try {
			con = DBUtil.getConnect();
			String query = "DELETE FROM TBL_Booking WHERE BookingID = ?";
		
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, bookId);
			
			if(ps.executeUpdate() == 1) {
				validation++;
			}
			ps.close();
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				DBUtil.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return validation;
	}
	
}
