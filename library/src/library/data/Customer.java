package library.data;


public class Customer  extends Person{
	private String email;

	public Customer(String lastName, String firstName, String email) {
		super(lastName, firstName);
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Person: " + super.toString();
	}

}
