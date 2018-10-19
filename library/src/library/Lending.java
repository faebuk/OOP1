package library;

import java.time.LocalDate;

public class Lending {
	private DataObject object;
	private LocalDate startDate;
	private LocalDate returnDate;
	private Customer borrower;

	public Lending(Customer borrower, DataObject object, LocalDate startDate) {
		this.object = object;
		this.startDate = startDate;
		this.borrower = borrower;
	}

	public DataObject getDataObject() {
		return object;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public Customer getBorrower() {
		return borrower;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	public LocalDate getReturnDate() {
		return this.returnDate;
	}

	public LocalDate getTimeLimit() {
		return this.getStartDate().minusMonths(-1);
	}

	@Override
	public String toString() {
		return "Lending [object=" + object + ", startDate=" + startDate + ", returnDate=" + returnDate + ", borrower="
				+ borrower + "]";
	}
}
