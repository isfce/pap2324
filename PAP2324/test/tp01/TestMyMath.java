package tp01;

import static org.junit.Assert.assertEquals;
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
	
	@Test
	void testnbBitsV1() {
		assertEquals(0,MyMath.nbBitsV1(0));
		assertEquals(1,MyMath.nbBitsV1(1));
		assertEquals(32,MyMath.nbBitsV1(-1));
	}
	
	@Test
	void testnbBitsV2() {
		assertEquals(0,MyMath.nbBitsV2(0));
		assertEquals(1,MyMath.nbBitsV2(1));
		assertEquals(3,MyMath.nbBitsV2(0b000011010));
		assertEquals(32,MyMath.nbBitsV2(-1));
	}
	
	
}
