
package library.admin;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import library.data.Actor;
import library.data.BookItem;
import library.data.Film;
import library.data.FilmItem;
import library.data.Journal;
import library.data.JournalItem;
import library.data.Music;
import library.data.MusicItem;
import library.data.Writer;
import persistence.DAOFactory;
import persistence.FilmDAO;

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
		long[] found = admin.findItems(new Writer("Schreiber", "Peter"));
		Assertions.assertEquals(found[0], bookItems[2].getId());
	}

	@Test
	void test02() {
		long[] found = admin.findItems(new Writer("Schreiberin", "Anna"));
		Assertions.assertEquals(found[0], bookItems[4].getId());
	}

	@Test
	void test03() {
		long[] m = admin.findItems(Music.class, "Abba");
		Assertions.assertEquals(m[0], musicItems[0].getId());
	}

	@Test
	void test04() {
		long[] m = admin.findItems(Music.class,"Enja");
		Assertions.assertEquals(m[0], musicItems[2].getId());
	}

	@Test
	void test05() {
		long[] m = admin.findItems(Music.class,"Pink Floyd");
		Assertions.assertEquals(m[1], musicItems[16].getId());
	}

	@Test
	void test06() {
		long[] o = admin.findItems(Journal.class,"Springer");
		Assertions.assertEquals(o[1], journalItems[2].getId());
	}
	
	@Test
	void test07() {
		long[] o = admin.findItems(Film.class,"Lucas Film");
		Assertions.assertEquals(o[1], filmItems[1].getId());
	}
	
	@Test
	void test08() {
		long[] o = admin.findItems(Film.class,"Lucas Film");
		Assertions.assertEquals(3, admin.getAvailableItems(o).length);
	}
	
	@Test
	void test09() {
		long[] o = admin.findItems(Journal.class,"Springer");
		Assertions.assertEquals(8, admin.getAvailableItems(o).length);
	}
	@Test
	void test10() {
		long[] o = admin.findItems(Film.class,"Star Wars I");
		Assertions.assertArrayEquals(o, admin.getAvailableItems(o));
	}
	@Test
	void test11() {
		long[] o = admin.findItems(new Actor("Bale", "Christian"));
		Assertions.assertEquals(9, admin.getAvailableItems(o).length);
	}
	
	@Test
	void test12() {
		long[] o = admin.findItems(new Writer("Schreiber", "Hans"));
		Assertions.assertEquals(5, admin.getAvailableItems(o).length);
	}

	@Test
	void test13() {
		long[] o = admin.findItems(Journal.class,"Nature");
		Assertions.assertArrayEquals(o, admin.getAvailableItems(o));
	}
	
	@Test
	void test14() {
		long[] o = admin.findItems(Journal.class,"JSTOR");
		Assertions.assertArrayEquals(o, admin.getAvailableItems(o));
	}
	
	@Test
	void test15() {
		assertEquals(admin.getTimeLimit(musicItems[4]), LocalDate.of(2018,11,15));
	}
	
	void test16() {
		assertEquals(admin.getTimeLimit(bookItems[8]), LocalDate.of(2018,11,12));
	}
	
	@Test
	void test17() {
		assertEquals(admin.getLendingEndDate(musicItems[0]), LocalDate.now());
	}

	@Test
	void test18() {
		assertEquals(admin.getLendingEndDate(bookItems[0]), LocalDate.now());
	}

	@Test
	void test19() {
		assertEquals(admin.getLendingEndDate(filmItems[4]), LocalDate.now());
	}

	@Test
	void test20() {
		assertEquals(admin.getLendingEndDate(musicItems[10]), LocalDate.now());
	}

	@Test
	void test21() {
		long[] found = admin.findItems(new Writer("Schreiberin", "Barbara"));
		assertEquals(found[0], bookItems[0].getId());
		assertEquals(found[1], bookItems[5].getId());
	}

	@Test
	void test22() {
		long[] found = admin.findItems("Abba");
		assertEquals(found[0], musicItems[0].getId());
		assertEquals(found[1], musicItems[15].getId());
	}

	@Test
	void test23() {
		long[] found = admin.findItems("LNCS");
		assertEquals(found[0], journalItems[2].getId());
		assertEquals(found[1], journalItems[17].getId());
	}

	@Test
	void test25() {
		long[] found = admin.findItems(new Actor("Portman", "Natalie"));
		assertEquals(found[0], filmItems[4].getId());
		assertEquals(found[1], filmItems[5].getId());
	}
}
