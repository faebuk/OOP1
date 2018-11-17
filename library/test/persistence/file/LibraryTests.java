
package persistence.file;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import library.admin.Administration;
import library.admin.ItemNotAvailableException;
import library.admin.NoAvailableItemsException;
import library.admin.NoItemsFoundException;
import library.data.Actor;
import library.data.Book;
import library.data.BookItem;
import library.data.Customer;
import library.data.Film;
import library.data.FilmItem;
import library.data.Item;
import library.data.Journal;
import library.data.JournalItem;
import library.data.Music;
import library.data.MusicItem;
import library.data.Writer;

class LibraryTests {
	private static Administration admin;
	private static BookItem[] bookItems;
	private static MusicItem[] musicItems;
	private static FilmItem[] filmItems;
	private static JournalItem[] journalItems;
	private static Customer customer;

	@BeforeAll
	private static void setUp() {
		try {
			admin = TestSetUp.testSetUp();
			bookItems = admin.getBookItems();
			musicItems = admin.getMusicItems();
			filmItems = admin.getFilmItems();
			journalItems = admin.getJournalItems();
			customer = admin.getCustomers()[0];

		} catch (NoItemsFoundException | ItemNotAvailableException e) {
			e.printStackTrace();
		}
	}

	@Test
	void test01() {
		Assertions.assertThrows(NoItemsFoundException.class, () -> {
			admin.findItems(new Writer("Schreiber", "Hansli"));
		});
	}

	@Test
	void test02() {
		long[] found;
		try {
			found = admin.findItems(new Writer("Schreiberin", "Anna"));
			assertEquals(found[0], bookItems[4].getId());
		} catch (NoItemsFoundException e) {
			e.printStackTrace();
		}

	}

	@Test
	void test03() {
		Assertions.assertThrows(NoItemsFoundException.class, () -> {
			admin.findItems(Music.class, "Aba");
		});
	}

	@Test
	void test04() {
		try {
			long[] m = admin.findItems(Music.class, "Enja");
			assertEquals(m[0], musicItems[2].getId());
		} catch (NoItemsFoundException e) {
			e.printStackTrace();
		}
	}

	@Test
	void test05() {
		Assertions.assertThrows(NoItemsFoundException.class, () -> {
			admin.findItems(Journal.class, "Spinger");
		});
	}

	@Test
	void test06() {
		try {
			long[] o = admin.findItems(Journal.class, "Springer");
			assertEquals(o[1], journalItems[2].getId());
		} catch (NoItemsFoundException e) {
			e.printStackTrace();
		}

	}

	@Test
	void test07() {
		Assertions.assertThrows(NoItemsFoundException.class, () -> {
			admin.findItems(Film.class, "Lucas");
		});
	}

	@Test
	void test08() {
		try {
			long[] o = admin.findItems(Film.class, "Lucas Film");
			assertEquals(3, admin.getAvailableItems(o).length);
		} catch (NoItemsFoundException | NoAvailableItemsException e) {
			e.printStackTrace();
		}
	}

	@Test
	void test09() throws Exception {
		long[] o = admin.findItems(Journal.class, "Springer");
		assertEquals(8, admin.getAvailableItems(o).length);
	}

	@Test
	void test10() throws Exception {
		admin.addLending(customer, admin.getFilmItems()[0], LocalDate.now());
		admin.addLending(customer, admin.getFilmItems()[15], LocalDate.now());
		Assertions.assertThrows(NoAvailableItemsException.class, () -> {
			admin.getAvailableItems(admin.findItems("Star Wars I"));
		});
	}

	@Test
	void test12() throws Exception {
		long[] found = admin.findItems(Book.class, "Tombland");
		for (long a : found)
			admin.addLending(customer, admin.findItem(a), LocalDate.now());
		Assertions.assertThrows(NoAvailableItemsException.class, () -> {
			admin.getAvailableItems((found));
		});
	}

	@Test
	void test13() throws Exception {
		long[] found = admin.findItems(new Writer("Schreiberin", "Barbara"));
		Assertions.assertThrows(ItemNotAvailableException.class, () -> {
			for (long a : found)
				admin.addLending(customer, admin.findItem(a), LocalDate.now());
		});
	}

	@Test
	void test14() throws Exception {
		long[] found = admin.findItems("Abba");
		for (long a : found)
			admin.addLending(customer, admin.findItem(a), LocalDate.now());
		Assertions.assertThrows(NoAvailableItemsException.class, () -> {
			admin.getAvailableItems((found));
		});
	}

	@Test
	void test15() throws Exception {
		long[] found = admin.findItems("LNCS");
		for (long a : found)
			admin.addLending(customer, admin.findItem(a), LocalDate.now());
		Assertions.assertThrows(NoAvailableItemsException.class, () -> {
			admin.getAvailableItems((found));
		});
	}

	@Test
	void test16() throws Exception {
		long[] found = admin.findItems(new Actor("Portman", "Natalie"));
		for (long a : found)
			admin.addLending(customer, admin.findItem(a), LocalDate.now());
		Assertions.assertThrows(NoAvailableItemsException.class, () -> {
			admin.getAvailableItems((found));
		});
	}

	@Test
	void test17() {
		try {
			long[] m = admin.findItems(Film.class, "Paramount");
			assertEquals(m[0], filmItems[2].getId());
		} catch (NoItemsFoundException e) {
			e.printStackTrace();
		}
	}

	@Test
	void test18() throws Exception {
		long[] found = admin.findItems(new Writer("Schreiberin", "Barbara"));
		for (long a : found) {
			Item item = admin.findItem(a);
			if (item.isAvailable())
				admin.addLending(customer, item, LocalDate.now());
		}
		Assertions.assertThrows(NoAvailableItemsException.class, () -> {
			admin.getAvailableItems((found));
		});
	}

}
