package com.flightmanagement.model;

import java.util.List;

public class Booking {
private String bookingId;
private String userId;
private String flightNumber;
private int departDate;
private String fareType;
private List<String> bookedSeats;
public Booking(String bookingid,String userId,String flightNumber,int departDate,String fareType,List<String> bookedSeats) {
	this.bookingId= bookingId;
	this.userId=userId;
	this.flightNumber=flightNumber;
	this.departDate=departDate;
	this.fareType=fareType;
	this.bookedSeats=bookedSeats;
}
public String getBookingId() {
	return bookingId;
}
}
