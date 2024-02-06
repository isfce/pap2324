package tpvect;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class TestMyVect {

	@Test
	void testSommeV() {
		int[] v0 = {};
		int[] v1 = { 1, 2, 3 };
		assertEquals(0, MyVect.sommeV(v0));
		assertEquals(6, MyVect.sommeV(v1));
	}

	@Test
	void testMaxElem() {
		int[] v0 = {};
		int[] v1 = { 1, 2, 3 };
		int[] v2 = { -1, -2, -3 };
		assertEquals(-1, MyVect.maxElemV(v2));
		assertEquals(3, MyVect.maxElemV(v1));
		assertThrows(AssertionError.class, () -> MyVect.maxElemV(v0));
	}

	@Test
	void testMinMaxElem() {
		int[] v0 = {};
		int[] v1 = { 1, 2, 3 };
		int[] resV1 = { 1, 3 };
		int[] v2 = { 1, 8, 7, -1 };
		int[] resV2 = { -1, 8 };

		assertArrayEquals(resV1, MyVect.minMaxElemV(v1));
		assertArrayEquals(resV2, MyVect.minMaxElemV(v2));
		assertThrows(AssertionError.class, () -> MyVect.minMaxElemV(v0));
	}

	@Test
	void testavgV() {
		int[] v0 = {};
		int[] v1 = { 2, 3 };
		int[] v2 = { 1, 0, 1 };
		assertEquals(2.5, MyVect.avgElemV(v1), 0.000001);// précision
		assertEquals(2.0 / 3.0, MyVect.avgElemV(v2), 0.000001);// précision
		assertThrows(AssertionError.class, () -> MyVect.avgElemV(v0));
	}

	@Test
	void testCloneV() {
		int[] v0 = {};
		int[] v1 = { 1, 2, 3 };
		int[] resV1 = MyVect.cloneV(v1);
		int[] resV0 = MyVect.cloneV(v0);
		assertArrayEquals(v1, resV1);
		assertFalse(v1 == resV1);
		assertArrayEquals(v0, resV0);
		assertFalse(v0 == resV0);
	}

	@Test
	void testEstTriev1() {
		int[] v0 = {};
		int[] v1 = { 9 };
		int[] v2 = { 1, 2, 2, 3 };
		int[] v3 = { 1, 2, 3, 1 };
		assertTrue(MyVect.estTrieV1(v1));
		assertTrue(MyVect.estTrieV1(v2));
		assertFalse(MyVect.estTrieV1(v3));
		assertThrows(AssertionError.class, () -> MyVect.estTrieV1(v0));
	}

	@Test
	void testEstTriev2() {
		int[] v0 = {};
		int[] v1 = { 9 };
		int[] v2 = { 1, 2, 2, 3 };
		int[] v3 = { 1, 2, 3, 1 };
		assertTrue(MyVect.estTrieV2(v1));
		assertTrue(MyVect.estTrieV2(v2));
		assertFalse(MyVect.estTrieV2(v3));
		assertThrows(AssertionError.class, () -> MyVect.estTrieV2(v0));
	}

	@Test
	void testExisteMot() {
		char[] texte = { 'L', 'T', 'T', 'T', 'E', 'E', 'L' };
		char[] mot0 = {};// assert
		char[] mot1 = { 'E', 'L', 'L' };// non
		char[] mot2 = { 'L', 'T', 'T' };// oui
		char[] mot3 = { 'T', 'T', 'E' };// oui
		char[] mot4 = { 'Z' };// non
		assertFalse(MyVect.existeMot(texte, mot1));
		assertFalse(MyVect.existeMot(texte, mot4));
		assertTrue(MyVect.existeMot(texte, mot2));
		assertTrue(MyVect.existeMot(texte, mot3));
		assertTrue(MyVect.existeMot(texte, texte));
		assertThrows(AssertionError.class, () -> MyVect.existeMot(texte, mot0));
	}

	@Test
	void testTriInsertion() {
		int[] v1 = { 5, 4, 3, 2, 1 };
		int[] v2 = { 4, 2, 3, 5, 1 };
		int[] v1t = { 1, 2, 3, 4, 5 };
		MyVect.triInsertion(v1);
		assertArrayEquals(v1t, v1);

		MyVect.triInsertion(v2);
		assertArrayEquals(v1t, v2);

		MyVect.triInsertion(v1t);
		assertTrue(MyVect.estTrieV1(v1t));

	}

	@Test
	void testTriBulles() {
		int[] v1 = { 5, 4, 3, 2, 1 };
		int[] v1t = { 1, 2, 3, 4, 5 };
		int[] v2 = { 1, 3, 0, 2, 5 };
		int[] v2t = { 0, 1, 2, 3, 5 };
		MyVect.triBulles(v1);
		assertArrayEquals(v1t, v1);

		MyVect.triBulles(v2);
		assertArrayEquals(v2t, v2);
		// MyVect.triBulles(v1t);
		// assertTrue(MyVect.estTrieV1(v1t));
	}

	@Test
	void testPivot() {
		int[] v1 = { 5, 4, 1, 2, 3 };
		int p = MyVect.posPivot(v1, 0, 4);
		assertEquals(2, p);
		assertTrue(estPlusPetit(v1, p));
		assertTrue(estPlusGrandEgal(v1, p));

		int[] v2 = { 2, 4 };
		p = MyVect.posPivot(v2, 0, 1);
		assertEquals(1, p);
		assertTrue(estPlusPetit(v2, p));
		assertTrue(estPlusGrandEgal(v2, p));

		int[] v3 = { 4, 2 };
		p = MyVect.posPivot(v3, 0, 1);
		assertEquals(0, p);
		assertTrue(estPlusPetit(v3, p));
		assertTrue(estPlusGrandEgal(v3, p));

	}

	// test Pivot1
	public static boolean estPlusPetit(int[] v, int p) {
		boolean ok = true;
		int i = p - 1;
		while (ok && i >= 0) {
			ok = v[i] < v[p];
			i--;
		}
		return ok;
	}

	// test Pivot2
	public static boolean estPlusGrandEgal(int[] v, int p) {
		boolean ok = true;
		int i = p + 1;
		while (ok && i < v.length) {
			ok = v[i] >= v[p];
			i++;
		}
		return ok;
	}
}
