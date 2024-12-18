package com.flightmanagement.model;

import java.util.ArrayList;
import java.util.List;

public class Flight {
	private String flightNumber;
	 private String airline;
	 private String from;
	 private String to;
	 private int departDate;
	 private double departTime;
	 private List<FareType> fareTypes;
	 public Flight(String flightNumber,String airline,String from,String to,int departDate,int departTime,List<FareType> fareTypes) {
		 this.flightNumber=flightNumber;
		 this.airline=airline;
		 this.from=from;
		 this.to=to;
		 this.departDate=departDate;
		 this.departTime=departTime;
		 this.fareTypes=new ArrayList<>(fareTypes);
		 
	 }
 public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public int getDepartDate() {
		return departDate;
	}
	public void setDepartDate(int departDate) {
		this.departDate = departDate;
	}
	public double getDepartTime() {
		return departTime;
	}
	public void setDepartTime(double departTime) {
		this.departTime = departTime;
	}
	public List<FareType> getFareTypes() {
		return fareTypes;
	}
	public void setFareTypes(List<FareType> fareTypes) {
		this.fareTypes = fareTypes;
	}
   public List<Seat> getAvailableSeats(String fareType){
	   for(FareType fare:fareTypes) {
		   if(fare.getFareType().equalsIgnoreCase(fareType)){
			   return fare.getAvailableSeats();
		   }
	   }
	   return null;
   }
}
