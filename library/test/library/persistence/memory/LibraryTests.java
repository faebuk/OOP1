
package library.persistence.memory;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import library.admin.Administration;
import library.data.Actor;
import library.data.BookItem;
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

	@BeforeAll
	private static void setUp() {
		admin = TestSetUp.testSetUp();
		bookItems = admin.getBookItems();
		musicItems = admin.getMusicItems();
		filmItems = admin.getFilmItems();
		journalItems = admin.getJournalItems();
	}

	@Test
	void test01() {
		long[] found = admin.findItems(new Writer("Schreiberin", "Anna"));
		assertEquals(found[0], bookItems[4].getId());
	}

	@Test
	void test02() {
		long[] found = admin.findItems(new Writer("Autorin", "Maria"));
		assertEquals(found[0], bookItems[9].getId());
	}

	@Test
	void test03() {
		long[] m = admin.findItems(Music.class, "Band1");
		assertEquals(m[0], musicItems[1].getId());
	}

	@Test
	void test04() {
		long[] m = admin.findItems(Music.class, "Band3");
		assertEquals(m[0], musicItems[3].getId());
	}

	@Test
	void test05() {
		long[] m = admin.findItems(Music.class, "Titel11");
		assertEquals(m[0], musicItems[11].getId());
	}

	@Test
	void test06() {
		long[] o = admin.findItems(Journal.class, "Titel2");
		assertEquals(o[0], journalItems[2].getId());
	}

	@Test
	void test07() {
		long[] o = admin.findItems(Film.class, "Titel5");
		assertEquals(o[0], filmItems[5].getId());
	}

	@Test
	void test08() {
		long[] o = admin.findItems(Film.class, "Verlag7");
		assertEquals(2, admin.getAvailableItems(o).length);
	}
}
