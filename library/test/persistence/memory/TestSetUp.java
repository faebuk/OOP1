package persistence.memory;

import library.admin.Administration;
import library.admin.ItemNotAvailableException;
import library.admin.NoItemsFoundException;
import library.data.Book;
import library.data.BookItem;
import library.data.Customer;
import library.data.Film;
import library.data.FilmItem;
import library.data.Journal;
import library.data.JournalItem;
import library.data.Music;
import library.data.MusicItem;
import persistence.AbstractFactory;

public class TestSetUp {

	public static Administration testSetUp() throws NoItemsFoundException, ItemNotAvailableException {
		Administration admin = Administration.getInstance();
		AbstractFactory daoFactory = new MemoryDAOFactory();

		long counter = 1;
		int max = 15;
		Book[] books = daoFactory.createBookDAO().getBooks();
		BookItem[] bookItems = admin.getBookItems();
		for (int i = 0; i < max; i++) {
			bookItems[i] = new BookItem(counter++, books[i]);
			bookItems[i + max] = new BookItem(counter++, books[i]);
		}

		Music[] musics = daoFactory.createMusicDAO().getMusics();
		MusicItem[] musicItems = admin.getMusicItems();
		for (int i = 0; i < max; i++) {
			musicItems[i] = new MusicItem(counter++, musics[i]);
			musicItems[i + max] = new MusicItem(counter++, musics[i]);
		}

		Film[] films = daoFactory.createFilmDAO().getFilms();
		FilmItem[] filmItems = admin.getFilmItems();
		for (int i = 0; i < max; i++) {
			filmItems[i] = new FilmItem(counter++, films[i]);
			filmItems[i + max] = new FilmItem(counter++, films[i]);
		}

		Journal[] journals = daoFactory.createJournalDAO().getJournals();
		JournalItem[] journalItems = admin.getJournalItems();
		for (int i = 0; i < max; i++) {
			journalItems[i] = new JournalItem(counter++, journals[i]);
			journalItems[i + max] = new JournalItem(counter++, journals[i]);
		}

		Customer[] customers = daoFactory.createCustomerDAO().getCustomers();
		admin.setCustomers(customers);

		daoFactory.createLendingDAO().getLendings();
		return admin;
	}
}
