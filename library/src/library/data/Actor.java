package library.data;

public class Actor extends Person {

	public Actor(String lastName, String firstName) {
		super(lastName, firstName);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Actor) {
			Actor a = (Actor) obj;
			if (a.firstName != firstName)
				return false;
			if (a.lastName != lastName)
				return false;
			else
				return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Actor: " + super.toString(); 
	}

}
