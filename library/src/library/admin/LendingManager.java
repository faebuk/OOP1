package library.admin;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import library.data.Customer;
import library.data.Item;
import library.data.Lending;
import library.data.State;

public class LendingManager {
    private Lending[] lendings;
    private int lendingCounter = 0;

    public LendingManager() {
	lendings = new Lending[50];
    }

    public Lending[] getLendings() {
	return lendings;
    }

    public boolean addLending(Customer customer, Item item, LocalDate date) throws ItemNotAvailableException {
	assert customer != null && item != null && date != null;
	if (!item.isAvailable()) {
	    throw new ItemNotAvailableException();
	}

	item.setState(State.LENT);
	Lending lending = new Lending(customer, item, date);
	item.setLending(lending);

	this.lendings[lendingCounter++] = lending;

	return true;
    }

    public boolean addLending(Lending lending) throws ItemNotAvailableException {
	assert lending != null;
	if (!lending.getItem().isAvailable()) {
	    throw new ItemNotAvailableException();
	}

	this.lendings[lendingCounter++] = lending;

	lending.getItem().setState(State.LENT);
	lending.getItem().setLending(lending);

	return true;
    }

    public boolean returnItem(Item item, LocalDate date) {
	assert item != null;
	item.setState(State.AVAILABLE);
	item.getLending().setReturnDate(date);

	return true;
    }

    public boolean isAvailable(Item item) {
	assert item != null;
	return item.isAvailable();
    }

    public long[] getAvailableItems(long[] ids) throws NoAvailableItemsException, NoItemsFoundException {
	List<Long> result = new ArrayList<>();

	Administration admin = Administration.getInstance();

	for (long id : ids) {
	    if (admin.findItem(id).isAvailable()) {
		result.add(id);
	    }
	}

	if (result.size() < 1) {
	    throw new NoAvailableItemsException();
	}

	return Utils.convertToArray(result);
    }

    public LocalDate getLendingEndDate(Item item) {
	Lending lending = item.getLending();
	if (lending != null)
	    return lending.getReturnDate();
	return LocalDate.now();
    }

    public LocalDate getTimeLimit(Item item) {
	Lending lending = item.getLending();
	if (lending != null)
	    return lending.getTimeLimit();
	return LocalDate.now();
    }

    public void printLendings() {
	for (Lending l : lendings) {
	    System.out.println(l.toString());
	}
    }
}
