package com.flightmanagement.model;

import java.util.ArrayList;
import java.util.List;

public class FareType {
  private String fareType;
  private double price;
  private List<Seat> availableSeats;
  private  boolean flag;
  
  public FareType(String fareType,double price,List<Seat> seats) {
	  
	  this.fareType=fareType;
	  this.price=price;
	  this.availableSeats=new ArrayList<>(seats);
  }
  public String getFareType() {
	return fareType;
}
public void setFareType(String fareType) {
	this.fareType = fareType;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}

public List<Seat> getAvailableSeats() {
	return availableSeats;
}
public void setAvailableSeats(List<Seat> availableSeats) {
	this.availableSeats = availableSeats;
}
public boolean areSeatsAvailable(List<String> seatsToBook) {
	
	return availableSeats.stream()
			.filter(seat->seatsToBook.contains(seat.getSeatNumber())).allMatch(Seat::isAvailable);
}
public void bookSeats(List<String> seatsToBook) {
	
	for(String seat:seatsToBook) {
		for(Seat s:availableSeats) {
			if(s.getSeatNumber().equals(seat)) {
				
				s.setAvailable(false);
			}
			
		}
	}
}

}
