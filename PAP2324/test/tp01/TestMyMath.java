package tp01;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TestMyMath {
	@Test
	void testEstPair() {
		assertTrue(MyMath.estPair(8));
		assertFalse(MyMath.estPair(3));
		assertTrue(MyMath.estPair(0));
		assertThrows(AssertionError.class, () -> MyMath.estPair(-2));
	}

}
