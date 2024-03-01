
import static org.junit.Assert.*;

import org.junit.Test;

public class TestBSTRecursive {

	@Test
	public void testNumNodesLessThan() {
		BSTNode r = new BSTNode(7);
		BSTRecursive t = new BSTRecursive(r, 1);
		t.insert(3);
		t.insert(1);
		t.insert(11);
		t.insert(2);
		t.insert(5);
		t.insert(9);
		t.insert(6);
		assertEquals(3,t.numNodesLessThan(r, 5));
		assertEquals(7,t.numNodesLessThan(r, 10));
		assertEquals(0,t.numNodesLessThan(r.right, 5));
		assertEquals(0,t.numNodesLessThan(r.right.left, 5));
		assertEquals(5,t.numNodesLessThan(r.left, 7));
		assertEquals(3,t.numNodesLessThan(r.left, 5));

	}

	@Test
	public void testNumLeavesLessThan() {
		BSTNode r = new BSTNode(7);
		BSTRecursive t = new BSTRecursive(r, 1);
		t.insert(3);
		t.insert(1);
		t.insert(11);
		t.insert(2);
		t.insert(5);
		t.insert(9);
		t.insert(6);
		assertEquals(1,t.numLeavesLessThan(r, 5));
		assertEquals(0,t.numLeavesLessThan(r.right, 5));
		assertEquals(1,t.numLeavesLessThan(r.right, 10));
		assertEquals(0,t.numLeavesLessThan(r.right.left, 5));
		assertEquals(2,t.numLeavesLessThan(r.left, 7));
	}
	
	@Test
	public void testInsertInOrder() {
		BSTNode r = new BSTNode(7);
		BSTRecursive t = new BSTRecursive(r, 1);
		t.insert(3);
		t.insert(1);
		t.insert(11);
		t.insert(2);
		t.insert(5);
		t.insert(9);
		t.insert(6);
		BSTNode r2 = new BSTNode(15);
		BSTRecursive t2 = new BSTRecursive(r2, 1);
		t2.insert(8);
		t2.insert(7);
		t2.insert(16);
		t2.insert(4);
		t2.insert(18);
		t2.insert(10);
		t2.insert(20);
		t.insertInOrder(r2);
		assertEquals(7,r.data);
		assertEquals(4,r.left.right.left.data);
		assertEquals(8,r.right.left.left.data);
		assertEquals(10,r.right.left.right.data);
		assertEquals(16,r.right.right.right.data);
		assertEquals(18,r.right.right.right.right.data);
		assertEquals(20,r.right.right.right.right.right.data);
	}
	
	@Test
	public void testNextOf() {
		BSTNode r = new BSTNode(7);
		BSTRecursive t = new BSTRecursive(r, 1);
		t.insert(3);
		t.insert(1);
		t.insert(11);
		t.insert(2);
		t.insert(5);
		t.insert(9);
		t.insert(6);
		assertEquals(2,t.nextOf(r, 1));
		assertEquals(3,t.nextOf(r, 2));
		assertEquals(5,t.nextOf(r, 3));
		assertEquals(5,t.nextOf(r, 4));
		assertEquals(6,t.nextOf(r, 5));
		assertEquals(7,t.nextOf(r, 6));
		assertEquals(9,t.nextOf(r, 7));
		assertEquals(9,t.nextOf(r, 8));
		assertEquals(11,t.nextOf(r, 9));
		assertEquals(11,t.nextOf(r, 10));
		assertEquals(11,t.nextOf(r, 11));
		assertEquals(12,t.nextOf(r, 12));
		
	}

}
