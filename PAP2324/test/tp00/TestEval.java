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
		assertThrows(AssertionError.class,()->Evaluation.calculDecision(-2));
		assertThrows(AssertionError.class,()->Evaluation.calculDecision(101));
	}
	
	@Test
	void testCalculSomme() {
		assertEquals(1, Evaluation.calculSomme1(1));
		assertEquals(10, Evaluation.calculSomme1(4));
		assertThrows(AssertionError.class,()->Evaluation.calculSomme1(0));
	}
	
}
