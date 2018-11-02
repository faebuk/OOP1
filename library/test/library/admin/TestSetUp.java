package library.admin;

import java.time.LocalDate;

import library.data.Book;
import library.data.BookItem;
import library.data.Customer;
import library.data.Film;
import library.data.FilmItem;
import library.data.Journal;
import library.data.JournalItem;
import library.data.Music;
import library.data.MusicItem;
import persistence.DAOFactory;

public class TestSetUp {

	public static Administration testSetUp() {
		Administration admin = Administration.getInstance();
		DAOFactory daoFactory = new DAOFactory();
        
		long counter = 1;
		int max = 15;
		Book[] books = daoFactory.createBookDAO().getBooks();
		BookItem[] bookItems = admin.getBookItems();
		for (int i = 0; i < max; i++) {
			bookItems[i] = new BookItem(counter++, books[i]);
			bookItems[i+max] = new BookItem(counter++, books[i]);
		}
		
		Music[] musics = daoFactory.createMusicDAO().getMusics();
		MusicItem[] musicItems = admin.getMusicItems();
		for (int i = 0; i < max; i++) {
			musicItems[i] = new MusicItem(counter++, musics[i]);
			musicItems[i+max] = new MusicItem(counter++, musics[i]);
		}
		
		Film[] films = daoFactory.createFilmDAO().getFilms();
		FilmItem[] filmItems = admin.getFilmItems();
		for (int i = 0; i < max; i++) {
			filmItems[i] = new FilmItem(counter++, films[i]);
			filmItems[i+max] = new FilmItem(counter++, films[i]);
		}

		Journal[] journals = daoFactory.createJournalDAO().getJournals();
		JournalItem[] journalItems = admin.getJournalItems();
		for (int i = 0; i < max; i++) {
			journalItems[i] = new JournalItem(counter++, journals[i]);
			journalItems[i+max] = new JournalItem(counter++, journals[i]);
		}

		Customer[] customers = daoFactory.createCustomerDAO().getCustomers();
		admin.addLending(customers[0], bookItems[1], LocalDate.of(2018, 9, 4));
		admin.returnItem(bookItems[1], LocalDate.of(2018, 9, 15));
		admin.addLending(customers[1], bookItems[2], LocalDate.of(2018, 9, 4));
		admin.returnItem(bookItems[2], LocalDate.of(2018, 9, 16));
		admin.addLending(customers[2], bookItems[12], LocalDate.of(2018, 9, 5));
		admin.returnItem(bookItems[12], LocalDate.of(2018, 9, 18));
		admin.addLending(customers[3], musicItems[1], LocalDate.of(2018, 9, 6));
		admin.returnItem(musicItems[1], LocalDate.of(2018, 9, 17));
		admin.addLending(customers[4], musicItems[4], LocalDate.of(2018, 9, 7));
		admin.returnItem(musicItems[4], LocalDate.of(2018, 9, 12));
		admin.addLending(customers[5], filmItems[1], LocalDate.of(2018, 9, 8));
		admin.returnItem(filmItems[1], LocalDate.of(2018, 9, 18));
		admin.addLending(customers[6], filmItems[2], LocalDate.of(2018, 9, 10));
		admin.returnItem(filmItems[2], LocalDate.of(2018, 9, 19));
		admin.addLending(customers[7], filmItems[1], LocalDate.of(2018, 9, 20));
		admin.addLending(customers[8], bookItems[2], LocalDate.of(2018, 9, 22));
		admin.addLending(customers[9], bookItems[3], LocalDate.of(2018, 9, 20));
		admin.returnItem(bookItems[3], LocalDate.of(2018, 9, 25));
		admin.addLending(customers[10], bookItems[12], LocalDate.of(2018, 9, 21));
		admin.addLending(customers[11], musicItems[7], LocalDate.of(2018, 9, 23));
		admin.addLending(customers[12], musicItems[8], LocalDate.of(2018, 9, 23));
		admin.addLending(customers[13], bookItems[10], LocalDate.of(2018, 9, 24));
		admin.addLending(customers[14], bookItems[9], LocalDate.of(2018, 9, 24));
		admin.addLending(customers[0], bookItems[1], LocalDate.of(2018, 10, 1));
		admin.addLending(customers[1], musicItems[5], LocalDate.of(2018, 10, 2));
		admin.addLending(customers[2], musicItems[6], LocalDate.of(2018, 10, 4));
		admin.addLending(customers[3], journalItems[5], LocalDate.of(2018, 10, 3));
		admin.addLending(customers[4], journalItems[3], LocalDate.of(2018, 10, 7));
		admin.addLending(customers[5], bookItems[2], LocalDate.of(2018, 10, 8));
		admin.addLending(customers[6], journalItems[5], LocalDate.of(2018, 10, 9));
		admin.addLending(customers[7], journalItems[7], LocalDate.of(2018, 10, 10));
		admin.addLending(customers[8], bookItems[7], LocalDate.of(2018, 10, 11));
		admin.addLending(customers[9], bookItems[8], LocalDate.of(2018, 10, 12));
		admin.addLending(customers[10], musicItems[4], LocalDate.of(2018, 10, 15));

		return admin;
	}
}
