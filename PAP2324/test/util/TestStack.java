package util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestStack {

	@Test
	void testStack1() {
		IStack<Integer> s1= new StackArray<>(3);
		assertTrue(s1.empty());
		s1.push(1);
		s1.push(2);
		s1.push(3);
		assertFalse(s1.empty());
		assertEquals(3,s1.top());
		assertEquals(3,s1.pop());
		assertEquals(2,s1.top());
		assertEquals(2,s1.pop());
		assertEquals(1,s1.top());
		assertEquals(1,s1.pop());
		assertTrue(s1.empty());
	}
	
	@Test
	void testStack2() {
		IStack<Integer> s1= new StackListe<>();
		assertTrue(s1.empty());
		s1.push(1);
		s1.push(2);
		s1.push(3);
		assertFalse(s1.empty());
		assertEquals(3,s1.top());
		assertEquals(3,s1.pop());
		assertEquals(2,s1.top());
		assertEquals(2,s1.pop());
		assertEquals(1,s1.top());
		assertEquals(1,s1.pop());
		assertTrue(s1.empty());
	}

}
