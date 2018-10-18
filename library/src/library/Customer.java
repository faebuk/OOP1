package library;

public class Customer extends Person {
	private String email;
	private Account account;
		
	public Customer(String lastName, String firstName, String email) {
		super(firstName, lastName);
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
}
