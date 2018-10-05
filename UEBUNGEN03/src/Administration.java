import java.time.LocalDate;

public class Administration {
	private Object[] objects;
	private Lending[] lendings;
	private Reservation[] reservations;
	private Customer[] customers;

	public Administration() {
		objects = new Object[20];
		lendings = new Lending[20];
		reservations = new Reservation[20];
		customers = new Customer[20];
	};

	public Lending[] getLendings() {
		return lendings;
	}
	
	public Reservation[] getReservations() {
		return reservations;
	}

	public Object[] getObjects() {
		return objects;
	}

	public Customer[] getCustomers() {
		return customers;
	}

	public void printObjects() {
		for (Object e : objects) {
			System.out.println(e.toString());
		}
	}

	public void printLendings() {
		for (Lending l : lendings) {
			System.out.println(l.toString());
		}
	}
	
	public void testSetUp() {
		int counter = 1;
		Writer[] w = new Writer[7];
		w[0] = new Writer("Schreiberin", "Barbara");
		w[1] = new Writer("Schreiber", "Hans");
		w[2] = new Writer("Schreiber", "Peter");
		w[3] = new Writer("Schreiber", "Willi");
		w[4] = new Writer("Schreiber", "Rolf");
		w[5] = new Writer("Schreiberin", "Anna");
		w[6] = new Writer("Schreiberin", "Marie");
		objects[0] = new Book(counter++, "On the Road", w[0], 530);
		objects[1] = new Book(counter++, "The last Day", w[1], 650);
		objects[2] = new Book(counter++, "Behind the Moon", w[2], 300);
		objects[3] = new Book(counter++, "The Day after", w[3], 620);
		objects[4] = new Book(counter++, "The Hour", w[4], 510);
		objects[5] = new Book(counter++, "Kings Field", w[5], 320);
		objects[6] = new Book(counter++, "Why", w[6], 170);
		objects[7] = new Music(counter++, "The Best Of", "Abba", 68);
		objects[8] = new Music(counter++, "The Best Of", "Pink Floyd", 72);
		objects[9] = new Film(counter++, "Star Wars", "Lucas Film", 145);
		objects[10] = new Film(counter++, "Star Wars", "Lucas Film", 145);
		objects[11] = new Journal(counter++, "Nature", "Springer", 108);
		objects[12] = new Journal(counter++, "GEO", "Gruner", 82);

		Customer leser = new Customer("Leser", "Bruno", "bruno@leser.com");
		Customer seher = new Customer("Seher", "Kurt", "kurt@seher.com");
		Customer hoerer = new Customer("Hörer", "Emma", "emma@hoerer.com");

		lendings[0] = new Lending(leser, objects[1], LocalDate.of(2018, 9, 4));
		lendings[1] = new Lending(leser, objects[2], LocalDate.of(2018, 9, 21));
		lendings[2] = new Lending(leser, objects[12], LocalDate.of(2018, 9, 21));
		lendings[3] = new Lending(hoerer, objects[7], LocalDate.of(2018, 9, 23));
		lendings[4] = new Lending(hoerer, objects[8], LocalDate.of(2018, 9, 23));
		lendings[5] = new Lending(seher, objects[10], LocalDate.of(2018, 9, 24));
		lendings[6] = new Lending(seher, objects[9], LocalDate.of(2018, 9, 24));
		lendings[7] = new Lending(seher, objects[1], LocalDate.of(2018, 10, 1));

		reservations[0] = new Reservation(leser, objects[12], LocalDate.of(2018, 10, 1));
		reservations[1] = new Reservation(leser, objects[7], LocalDate.of(2018, 10, 2));
	}
}
