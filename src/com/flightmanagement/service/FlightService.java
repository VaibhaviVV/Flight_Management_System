package com.flightmanagement.service;
import java.util.List;
import java.util.ArrayList;
import com.flightmanagement.model.Flight;
import com.flightmanagement.model.FareType;
public class FlightService {
private List<Flight> flights=new ArrayList<>();
public void addFlight(Flight flight) {
	flights.add(flight);
}
public List<Flight> searchFlights(String from,String to,int departDate,int paxcount){
	List<Flight> availableFlights=new ArrayList<>();
	for(Flight flight:flights) {
		if(flight.getFrom().equalsIgnoreCase(from)&& flight.getTo().equalsIgnoreCase(to)
				&& flight.getDepartDate()==departDate) {
			for(FareType fareType:flight.getFareTypes()) {
				if(fareType.getAvailableSeats().size()>=paxcount) {
					availableFlights.add(flight);
					break;
				}
			}
		}
	}
	return availableFlights;
}
	public Flight getFlight(String flightNumber) {
		return flights.stream()
				.filter(flight->flight.getFlightNumber().equalsIgnoreCase(flightNumber))
				.findFirst()
				.orElse(null);
	}

}
