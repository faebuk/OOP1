package library.data;

public class Person {

	protected String lastName;
	protected String firstName;

	public Person(String lastName, String firstName) {
		this.lastName = lastName;
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Writer) {
			Person p = (Person) obj;
			if (p.firstName != firstName)
				return false;
			if (p.lastName != lastName)
				return false;
			else
				return true;
		}
		return false;
	}

	@Override
	public String toString() {
		


		
		return "lastName=" + lastName + ", firstName=" + firstName;
	}
	
}
