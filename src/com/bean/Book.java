package com.bean;

import java.sql.Date;

public class Book {
	int bookingID;
	String customerName;
	String licenseNO;
	String vehicleMake;
	Date proposedDate;
	
	public Book() {
		
	}

	public Book(int bookingID, String customerName, String licenseNO, String vehicleMake, Date proposedDate) {
		super();
		this.bookingID = bookingID;
		this.customerName = customerName;
		this.licenseNO = licenseNO;
		this.vehicleMake = vehicleMake;
		this.proposedDate = proposedDate;
	}

	public int getBookingID() {
		return bookingID;
	}

	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getLicenseNO() {
		return licenseNO;
	}

	public void setLicenseNO(String licenseNO) {
		this.licenseNO = licenseNO;
	}

	public String getVehicleMake() {
		return vehicleMake;
	}

	public void setVehicleMake(String vehicleMake) {
		this.vehicleMake = vehicleMake;
	}

	public Date getProposedDate() {
		return proposedDate;
	}

	public void setProposedDate(Date proposedDate) {
		this.proposedDate = proposedDate;
	}

	@Override
	public String toString() {
		return "Book [bookingID=" + bookingID + ", customerName=" + customerName + ", licenseNO=" + licenseNO
				+ ", vehicleMake=" + vehicleMake + ", proposedDate=" + proposedDate + "]";
	}
	
	
}
