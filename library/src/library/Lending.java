package library;
import java.time.LocalDate;

public class Lending {
	private Item object;
	private LocalDate startDate;
	private LocalDate returnDate;
	private Customer borrower;
		
	public Lending(Customer borrower, Item object, LocalDate startDate) {
		this.object = object;
		this.startDate = startDate;
		this.borrower = borrower;
	}
	public Item getObject() {
		return object;
	}
	public void setObject(Item object) {
		this.object = object;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public Customer getBorrower() {
		return borrower;
	}
	public void setBorrower(Customer borrower) {
		this.borrower = borrower;
	}
	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;		
	}
	public LocalDate getReturnDate() {
		return this.returnDate;
	}	
	
}
