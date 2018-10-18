package library;
import java.time.LocalDate;

public class Administration {
	private Item[] objects;
	private Lending[] lendings;
	private Reservation[] reservations;
	private Customer[] customers;

	public Administration() {
		objects = new Item[20];
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

	public Item[] getObjects() {
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
	
	public Journal findJournal(long articleNumber) {
		Item object = this.findItem(articleNumber);
		
		if(object instanceof Journal) {
			return (Journal)object;
		}
		
		return null;
	}
	
	public Journal findJournal(String title) {
		Item object = this.findItem(title);
		
		if(object instanceof Journal) {
			return (Journal)object;
		}
		
		return null;
	}
	
	public Book findBook(String title) {
		Item object = this.findItem(title);
		
		if(object instanceof Book) {
			return (Book)object;
		}
		
		return null;
	}
	
	public Book findBook(Writer writer) {
		for(Item object : this.objects) {
			if(object instanceof Book && ((Book) object).getWriter().equals(writer)) {
				return (Book)object;
			}
		}
		
		return null;
	}
	
	public Film findFilm(String title) {
		Item object = this.findItem(title);
		
		if(object instanceof Film) {
			return (Film)object;
		}
		
		return null;
	}
	
	public Film findFilm(Actor searchActor) {
		for(Item object : this.objects) {
			if(object instanceof Film) {
				for(Actor actor : ((Film) object).getActors()) {
					if(actor.equals(searchActor)) {
						return (Film)object;
					}
				}
			}
		}
		
		return null;
	}
	
	public Music findMusic(String band) {
		for(Item object : this.objects) {
			if(object instanceof Music && ((Music) object).getBandName().equals(band)){
				return (Music)object;
			}
		}
		
		return null;
	}
	
	private Item findItem(String title) {
		for(Item object : this.objects) {
			if(object != null && object.getTitle().equals(title)) {
				return object;
			}
		}
		
		return null;
	}
	
	private Item findItem(long articleNumber) {
		for(Item object : this.objects) {
			if(object != null && object.getArticleNumber() == articleNumber) {
				return object;
			}
		}
		
		return null;
	}
	
	public boolean isBookAvailable(Book book) {
		return this.isItemAvailable(book);
	}
	
	public boolean isJournalAvailable(Journal journal) {
		return this.isItemAvailable(journal);
	}
	
	public boolean isFilmAvailable(Film film) {
		return this.isItemAvailable(film);
	}
	
	public boolean isMusicAvailable(Music music) {
		return this.isItemAvailable(music);
	}
	
	private boolean isItemAvailable(Item object) {
		for(Lending lending : this.lendings) {
			if(lending.getObject().equals(object) && lending.getReturnDate() == null) {
				return false;
			}
		}
		
		return true;
	}
	
	public LocalDate getLendingEndDate(Item object) {
		Lending lastLending = null;
		
		for(Lending lending : lendings) {
			if(lending.getObject().equals(object) && (lastLending == null || lending.getStartDate().isAfter(lastLending.getStartDate()))) {
				lastLending = lending;
			}
		}
		
		/*for(Lending lending : lendings) {
			if(lending.getObject().equals(object) && lending.getReturnDate() != null) {
				return lending.getReturnDate();
			}
			
			if(lending.getObject().equals(object) && lending.getStartDate() != null) {
				return lending.getStartDate().minusMonths(-1);
			}
		}*/
		
		if(lastLending != null && lastLending.getReturnDate() != null) {
			return lastLending.getReturnDate();
		}
		
		if(lastLending != null && lastLending.getStartDate() != null) {
			return lastLending.getStartDate().minusMonths(-1);
		}
		
		
		return LocalDate.now();
	}
	
}
