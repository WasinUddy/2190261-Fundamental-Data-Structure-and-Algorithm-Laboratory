
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class ArrayListStackTest {

	@Test
	public void testArrayListStack() {
		ArrayListStack x = new ArrayListStack();
		ArrayList<Integer> a = x.getA();
		assertTrue(a.isEmpty());
	}

	@Test
	public void testIsEmpty() throws Exception {
		ArrayListStack x = new ArrayListStack();
		assertTrue(x.isEmpty());

		x.push(1);
		x.push(2);
		x.push(3);

		assertFalse(x.isEmpty());
		x.pop();
		assertFalse(x.isEmpty());
		x.pop();
		assertFalse(x.isEmpty());
		x.pop();
		assertTrue(x.isEmpty());

	}

	@Test
	public void testIsFull() throws Exception {
		ArrayListStack x = new ArrayListStack();
		assertFalse(x.isFull());

		for (int i = 0; i < 100000; i++) {
			x.push(i);
		}
		assertTrue(x.isFull());
	}

	@Test
	public void testMakeEmpty() throws Exception {
		ArrayListStack x = new ArrayListStack();

		for (int i = 0; i < 100000; i++) {
			x.push(i);
		}
		assertFalse(x.isEmpty());

		x.makeEmpty();
		assertTrue(x.isEmpty());

	}

	@Test
	public void testPushAndTop() throws Exception {
		ArrayListStack x = new ArrayListStack();

		x.push(1);
		assertEquals(1, x.top());
		x.push(2);
		assertEquals(2, x.top());
		x.push(3);
		assertEquals(3, x.top());

	}

	@Test
	public void testPopAndTop() throws Exception {
		ArrayListStack x = new ArrayListStack();

		x.push(1);
		x.push(2);
		x.push(3);
		
		assertEquals(3,x.top());
		x.pop();
		assertEquals(2,x.top());
		x.pop();
		assertEquals(1,x.top());

		x.push(5);
		x.push(6);
		assertEquals(6,x.top());
		x.pop();
		assertEquals(5,x.top());
		x.pop();
		assertEquals(1,x.top());
		x.pop();
		assertTrue(x.isEmpty());
		
		
	}

}
