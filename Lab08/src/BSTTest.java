import static org.junit.Assert.*;

import java.awt.BasicStroke;

import org.junit.Test;

//import static org.junit.jupiter.api.Assertions.*;

//import org.junit.jupiter.api.Test;

public class BSTTest {

	@Test
	public void testFindNextMax() throws Exception {
		BST t0 = new BST();
		assertEquals(20,t0.findNextData(20));
		
		BSTNode r = new BSTNode(7);
		BST t = new BST(r, 1);
		t.insert(3);
		t.insert(11);
		t.insert(2);
		t.insert(5);
		t.insert(8);
		assertEquals(2,t.findNextData(1));
		assertEquals(3,t.findNextData(2));
		assertEquals(5,t.findNextData(3));
		assertEquals(5,t.findNextData(4));
		assertEquals(7,t.findNextData(5));
		assertEquals(7,t.findNextData(6));
		assertEquals(8,t.findNextData(7));
		assertEquals(11,t.findNextData(8));
		assertEquals(11,t.findNextData(9));
		assertEquals(11,t.findNextData(10));
		assertEquals(11,t.findNextData(11));
		assertEquals(12,t.findNextData(12));
		assertEquals(13,t.findNextData(13));


	}
	
	@Test
	public void testFindMax() throws Exception {	
		BSTNode r = new BSTNode(7);
		BST t = new BST(r, 1);
		assertEquals(7,t.findMax(t.root).currentNode.data);
		t.insert(3);
		assertEquals(7,t.findMax(t.root).currentNode.data);
		t.insert(11);
		assertEquals(11,t.findMax(t.root).currentNode.data);
		t.insert(2);
		assertEquals(11,t.findMax(t.root).currentNode.data);
		t.insert(15);
		assertEquals(15,t.findMax(t.root).currentNode.data);
		t.insert(8);
		assertEquals(15,t.findMax(t.root).currentNode.data);

	}

}
