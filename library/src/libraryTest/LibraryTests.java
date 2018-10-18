package libraryTest;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import library.*;


class LibraryTests {
	private Administration admin;
	private Item[] objects;
	private Lending[] lendings;

	@BeforeEach
	private void setUp() {
		admin = TestSetUp.testSetUp();
		objects = admin.getObjects();
		lendings = admin.getLendings();
	}

	/*@Test
	void test01() {
		assertNotEquals(new Book(1, "", new Writer("", ""), 0), new Book(1, "", new Writer("", ""), 0));
	}*/

	@Test
	void test05() {
		Book obj = (Book) objects[0];
		assertTrue(admin.isBookAvailable(obj));
	}
	
	@Test
	void test06() {
		Book obj = (Book) objects[1];
		assertFalse(admin.isBookAvailable(obj));
	}

	@Test
	void test15() {
		Book obj = (Book) objects[0];
		assertEquals(admin.getLendingEndDate(obj), LocalDate.now());
	}

	@Test
	void test25() {
		Film obj = (Film)admin.findFilm(new Actor("Portman", "Natalie"));
		assertEquals(obj, objects[9]);
	}
	
	@Test
	void ex1Test() {
		assertEquals(admin.findJournal(17), objects[16]);
	}
	
	@Test
	void ex2Test() {
		assertEquals(admin.findBook("Behind the Moon"), objects[2]);
	}
	
	@Test
	void ex3Test() {
		assertEquals(admin.findMusic("Abba"), objects[7]);
	}
	
	@Test
	void ex4Test() {
		assertEquals(admin.findJournal("Nature"), objects[11]);
	}
	
	@Test
	void ex5Test() {
		assertEquals(admin.findFilm("Star Wars I"), objects[9]);
	}
	
	@Test
	void ex6Test() {
		assertEquals(admin.findBook(new Writer("Schreiberin", "Barbara")), objects[0]);
	}
	
	@Test
	void ex7Test() {
		assertEquals(admin.findFilm(new Actor("Portman", "Natalie")), objects[9]);
	}
	
	@Test
	void ex8Test() {
		assertFalse(admin.isBookAvailable((Book)objects[1]));
	}
	
	@Test
	void ex9Test() {
		assertFalse(admin.isBookAvailable((Book)objects[2]));
	}
	
	@Test
	void ex10Test() {
		assertTrue(admin.isBookAvailable((Book)objects[3]));
	}
	
	@Test
	void ex11Test() {
		assertFalse(admin.isMusicAvailable((Music)objects[7]));
	}
	
	@Test
	void ex12Test() {
		assertFalse(admin.isMusicAvailable((Music)objects[8]));
	}
	
	@Test
	void ex13Test() {
		assertFalse(admin.isFilmAvailable((Film)objects[9]));
	}
	
	@Test
	void ex14Test() {
		assertFalse(admin.isFilmAvailable((Film)objects[10]));
	}
	
	@Test
	void ex15Test() {
		assertFalse(admin.isJournalAvailable((Journal)objects[11]));
	}
	
	@Test
	void ex16Test() {
		assertFalse(admin.isJournalAvailable((Journal)objects[12]));
	}
	
	@Test
	void ex17Test() {
		assertEquals(LocalDate.now(), admin.getLendingEndDate((Book) objects[0]));
	}
	
	@Test
	void ex18Test() {
		assertEquals(LocalDate.of(2018, 11, 1), admin.getLendingEndDate((Book) objects[1]));
	}
	
	@Test
	void ex19Test() {
		assertEquals(LocalDate.of(2018, 10, 23), admin.getLendingEndDate((Music) objects[7]));
	}
	
	@Test
	void ex20Test() {
		assertEquals(LocalDate.of(2018, 10, 24), admin.getLendingEndDate((Film) objects[10]));
	}
	
	@Test
	void ex21Test() {
		assertNotEquals(new Film(1, "", "", 0), new Film(1, "", "", 0));
	}
	
	@Test
	void ex22Test() {
		assertNotEquals(new String("Sollte nicht gleich sein, falls das bei Immutable der Fall"),new String("Sollte nicht gleich sein, falls das bei Immutable der Fall"));
	}
}
