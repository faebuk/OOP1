package library.data;
import java.time.LocalDate;

public class Reservation {
	private DataObject object;
	private Customer borrower;
	private LocalDate reservationDate;
	
	
	public Reservation(Customer borrower, DataObject object, LocalDate reservationDate) {
		this.object = object;
		this.borrower = borrower;
		this.reservationDate = reservationDate;
	}
	public DataObject getObject() {
		return object;
	}
	public void setObject(DataObject object) {
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
