
package persistence.memory;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import library.admin.Administration;
import library.admin.NoAvailableItemsException;
import library.admin.NoItemsFoundException;
import library.data.Actor;
import library.data.Book;
import library.data.BookItem;
import library.data.Customer;
import library.data.Film;
import library.data.FilmItem;
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void test01() throws Exception {
		long[] found = admin.findItems(new Writer("Schreiberin", "Anna"));
		for (long a : found)
			admin.addLending(customer, admin.findItem(a), LocalDate.now());
		Assertions.assertThrows(NoAvailableItemsException.class, () -> {
			admin.getAvailableItems((found));
		});
	}

	@Test
	void test02() throws Exception {
		long[] found = admin.findItems(new Writer("Autorin", "Maria"));
		for (long a : found)
			admin.addLending(customer, admin.findItem(a), LocalDate.now());
		Assertions.assertThrows(NoAvailableItemsException.class, () -> {
			admin.getAvailableItems((found));
		});
	}

	@Test
	void test03() throws NoItemsFoundException {
		Assertions.assertThrows(NoItemsFoundException.class, () -> {
			admin.findItems(Music.class, "Band21");
		});
	}

	@Test
	void test04() throws NoItemsFoundException {
		Assertions.assertThrows(NoItemsFoundException.class, () -> {
			admin.findItems(Book.class, "Title21");
		});
	}

	@Test
	void test05() throws NoItemsFoundException {
		Assertions.assertThrows(NoItemsFoundException.class, () -> {
			admin.findItems(Music.class, "");
		});
	}

	@Test
	void test06() throws NoItemsFoundException {
		Assertions.assertThrows(NoItemsFoundException.class, () -> {
			admin.findItems(Journal.class, "Titel");
		});
	}

	@Test
	void test07() throws NoItemsFoundException {
		Assertions.assertThrows(NoItemsFoundException.class, () -> {
			admin.findItems(Film.class, "Film");
		});
	}

	@Test
	void test08() throws Exception {
		Assertions.assertThrows(NoItemsFoundException.class, () -> {
			admin.findItems(Film.class, "Verlag17");
		});
	}

	@Test
	void test09() throws NoItemsFoundException {
		Assertions.assertThrows(NoItemsFoundException.class, () -> {
			admin.findItems(new Writer("Schreiberin", "Berta"));
		});
	}

	@Test
	void test10() throws NoItemsFoundException {
		Assertions.assertThrows(NoItemsFoundException.class, () -> {
			admin.findItems(new Actor("Spieler", "Hugo"));
		});
	}

	@Test
	void test11() throws NoItemsFoundException {
		long[] m = admin.findItems(Music.class, "Band1");
		assertEquals(m[0], musicItems[1].getId());
	}

	@Test
	void test12() throws NoItemsFoundException {
		long[] m = admin.findItems(Music.class, "Band3");
		assertEquals(m[0], musicItems[3].getId());
	}

	@Test
	void test13() throws NoItemsFoundException {
		long[] m = admin.findItems(Book.class, "Titel11");
		assertEquals(m[0], bookItems[11].getId());
	}

	@Test
	void test14() throws NoItemsFoundException {
		long[] o = admin.findItems(Journal.class, "Titel2");
		assertEquals(o[0], journalItems[2].getId());
	}

	@Test
	void test015() throws NoItemsFoundException {
		long[] o = admin.findItems(Film.class, "Titel5");
		assertEquals(o[0], filmItems[5].getId());
	}

	@Test
	void test16() throws Exception {
		long[] o = admin.findItems(Film.class, "Verlag7");
		assertEquals(2, admin.getAvailableItems(o).length);
	}
}
