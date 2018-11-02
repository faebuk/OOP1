package library.data;

import java.time.LocalDate;

public class Lending {
	private LocalDate startDate;
	private LocalDate returnDate;
	private Customer borrower;
	private Item item;

	public Lending(Customer borrower, Item item, LocalDate startDate) {
		this.borrower = borrower;
		this.item = item;
		this.startDate = startDate;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public LocalDate getTimeLimit() {
		return startDate.minusMonths(-1);
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	public Customer getBorrower() {
		return borrower;
	}

	public Item getItem() {
		return item;
	}

	@Override
	public String toString() {
		return "Lending from " + startDate + " of " + borrower + ", " + item;
	}
}
