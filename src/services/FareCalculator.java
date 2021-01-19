package services;

import java.time.LocalDate;

import model.Bus;
import model.Flight;
import model.Hotel;
import model.Train;

// Type your code
public class FareCalculator extends Booking {
	public double book(Hotel hotel) {
		if(hotel.getNoOfPersons() == 1) {
			if(hotel.getOccupancy() == "Single") {
				return booking(hotel.getNoOfPersons(), hotel.getRates());
			}
			else
				return booking(1, hotel.getRates());
		}
		LocalDate d1 = hotel.getFromdate();
		LocalDate d2 = hotel.getTodate();
		if(d1.compareTo(d2) < 0)
			return booking(hotel.getNoOfPersons(), hotel.getRates());
		
		if(hotel.getNoOfPersons() == 3) {
			if(hotel.getOccupancy() == "1 Double and 1 Single") {
				return booking(hotel.getNoOfPersons(), hotel.getRates());
			}
			else
				return -1;
		}
		return booking(hotel.getNoOfPersons(), hotel.getRates());
	}
	
	public double book(Flight flight) {
		LocalDate d1 = flight.getFrom();
		LocalDate d2 = flight.getTo();
		if(flight.getTriptype() == "round trip") {
			if(d1.compareTo(d2) < 0)
				return booking(flight.getNoOfPersons(), flight.getRates());	
			else
				return -1;
	    }
		return booking(flight.getNoOfPersons(), flight.getRates());
	}
	
	public double book(Train train) {
		return booking(train.getNoOfPersons(), train.getRates());		
	}
	
	public double book(Bus bus) {
		return booking(bus.getNoOfPersons(), bus.getRates());		
	}
}