package tpvect;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;

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
		assertThrows(AssertionError.class,()-> MyVect.maxElemV(v0));
	}
	
	@Test
	void testMinMaxElem() {
		int[] v0 = {};
		int[] v1 = { 1, 2, 3 }; int[] resV1={1,3};
		int[] v2 = { 1, 8, 7,-1 };int[] resV2={-1,8};
		
		assertArrayEquals(resV1, MyVect.minMaxElemV(v1));
		assertArrayEquals(resV2, MyVect.minMaxElemV(v2));
		assertThrows(AssertionError.class,()-> MyVect.minMaxElemV(v0));
	}
	
	@Test
	void testavgV() {
		int[] v0 = {};
		int[] v1 = { 2, 3 };
		int[] v2 = {1,0,1};
		assertEquals(2.5, MyVect.avgElemV(v1),0.000001);//précision
		assertEquals(2.0/3.0, MyVect.avgElemV(v2),0.000001);//précision
		assertThrows(AssertionError.class,()-> MyVect.avgElemV(v0));
	}
	
	@Test
	void testCloneV() {
		int[] v0 = {};
		int[] v1 = { 1, 2, 3 }; 
		int[] resV1=MyVect.cloneV(v1);
		int[] resV0=MyVect.cloneV(v0);
		assertArrayEquals(v1,resV1);
		assertFalse(v1==resV1);
		assertArrayEquals(v0,resV0);
		assertFalse(v0==resV0);
	}
	
	
	
	
}
