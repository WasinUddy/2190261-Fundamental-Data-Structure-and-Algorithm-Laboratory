import static org.junit.Assert.*;

import org.junit.Test;

public class UseStackTest {

	@Test
	public void testSort() throws Exception {
		// first, try to sort an empty stack
		ArrayListStack s = new ArrayListStack();
		Stack result = UseStack.sort(s);
		assertTrue(result.isEmpty());

		// then try to sort a generic stack
		s.push(2);
		s.push(8);
		s.push(6);
		s.push(7);
		s.push(3);
		s.push(1);
		result = UseStack.sort(s);
		assertEquals(1, result.top());
		result.pop();
		assertEquals(2, result.top());
		result.pop();
		assertEquals(3, result.top());
		result.pop();
		assertEquals(6, result.top());
		result.pop();
		assertEquals(7, result.top());
		result.pop();
		assertEquals(8, result.top());

		// then try to sort another generic stack, with duplicated numbers
		s.makeEmpty();
		s.push(3);
		s.push(7);
		s.push(1);
		s.push(5);
		s.push(2);
		s.push(4);
		s.push(1);
		s.push(5);
		
		result = UseStack.sort(s);
		assertEquals(1, result.top());
		result.pop();
		assertEquals(1, result.top());
		result.pop();
		assertEquals(2, result.top());
		result.pop();
		assertEquals(3, result.top());
		result.pop();
		assertEquals(4, result.top());
		result.pop();
		assertEquals(5, result.top());
		result.pop();
		assertEquals(5, result.top());
		result.pop();
		assertEquals(7, result.top());

	}

}
