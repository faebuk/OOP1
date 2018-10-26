package library.admin;
import java.time.LocalDate;

import library.admin.Administration;
import library.data.Actor;
import library.data.Book;
import library.data.BookItem;
import library.data.Customer;
import library.data.DataObject;
import library.data.Film;
import library.data.FilmItem;
import library.data.Journal;
import library.data.JournalItem;
import library.data.Music;
import library.data.MusicItem;
import library.data.Writer;

public class TestSetUp {

	public static Administration testSetUp() {
		Administration admin = Administration.getInstance();
		DataObject[] objects = admin.getDataObjects();
		long counter = 1;
		long ean = (int) (Math.random() * 10000000);

		BookItem[] bookItems = admin.getBookItems();
		Writer[] w = new Writer[7];
		w[0] = new Writer("Schreiberin", "Barbara");
		w[1] = new Writer("Schreiber", "Hans");
		w[2] = new Writer("Schreiber", "Peter");
		w[3] = new Writer("Schreiber", "Willi");
		w[4] = new Writer("Schreiberin", "Anna");
		bookItems[0] = new BookItem(counter++, new Book(ean++, "On the Road", w[0], 530));
		bookItems[1] = new BookItem(counter++, new Book(ean++, "The last Day", w[1], 650));
		bookItems[2] = new BookItem(counter++, new Book(ean++, "Behind the Moon", w[2], 300));
		bookItems[3] = new BookItem(counter++, new Book(ean++, "The Day after", w[3], 620));
		bookItems[4] = new BookItem(counter++, new Book(ean++, "The Hour", w[4], 510));
		bookItems[5] = new BookItem(counter++, new Book(ean++, "Kings Field", w[1], 320));
		bookItems[6] = new BookItem(counter++, new Book(ean++, "Why", w[2], 170));
		for (int i = 0; i < 7; i++) {
			bookItems[i+7] = new BookItem(counter++, bookItems[i].getBook());
		}
		int nr = 0;
		for (int i = 0; i < bookItems.length; i++) {
			if (bookItems[i] != null)
				objects[nr++] = bookItems[i].getBook();
		}

		MusicItem[] musicItems = admin.getMusicItems();
		musicItems[0] = new MusicItem(counter++, new Music(ean++, "The Best Of", "Abba", 68));
		musicItems[1] = new MusicItem(counter++, new Music(ean++, "The Best Of", "Pink Floyd", 72));
		musicItems[2] = new MusicItem(counter++, new Music(ean++, "Stars", "Enja", 81));
		musicItems[3] = new MusicItem(counter++, new Music(ean++, "Mattina", "Einaudi", 71));
		musicItems[4] = new MusicItem(counter++, new Music(ean++, "White", "Beatles", 92));
		musicItems[5] = new MusicItem(counter++, new Music(ean++, "Night Music", "Enja", 53));
		for (int i = 0; i < 6; i++) {
			musicItems[i+6] = new MusicItem(counter++, musicItems[i].getMusic());
		}
		for (int i = 0; i < musicItems.length; i++) {
			if (musicItems[i] != null)
				objects[nr++] = musicItems[i].getMusic();
		}
		
		FilmItem[] filmItems = admin.getFilmItems();
		filmItems[0] = new FilmItem(counter++, new Film(ean++, "Star Wars I", "Lucas Film", 145));
		filmItems[0].getFilm().addActor(new Actor("Norton", "Edward"), 0);
		filmItems[0].getFilm().addActor(new Actor("Bale", "Christian"), 1);
		filmItems[1] = new FilmItem(counter++, new Film(ean++, "Star Wars II", "Lucas Film", 165));
		filmItems[1].getFilm().addActor(new Actor("Delon", "Alain"), 0);
		filmItems[1].getFilm().addActor(new Actor("Norton", "Edward"), 1);
		filmItems[1].getFilm().addActor(new Actor("Bale", "Christian"), 2);
		filmItems[2] = new FilmItem(counter++, new Film(ean++, "Nature", "Paramount", 175));
		filmItems[2].getFilm().addActor(new Actor("Waltz", "Christoph"), 0);
		filmItems[2].getFilm().addActor(new Actor("Portman", "Natalie"), 1);
		filmItems[2].getFilm().addActor(new Actor("Depp", "Johnny"), 2);
		for (int i = 0; i < 3; i++) {
			filmItems[i+3] = new FilmItem(counter++, filmItems[i].getFilm());
		}
		for (int i = 0; i < filmItems.length; i++) {
			if (filmItems[i] != null)
				objects[nr++] = filmItems[i].getFilm();
		}
		
		JournalItem[] journalItems = admin.getJournalItems();
		journalItems[0] = new JournalItem(counter++, new Journal(ean++, "Nature", "Springer", 108));
		journalItems[1] = new JournalItem(counter++, new Journal(ean++, "GEO", "Gruner", 82));
		journalItems[2] = new JournalItem(counter++, new Journal(ean++, "LNCS", "Springer", 98));
		journalItems[3] = new JournalItem(counter++, new Journal(ean++, "Film heute", "Tack", 88));
		journalItems[4] = new JournalItem(counter++, new Journal(ean++, "JSTOR", "Oldenburg", 78));
		journalItems[5] = new JournalItem(counter++, new Journal(ean++, "Elemente", "Springer", 54));
		for (int i = 0; i < 6; i++) {
			journalItems[i+6] = new JournalItem(counter++, journalItems[i].getJournal());
		}
		for (int i = 0; i < journalItems.length; i++) {
			if (journalItems[i] != null)
				objects[nr++] = journalItems[i].getJournal();
		}

		Customer leser = new Customer("Leser", "Bruno", "bruno@leser.com");
		Customer seher = new Customer("Seher", "Kurt", "kurt@seher.com");
		Customer hoerer = new Customer("Hoerer", "Emma", "emma@hoerer.com");

		admin.addLending(leser, bookItems[1], LocalDate.of(2018, 9, 4));
		admin.returnItem(bookItems[1], LocalDate.of(2018, 9, 15));
		
		admin.addLending(leser, bookItems[2], LocalDate.of(2018, 9, 4));
		admin.returnItem(bookItems[2],LocalDate.of(2018, 9, 16));
		
		admin.addLending(leser, bookItems[12], LocalDate.of(2018, 9, 5));
		admin.returnItem(bookItems[12],LocalDate.of(2018, 9, 18));
		
		admin.addLending(hoerer, musicItems[1], LocalDate.of(2018, 9, 6));
		admin.returnItem(musicItems[1],LocalDate.of(2018, 9, 17));
		
		admin.addLending(hoerer, musicItems[4], LocalDate.of(2018, 9, 7));
		admin.returnItem(musicItems[4],LocalDate.of(2018, 9, 12));
		
		admin.addLending(seher, filmItems[1], LocalDate.of(2018, 9, 8));
		admin.returnItem( filmItems[1], LocalDate.of(2018, 9, 18));
		
		admin.addLending(seher, filmItems[2], LocalDate.of(2018, 9, 10));
		admin.returnItem( filmItems[2],LocalDate.of(2018, 9, 19));
		
		admin.addLending(seher, filmItems[1], LocalDate.of(2018, 9, 20));
		admin.addLending(leser, bookItems[2], LocalDate.of(2018, 9, 22));
		
		admin.addLending(leser, bookItems[3], LocalDate.of(2018, 9, 20));
		admin.returnItem(bookItems[3],  LocalDate.of(2018, 9, 25));
		
		admin.addLending(leser, bookItems[12], LocalDate.of(2018, 9, 21));
		admin.addLending(hoerer, musicItems[7], LocalDate.of(2018, 9, 23));
		admin.addLending(hoerer, musicItems[8], LocalDate.of(2018, 9, 23));
		admin.addLending(seher, bookItems[10], LocalDate.of(2018, 9, 24));
		admin.addLending(seher, bookItems[9], LocalDate.of(2018, 9, 24));
		admin.addLending(seher, bookItems[1], LocalDate.of(2018, 10, 1));
		admin.addLending(hoerer, musicItems[5], LocalDate.of(2018, 10, 2));
		admin.addLending(hoerer, musicItems[6], LocalDate.of(2018, 10, 4));
		admin.addLending(leser, journalItems[5], LocalDate.of(2018, 10, 3));
		admin.addLending(leser, journalItems[3], LocalDate.of(2018, 10, 7));
		admin.addLending(leser, bookItems[2], LocalDate.of(2018, 10, 8));
		admin.addLending(leser, journalItems[5], LocalDate.of(2018, 10, 9));
		admin.addLending(leser, journalItems[7], LocalDate.of(2018, 10, 10));
		admin.addLending(leser, bookItems[7], LocalDate.of(2018, 10, 11));
		admin.addLending(leser, bookItems[8], LocalDate.of(2018, 10, 12));
		admin.addLending(hoerer, musicItems[4], LocalDate.of(2018, 10, 15));

		return admin;
	}
}
