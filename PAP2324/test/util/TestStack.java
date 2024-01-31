package util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestStack {

	@Test
	void testStackArray() {
		IStack<Integer> s1= new StackArray<>(5);
		assertTrue(s1.empty());
		s1.pushBottom(0);
		s1.push(1);
		s1.push(2);
		s1.push(3);
		s1.pushBottom(-1);
		assertFalse(s1.empty());
		assertEquals(3,s1.top());
		assertEquals(3,s1.pop());
		assertEquals(2,s1.top());
		assertEquals(2,s1.pop());
		assertEquals(1,s1.top());
		assertEquals(1,s1.pop());
		assertEquals(0,s1.top());
		assertEquals(0,s1.pop());
		assertEquals(-1,s1.top());
		assertEquals(-1,s1.pop());
		assertTrue(s1.empty());
		
	}
	
	@Test
	void testStackListe() {
		IStack<Integer> s1= new StackListe<>();
		assertTrue(s1.empty());
		s1.pushBottom(0);
		s1.push(1);
		s1.push(2);
		s1.push(3);
		s1.pushBottom(-1);
		assertFalse(s1.empty());
		assertEquals(3,s1.top());
		assertEquals(3,s1.pop());
		assertEquals(2,s1.top());
		assertEquals(2,s1.pop());
		assertEquals(1,s1.top());
		assertEquals(1,s1.pop());
		assertEquals(0,s1.top());
		assertEquals(0,s1.pop());
		assertEquals(-1,s1.top());
		assertEquals(-1,s1.pop());
		assertTrue(s1.empty());
	}

}
