package com.flightmanagement.main;

import java.util.ArrayList;
import java.util.List;

import com.flightmanagement.dao.BookingDao;
import com.flightmanagement.dao.UserDao;
import com.flightmanagement.model.*;
import com.flightmanagement.service.BookingService;
import com.flightmanagement.service.FlightService;
import com.flightmanagement.service.UserService;

public class FlightManagementSystem {
  public static void main(String [] args) {
	  UserDao userDao=new UserDao();
	BookingDao bookingDao=new BookingDao();
	
	   UserService userService=new UserService(userDao);
	 FlightService flightService=new FlightService();
	 BookingService bookingService=new BookingService(bookingDao,userService,flightService);
     // Add User
	 System.out.println("Adding Users Method");
	 User u1=new User("u1","alice",1000.00);
	 User u2=new User("u2","John",500.00);
	 userService.addUser(u1);
	 userService.addUser(u2);
	 List<User> u=new ArrayList<>();
	 u.add(u1);
	 u.add(u2);
	 System.out.println("User Information");
	 for(User i:u) {
	 System.out.println("Name:"+i.getName()+"\nFunds:"+i.getFunds());
	 }
	 
	 
	 
	 List<Seat> seatsForEconomy=new ArrayList<>();
	 for(int i=0;i<10;i++) {
		 seatsForEconomy.add(new Seat("A"+i,true));
	 }
	 List<Seat> seatsForBusiness=new ArrayList<>();
	 for(int i=0;i<10;i++) {
		 seatsForBusiness.add(new Seat("B"+i,true));
	 }
	
	 FareType economyType=new FareType("Economy",100.00,seatsForEconomy);
	 List<FareType> fareType=new ArrayList<>();
	 fareType.add(economyType);
	 FareType businessType=new FareType("Business",50.00,seatsForBusiness);
	 
	 fareType.add(businessType);
	 Flight f1=new Flight("FL1","6E","DEL","BOM",20231025,15,fareType);
	 flightService.addFlight(f1);
	 
	 // Search Flights method
	 System.out.println("Searching Flights Method");
	 List<Flight> availableFlights=flightService.searchFlights("DEL", "BOM", 20231021, 1);
	 System.out.println("Flights Available");
	 for(Flight flight:availableFlights) {
		 System.out.println("\n"+flight.getFlightNumber()+"from"+flight.getFrom()+"to"+flight.getTo());
	 }
	 List<String> seatsToBook=new ArrayList<>();
	 seatsToBook.add("A1");
	 seatsToBook.add("E1");
	 System.out.println("Booking Flights Method");
	 // Book Flights Method returning bookingId
	 String bookFlight=bookingService.bookFlight("u1", "DEL", "BOM","FL1", 20231025,"Economy",seatsToBook);
	 System.out.println("BookingId : "+bookFlight);
  }
}
