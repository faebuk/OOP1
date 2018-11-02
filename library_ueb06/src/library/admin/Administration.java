package library.admin;
import java.time.LocalDate;

import library.data.Actor;
import library.data.BookItem;
import library.data.Customer;
import library.data.DataObject;
import library.data.FilmItem;
import library.data.Item;
import library.data.JournalItem;
import library.data.MusicItem;
import library.data.Reservation;
import library.data.Writer;

public class Administration {
	private LendingManager lendingManager;
	private DataManager dataManager;
	
	private static Administration instance;
	
	private Administration() {
		this.lendingManager = new LendingManager();
		this.dataManager = new DataManager();
	}
	
	public static synchronized Administration getInstance() {
		if(instance == null) {
			instance = new Administration();
		}
		
		return instance;
	}
	
	public DataObject[] getDataObjects(){
		return this.dataManager.getDataObjects();
	}
	
	public BookItem[] getBookItems() {
		return this.dataManager.getBookItems();
	}
	
	public FilmItem[] getFilmItems() {
		return this.dataManager.getFilmItems();
	}
	
	public MusicItem[] getMusicItems() {
		return this.dataManager.getMusicItems();
	}
	
	public JournalItem[] getJournalItems() {
		return this.dataManager.getJournalItems();
	}
	
	public long[] findBookItems(Writer writer) {
		return this.dataManager.findBookItems(writer);
	}
	
	public long[] findMusicItems(String string) {
		return this.dataManager.findMusicItems(string);
	}
	
	public DataObject findDataObject(String title){
		return this.dataManager.findDataObject(title);
	}
	
	public long[] findItems(String title) {
		return this.dataManager.findItems(title);
	}
	
	public long[] findFilmItems(Actor actor) {
		return this.dataManager.findFilmItems(actor);
	}
	
	public boolean isItemAvailable(Item item) {
		return this.lendingManager.isItemAvailable(item);
	}
	
	public LocalDate getLendingEndDate(Item item) {
		return this.lendingManager.getLendingEndDate(item);
	}
	
	public void addLending(Customer customer, Item item, LocalDate date) {
		this.lendingManager.addLending(customer, item, date);
	}
	
	public void returnItem(Item item, LocalDate date) {
		this.lendingManager.returnItem(item, date);
	}
	
	/*private DataObject[] objects;
	private Lending[] lendings;
	private Reservation[] reservations;
	private Customer[] customers;

	public Administration() {
		objects = new DataObject[20];
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

	public DataObject[] getDataObjects() {
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
		DataObject object = this.findDataObject(articleNumber);
		
		if(object instanceof Journal) {
			return (Journal)object;
		}
		
		return null;
	}
	
	public Journal findJournal(String title) {
		DataObject object = this.findDataObject(title);
		
		if(object instanceof Journal) {
			return (Journal)object;
		}
		
		return null;
	}
	
	public Book findBook(String title) {
		DataObject object = this.findDataObject(title);
		
		if(object instanceof Book) {
			return (Book)object;
		}
		
		return null;
	}
	
	public Book findBook(Writer writer) {
		for(DataObject object : this.objects) {
			if(object instanceof Book && ((Book) object).getWriter().equals(writer)) {
				return (Book)object;
			}
		}
		
		return null;
	}
	
	public Film findFilm(String title) {
		DataObject object = this.findDataObject(title);
		
		if(object instanceof Film) {
			return (Film)object;
		}
		
		return null;
	}
	
	public Film findFilm(Actor searchActor) {
		for(DataObject object : this.objects) {
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
		for(DataObject object : this.objects) {
			if(object instanceof Music && ((Music) object).getBandName().equals(band)){
				return (Music)object;
			}
		}
		
		return null;
	}
	
	private DataObject findDataObject(String title) {
		for(DataObject object : this.objects) {
			if(object != null && object.getTitle().equals(title)) {
				return object;
			}
		}
		
		return null;
	}
	
	private DataObject findDataObject(long articleNumber) {
		for(DataObject object : this.objects) {
			if(object != null && object.getArticleNumber() == articleNumber) {
				return object;
			}
		}
		
		return null;
	}
	
	public boolean isBookAvailable(Book book) {
		return this.isObjectAvailable(book);
	}
	
	public boolean isJournalAvailable(Journal journal) {
		return this.isObjectAvailable(journal);
	}
	
	public boolean isFilmAvailable(Film film) {
		return this.isObjectAvailable(film);
	}
	
	public boolean isMusicAvailable(Music music) {
		return this.isObjectAvailable(music);
	}
	
	private boolean isObjectAvailable(DataObject object) {
		for(Lending lending : this.lendings) {
			if(lending.getDataObject().equals(object) && lending.getReturnDate() == null) {
				return false;
			}
		}
		
		return true;
	}
	
	public LocalDate getLendingEndDate(DataObject object) {
		Lending lastLending = null;
		
		for(Lending lending : lendings) {
			if(lending.getDataObject().equals(object) && (lastLending == null || lending.getStartDate().isAfter(lastLending.getStartDate()))) {
				lastLending = lending;
			}
		}
		
		if(lastLending != null && lastLending.getReturnDate() != null) {
			return lastLending.getReturnDate();
		}
		
		if(lastLending != null && lastLending.getStartDate() != null) {
			return lastLending.getStartDate().minusMonths(-1);
		}		
		
		return LocalDate.now();
	}*/
	
}
