package library.admin;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import library.data.Customer;
import library.data.Item;
import library.data.Lending;
import library.data.State;

public class LendingManager {
	private int lendingCounter = 0;
	
	private List<Lending> lendings;
	
	public LendingManager() {
		this.lendings = new ArrayList<>();
	}
	
	public Lending[] getLendings() {
		return (Lending[]) this.lendings.toArray();
	}
	
	public boolean isItemAvailable(Item item) {
		boolean itemWasLentOut = false;
		for(Lending lending : lendings) {
			if(lending.getItem().equals(item)) {
				itemWasLentOut = true;
				
				//item wurde zwar schon ausgeliehen, ist aber wieder verfügbar
				if(lending.getItem().isAvailable()) {
					return true;
				}
			}
		}
		
		//item wurde noch nie ausgeliehen
		if(!itemWasLentOut) {
			return true;
		}
		
		return false;
	}
	
	public boolean addLending(Customer customer, Item item, LocalDate date) {
		if(item.isAvailable()) {
			this.lendings.add(new Lending(customer, item, date));
		} else {
			return false;
		}		
		
		return true;
	}
	
	public boolean returnItem(Item item, LocalDate date) {
		for(Lending lending : this.lendings) {
			if(lending.getItem().equals(item) && lending.getReturnDate() == null) {
				lending.setReturnDate(date);
				lending.getItem().setState(State.AVAILABE);
				return true;
			}
		}
		
		return false;
	}
	
	public LocalDate getLendingEndDate(Item item) {
		Lending lastLending = null;
		
		for(Lending lending : lendings) {
			if(lending.getItem().equals(item) && (lastLending == null || lending.getStartDate().isAfter(lastLending.getStartDate()))) {
				lastLending = lending;
			}
		}
		
		if(lastLending != null && lastLending.getReturnDate() != null) {
			return lastLending.getReturnDate();
		}
		
		if(lastLending != null && lastLending.getStartDate() != null) {
			return lastLending.getStartDate().minusMonths(-1);
		}		
		
		return LocalDate.now();
	}
}
