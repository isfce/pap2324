package tpvect;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class TestMyVect {
	@Test
	void testSommeV() {
		int[] v0 = {};
		int[] v1 = { 1, 2, 3 };
		assertEquals(0, MyVect.sommeV(v0));
		assertEquals(6, MyVect.sommeV(v1));
	}

}
