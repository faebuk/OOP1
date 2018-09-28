package ch.faebuk;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Ueb2Tests {

	String s1 = "";
	String s2 = "Hier ist ein unnötig langer unsinniger Text. ";
	String s3 = s2 + s2 + s2;
	char[] c = s3.toCharArray();
	String s4 = "Ist auf dem Bildschirm für ein Wort oder ein Name nicht"
			+ " genügend Platz, so wird der Text oft mit ... abgekürzt. "
			+ "Wir finden diese Punkte zum Beispiel im File Explorer. ";

	double[] list01 = {};
	double[] list11 = { 1.2 };
	double[] list31 = { 1.2, 2.3, 2.1 };
	double[] list32 = { 2.3, 2.1, 3.4 };
	double[] list41 = { 1.2, 2.3, 2.1, 3.4 };
	double[] list51 = { 1.2, 2.3, 2.1, 3.4, 1.1 };
	double[] list52 = { 1.1, 1.2, 2.3, 2.1, 3.4 };
	double[] list53 = { 1.2, 2.3, 1.1, 2.1, 3.4 };
	double[] list54 = { 3.4, 2.3, 1.1, 2.1, 1.2 };
	double[] list55 = { 1.1, 1.2, 2.1, 2.3, 3.4 };

	double[] vector0 = { 1.2, 1.3, 1.1 };
	double[] vector1 = { 1.2, 2.3, 2.1 };
	double[] vector2 = { 4.5, 1.0, 0.2 };
	double[] vector3 = { 1.2, 3.1, 1.3 };
	double[] vector4 = { 1.2, 2.3, 2.1, 0.2 };
	double[][] vectors = { vector0, vector1, vector2, vector3 };
	double eps = 0.00001;

	@Test
	public void testStringAppend() {
		assertEquals(s3, Main.append(s1, c));
	}

	@Test
	public void testStringBuilderAppend() {
		StringBuilder sbuilder = new StringBuilder(s1);
		assertEquals(s3, Main.append(sbuilder, c));
	}

	@Test
	public void caesarTest() {
		assertEquals(Main.caesarChiffre("Resultat",1), "Sftvmubu");
		assertEquals(Main.caesarChiffre("Wro", 3), "Zur");
	}

	@Test
	public void removeVocalsTest1() {
		assertEquals(Main.removeVocals("Aber dieser Text ist Unsinn!"), "br dsr Txt st nsnn!");
	}

	@Test
	public void removeVocalsTest2() {
		assertEquals(Main.removeVocals("Schiffahrtsgesellschaft"), "Schffhrtsgsllschft");
	}

	@Test
	public void equalTest1() {
		assertTrue(Main.isEqual(list41, list41));
	}

	@Test
	public void equalTest2() {
		assertFalse(Main.isEqual(list31, list32));
	}

	@Test
	public void getFirstTest() {
		assertTrue(Main.getFirst(list41) - 1.2 < eps);
	}

	@Test
	public void appendTest1() {
		assertTrue(Main.isEqual(Main.addLast(list31, 3.4), list41));
	}

	@Test
	public void appendTest2() {
		assertTrue(Main.isEqual(Main.addLast(list01, 1.2), list11));
	}

	@Test
	public void addFirstTest1() {
		double[] res = Main.addFirst(list41, 1.1);
		assertTrue(Main.isEqual(res, list52));
	}

	@Test
	public void addFirstTest2() {
		double[] res = Main.addFirst(list01, 1.2);
		assertTrue(Main.isEqual(res, list11));
	}

	@Test
	public void insertTest1() {
		double[] res = Main.insert(list41, 1.1, list41.length);
		assertTrue(Main.isEqual(list51, res));
	}

	@Test
	public void insertTest2() {
		double[] res = Main.insert(list41, 1.1, 0);
		assertTrue(Main.isEqual(list52, res));
	}

	@Test
	public void insertTest3() {
		double[] res = Main.insert(list41, 1.1, 2);
		assertTrue(Main.isEqual(list53, res));
	}

	@Test
	public void insertTest4() {
		double[] res = Main.insert(list01, 1.2, 0);
		assertTrue(Main.isEqual(list11, res));
	}

	@Test
	public void getLastTest() {
		assertTrue(Main.getLast(list41) - 3.4 < eps);
	}

	@Test
	public void removeLastTest1() {
		assertTrue(Main.isEqual(Main.removeLast(list41), list31));
	}

	@Test
	public void removeLastTest2() {
		assertTrue(Main.isEqual(Main.removeLast(list11), list01));
	}

	@Test
	public void removeFirstTest1() {
		assertTrue(Main.isEqual(Main.removeFirst(list41), list32));
	}

	@Test
	public void removeFirstTest2() {
		assertTrue(Main.isEqual(Main.removeFirst(list11), list01));
	}

	@Test
	public void removeTest1() {
		double[] res = Main.remove(list51, 4);
		assertTrue(Main.isEqual(list41, res));
	}

	@Test
	public void removeTest2() {
		double[] res = Main.remove(list52, 0);
		assertTrue(Main.isEqual(list41, res));
	}

	@Test
	public void removeTest3() {
		double[] res = Main.remove(list53, 2);
		assertTrue(Main.isEqual(list41, res));
	}

	@Test
	public void swapTest() {
		double[] res = Main.swap(list53, 0, 4);
		assertTrue(Main.isEqual(list54, res));
	}

	@Test
	public void bubbleSortTest() {
		double[] res = Main.bubbleSort(list54);
		assertTrue(Main.isEqual(list55, res));
		// Main.print(res);
	}

	@Test
	public void sumTest1() {
		double[] res = Main.addVectors(vector2, vector3);
		double[] sum = { 5.7, 4.1, 1.5 };
		assertTrue(vectorEqual(res, sum));
	}

	@Test
	public void vectorLengthTest1() {
		double res = Main.vectorLength(vector2);
		double l = vector2[0] * vector2[0] + vector2[1] * vector2[1] + vector2[2] * vector2[2];
		assertTrue(Math.abs(res - Math.sqrt(l)) < eps);
	}

	@Test
	public void vectorLengthTest2() {
		double res = Main.vectorLength(vector4);
		double l = vector4[0] * vector4[0] + vector4[1] * vector4[1] + vector4[2] * vector4[2]
				+ vector4[3] * vector4[3];
		assertTrue(Math.abs(res - Math.sqrt(l)) < eps);
	}

	@Test
	public void minVectorTest() {
		double[] res = Main.minVector(vectors);
		assertTrue(vectorEqual(res, vector0));
	}

	public static boolean vectorEqual(double[] vector1, double[] vector2) {
		if (vector1.length != vector2.length)
			return false;
		for (int i = 1; i < vector1.length; i++) {
			if (vector1[i] != vector2[i])
				return false;
		}
		return true;
	}

}
