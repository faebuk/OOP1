import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PersonTest {
	Person p1;
	Person p2;

	@Before
	public void setUp() throws Exception {
		p1 = new Person("Fabian", "K�ng", 1996, 12, 14);
		p2 = new Person("Marco", "K�ng", 1994, 11, 14);
	}

	@Test
	public void testPerson() {
		assertNotNull(p1);
	}
	
	@Test
	public void testPerson2() {
		assertEquals(p1, new Person("Fabian", "K�ng", 1996, 12, 14));
	}

	@Test
	public void testGetName() {
		assertEquals(p1.getName(), "Fabian K�ng");
	}

	@Test
	public void testGetFirstName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetLastName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDateOfBirth() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetEmail() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetEmail() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

	@Test
	public void testEqualsObject() {
		fail("Not yet implemented");
	}

}
