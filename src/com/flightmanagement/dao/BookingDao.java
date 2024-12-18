package com.flightmanagement.dao;

import java.util.Map;

import com.flightmanagement.model.Booking;

import java.util.HashMap;

public class BookingDao {
private Map<String,Booking> bookingMap=new HashMap<>();
public void addBooking(Booking booking) {
	bookingMap.put(booking.getBookingId(), booking);
}
}
