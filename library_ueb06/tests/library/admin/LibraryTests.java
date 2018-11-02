
package library.admin;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import library.admin.Administration;
import library.data.Actor;
import library.data.BookItem;
import library.data.DataObject;
import library.data.FilmItem;
import library.data.JournalItem;
import library.data.MusicItem;
import library.data.Writer;

class LibraryTests {
	private Administration admin;
	private BookItem[] bookItems;
	private MusicItem[] musicItems;
	private FilmItem[] filmItems;
	private JournalItem[] journalItems;

	@BeforeEach
	private void setUp() {
		admin = TestSetUp.testSetUp();
		bookItems = admin.getBookItems();
		musicItems = admin.getMusicItems();
		filmItems = admin.getFilmItems();
		journalItems = admin.getJournalItems();
	}

	@Test
	void test01() {
		long[] found = admin.findBookItems(new Writer("Schreiber", "Peter"));
		Assertions.assertEquals(found[0], bookItems[2].getId());
	}

	@Test
	void test02() {
		long[] found = admin.findBookItems(new Writer("Schreiberin", "Anna"));
		Assertions.assertEquals(found[0], bookItems[4].getId());
	}

	@Test
	void test03() {
		long[] m = admin.findMusicItems("Abba");
		Assertions.assertEquals(m[0], musicItems[0].getId());
	}

	@Test
	void test04() {
		long[] m = admin.findMusicItems("Enja");
		Assertions.assertEquals(m[2], musicItems[8].getId());
	}

	@Test
	void test05() {
		long[] m = admin.findMusicItems("Pink Floyd");
		Assertions.assertEquals(m[1], musicItems[7].getId());
	}

	@Test
	void test06() {
		DataObject obj = admin.findDataObject("Nature");
		Assertions.assertEquals(obj, filmItems[2].getFilm());
	}
	
	@Test
	void test07() {
		Assertions.assertTrue(admin.isItemAvailable(bookItems[0]));
	}
	@Test
	void test08() {
		Assertions.assertTrue(admin.isItemAvailable(musicItems[0]));
	}
	@Test
	void test09() {
		Assertions.assertTrue(admin.isItemAvailable(filmItems[0]));
	}
	@Test
	void test10() {
		Assertions.assertTrue(admin.isItemAvailable(journalItems[0]));
	}
	@Test
	void test11() {
		Assertions.assertFalse(admin.isItemAvailable(bookItems[1]));
	}
	@Test
	void test12() {
		Assertions.assertFalse(admin.isItemAvailable(musicItems[4]));
	}
	@Test
	void test13() {
		Assertions.assertFalse(admin.isItemAvailable(filmItems[1]));
	}
	@Test
	void test14() {
		Assertions.assertFalse(admin.isItemAvailable(journalItems[7]));
	}
	@Test
	void test15() {
		DataObject obj = admin.findDataObject("LNCS");
		Assertions.assertEquals(obj, journalItems[2].getJournal());

	}

	@Test
	void test16() {
		assertEquals(admin.getLendingEndDate(musicItems[0]), LocalDate.now());
	}

	@Test
	void test17() {
		assertEquals(admin.getLendingEndDate(bookItems[0]), LocalDate.now());
	}

	@Test
	void test18() {
		assertEquals(admin.getLendingEndDate(filmItems[4]), LocalDate.now());
	}

	@Test
	void test19() {
		assertEquals(admin.getLendingEndDate(musicItems[10]), LocalDate.now());
	}

	@Test
	void test20() {
		long[] found = admin.findBookItems(new Writer("Schreiberin", "Barbara"));
		assertEquals(found[0], bookItems[0].getId());
		assertEquals(found[1], bookItems[7].getId());
	}

	@Test
	void test22() {
		long[] found = admin.findMusicItems("Abba");
		assertEquals(found[0], musicItems[0].getId());
		assertEquals(found[1], musicItems[6].getId());
	}

	@Test
	void test23() {
		long[] found = admin.findItems("LNCS");
		assertEquals(found[0], journalItems[2].getId());
		assertEquals(found[1], journalItems[8].getId());
	}

	@Test
	void test25() {
		long[] found = admin.findFilmItems(new Actor("Portman", "Natalie"));
		assertEquals(found[0], filmItems[2].getId());
		assertEquals(found[1], filmItems[5].getId());
	}
}
