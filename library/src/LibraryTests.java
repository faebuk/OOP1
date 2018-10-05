
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Library1Tests {
	private Administration admin;

	@BeforeEach
	private void setUp() {
		admin = new Administration();
		admin.testSetUp();
	}

	@Test
	void testBook() {
		assertNotNull(admin.getObjects()[0]);
	}
	
	@Test
	void testMusic() {
		assertNotNull(admin.getObjects()[7]);
	}
	
	@Test
	void testFilm() {
		assertNotNull(admin.getObjects()[9]);
	}
	
	@Test
	void testJournal() {
		assertNotNull(admin.getObjects()[11]);
	}
	
	@Test
	void testBook2() {
		assertTrue(admin.getObjects()[0] instanceof Book);
	}
	
	@Test
	void testMusic2() {
		assertTrue(admin.getObjects()[7] instanceof Music);
	}
	
	@Test
	void testFilm2() {
		assertTrue(admin.getObjects()[9] instanceof Film);
	}
	
	@Test
	void testJournal2() {
		assertTrue(admin.getObjects()[11] instanceof Journal);
	}
	
	@Test
	void test1() {
		assertNotNull(((Book)admin.getObjects()[0]).getTitle());
		assertNotEquals(((Book)admin.getObjects()[0]).getTitle(), "");
	}
	
	@Test
	void test2() {
		assertTrue(((Journal)admin.getObjects()[11]).getPages() > 100);
	}
	
	@Test
	void test3() {
		assertEquals(((Music)admin.getObjects()[7]).getBandName(), "Abba");
	}
	
	@Test
	void test4() {
		assertEquals(((Journal)admin.getObjects()[12]).getPublisher(), "Gruner");
	}
	
	@Test
	void test5() {
		assertEquals(admin.getLendings()[5].getBorrower().getLastName(), "Seher");
	}
	
	@Test
	void test6() {
		assertEquals(((Book)admin.getObjects()[1]).getWriter().getFirstName(), "Hans");
	}
	
	@Test
	void test7() {
		assertTrue(admin.getLendings()[3].getStartDate().isBefore(LocalDate.now()));
	}
	
	@Test
	void test8() {
		assertTrue(admin.getReservations()[0].getReservationDate().isBefore(LocalDate.now()));
	}
	

}
