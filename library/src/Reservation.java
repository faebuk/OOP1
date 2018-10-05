import java.time.LocalDate;

public class Reservation {
	private Object object;
	private Customer borrower;
	private LocalDate reservationDate;
	
	
	public Reservation(Customer borrower, Object object, LocalDate reservationDate) {
		this.object = object;
		this.borrower = borrower;
		this.reservationDate = reservationDate;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	public Customer getBorrower() {
		return borrower;
	}
	public void setBorrower(Customer borrower) {
		this.borrower = borrower;
	}
	public LocalDate getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(LocalDate reservationDate) {
		this.reservationDate = reservationDate;
	}
}
