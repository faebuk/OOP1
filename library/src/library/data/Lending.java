package library.data;

import java.time.LocalDate;

public class Lending {
	private Item item;
	private LocalDate startDate;
	private LocalDate returnDate;
	private Customer borrower;

	public Lending(Customer borrower, Item item, LocalDate startDate) {
		this.item = item;
		this.startDate = startDate;
		this.borrower = borrower;
		
		this.item.setState(State.LENT);
	}

	public Item getItem() {
		return item;
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
		return "Lending [item=" + item + ", startDate=" + startDate + ", returnDate=" + returnDate + ", borrower="
				+ borrower + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((borrower == null) ? 0 : borrower.hashCode());
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + ((returnDate == null) ? 0 : returnDate.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lending other = (Lending) obj;
		if (borrower == null) {
			if (other.borrower != null)
				return false;
		} else if (!borrower.equals(other.borrower))
			return false;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (returnDate == null) {
			if (other.returnDate != null)
				return false;
		} else if (!returnDate.equals(other.returnDate))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		return true;
	}
	
	
}
