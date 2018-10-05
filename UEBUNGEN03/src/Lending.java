import java.time.LocalDate;

public class Lending {
	private Object object;
	private LocalDate startDate;
	private Customer borrower;
		
	public Lending(Customer borrower, Object object, LocalDate startDate) {
		this.object = object;
		this.startDate = startDate;
		this.borrower = borrower;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
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
	
	
}
