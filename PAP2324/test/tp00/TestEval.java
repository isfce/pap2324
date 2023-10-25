package tp00;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestEval {

	@Test
	void testCalculDecision() {
		assertEquals("Refus", Evaluation.calculDecision(0));
		assertEquals("Refus", Evaluation.calculDecision(29));
		assertEquals("Ajourné", Evaluation.calculDecision(30));
		assertEquals("Ajourné", Evaluation.calculDecision(49));
		assertEquals("Réussite", Evaluation.calculDecision(50));
		assertEquals("Réussite", Evaluation.calculDecision(100));
		assertThrows(AssertionError.class, () -> Evaluation.calculDecision(-2));
		assertThrows(AssertionError.class, () -> Evaluation.calculDecision(101));
	}

	@Test
	void testCalculSomme1() {
		assertEquals(1, Evaluation.calculSomme1(1));
		assertEquals(10, Evaluation.calculSomme1(4));
		assertEquals(5000050000L, Evaluation.calculSomme1(100000));
		assertThrows(AssertionError.class, () -> Evaluation.calculSomme1(0));
	}

	@Test
	void testCalculSomme2() {
		assertEquals(1, Evaluation.calculSomme2(1));
		assertEquals(10, Evaluation.calculSomme2(4));
		assertEquals(5000050000L, Evaluation.calculSomme2(100000));
		assertThrows(AssertionError.class, () -> Evaluation.calculSomme2(0));
	}

	@Test
	void testCalculSomme3() {
		assertEquals(1, Evaluation.calculSomme3(1));
		assertEquals(10, Evaluation.calculSomme3(4));
		assertEquals(5000050000L, Evaluation.calculSomme3(100000));
		assertThrows(AssertionError.class, () -> Evaluation.calculSomme3(0));
	}
}
