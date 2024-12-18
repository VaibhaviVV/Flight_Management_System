package com.flightmanagement.service;

import java.util.List;
import java.util.UUID;

import com.flightmanagement.dao.BookingDao;
import com.flightmanagement.model.Flight;
import com.flightmanagement.model.Seat;
import com.flightmanagement.model.User;
import com.flightmanagement.model.Booking;
import com.flightmanagement.model.FareType;

public class BookingService {
private BookingDao bookingDao;
private UserService userService;
private FlightService flightService;
public BookingService(BookingDao bookingDao,UserService userService,FlightService flightService) {
	this.bookingDao=bookingDao;
	this.userService=userService;
	this.flightService=flightService;
	
}
public String bookFlight(String userId,String from,String to,String flightNumber,int departDate,String fareType,List<String> seats) {
	User user=userService.getUser(userId);
	Flight flight=flightService.getFlight(flightNumber);
	if(flight==null) {
		return "Flight not found";
	}
	List<Seat> availableSeats=flight.getAvailableSeats(fareType);
	if(availableSeats==null) {
		return "Seats for fareType not found";
		
	}
	FareType fare=flight.getFareTypes().stream()
			       .filter(f->f.getFareType().equalsIgnoreCase(fareType)).findFirst().orElse(null);
     if(fare!=null && fare.areSeatsAvailable(seats)) {
    	 double totalprice=fare.getPrice()*seats.size();
    	 if(user.getFunds()>=totalprice) {
    		 user.deductFunds(totalprice);
    		 fare.bookSeats(seats);
    		 String bookingId=UUID.randomUUID().toString();
    		 Booking booking=new Booking(bookingId,userId,flightNumber,departDate,fareType,seats);
    		 bookingDao.addBooking(booking);
    		 return bookingId;
    	 }
    	 else {
    		 return "Insufficient funds";
    	 }
     }
     return "Seats are not available";

}
}
