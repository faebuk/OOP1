import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Person {
	// Attributes
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	private String email;

	// Constructor
	public Person(String f, String l, int year, int month, int day) {
		firstName = f;
		lastName = l;
		dateOfBirth = LocalDate.of(year, month, day);
	}

	// Methods
	public String getName() {
		String s = firstName + " " + lastName;
		return s;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString() {
		String date = dateOfBirth.format(DateTimeFormatter.ofPattern("dd.MM.yy"));
		return getName() + " " + date;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}
}