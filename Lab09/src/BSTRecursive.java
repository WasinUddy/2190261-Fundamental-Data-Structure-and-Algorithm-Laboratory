import java.util.Arrays;

public class BSTRecursive {

	BSTNode root;
	int size;

	public BSTRecursive(BSTNode root, int size) {
		this.root = root;
		this.size = size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void makeEmpty() {
		root = null;
		size = 0;
	}

	public Iterator findMin() {
		return findMin(root);
	}

	public Iterator findMin(BSTNode n) {
		if (n == null)
			return null;
		if (n.left == null) {
			Iterator itr = new TreeIterator(n);
			return itr;
		}
		return findMin(n.left);
	}

	public Iterator findMax() {
		return findMax(root);
	}

	public Iterator findMax(BSTNode n) {
		if (n == null)
			return null;
		if (n.right == null) {
			Iterator itr = new TreeIterator(n);
			return itr;
		}
		return findMax(n.right);
	}

	public Iterator find(int v) {
		return find(v, root);
	}

	public Iterator find(int v, BSTNode n) {
		if (n == null)
			return null;
		if (v == n.data)
			return new TreeIterator(n);
		if (v < n.data)
			return find(v, n.left);
		else
			return find(v, n.right);
	}

	public BSTNode insert(int v) {
		return insert(v, root, null);
	}

	// return the node n after v was added into the tree
	public BSTNode insert(int v, BSTNode n, BSTNode parent) {
		if (n == null) {
			n = new BSTNode(v, null, null, parent);
			size++;
		} else if (v < n.data) {
			n.left = insert(v, n.left, n);
		} else if (v > n.data) {
			n.right = insert(v, n.right, n);
		}
		return n;
	}

	public BSTNode remove(int v) {
		return remove(v, root, null);
	}

	// return the node n after v was removed from the tree
	public BSTNode remove(int v, BSTNode n, BSTNode parent) {
		if (n == null)
			; // do nothing, there is nothing to be removed
		else if (v < n.data) {
			n.left = remove(v, n.left, n);
		} else if (v > n.data) {
			n.right = remove(v, n.right, n);
		} else {
			if (n.left == null && n.right == null) {
				n.parent = null; // disconnect from above
				n = null; // disconnect from below
				size--;
			} else if (n.left != null && n.right == null) {
				BSTNode n2 = n.left;
				n2.parent = parent;
				n.parent = null; // disconnect from above
				n.left = null; // disconnect from below
				n = n2; // change to the node below
						// to prepare for connection from parent
				size--;
			} else if (n.right != null && n.left == null) {
				BSTNode n2 = n.right;
				n2.parent = parent;
				n.parent = null; // disconnect from above
				n.right = null; // disconnect from below
				n = n2; // change to the node below
						// to prepare for connection from parent
				size--;
			} else {
				TreeIterator i = (TreeIterator) findMin(n.right);
				int minInRightSubtree = i.currentNode.data;
				n.data = minInRightSubtree;
				n.right = remove(minInRightSubtree, n.right, n);
			}
		}
		return n;
	}

	private int height(BSTNode n) {
		if (n == null)
			return -1;
		return 1 + Math.max(height(n.left), height(n.right));
	}

	/**************************************************************************************************/
	// Edit only the following methods.
	/**************************************************************************************************/

	/**
	 * Internal method to find the number of nodes in a given subtree using a
	 * recursive method.
	 * 
	 * @param n
	 *            the root of a given subtree
	 * @param v
	 *            the threshold 
	 * @return the number of nodes in which the data is less than v in the subtree 
	 */
	public int numNodesLessThan(BSTNode n,int v) {
		if (n == null) {
			return 0;
		}
		
		int leftCount = numNodesLessThan(n.left, v);
		int rightCount = numNodesLessThan(n.right, v);
		
		if (n.data < v) {
			return 1 + leftCount + rightCount;
		}else {
			return 0 + leftCount + rightCount;
		}
	}

	/**
	 * Internal method to count the number of leaves in a given subtree
	 * (recursively).
	 * 
	 * @param n
	 *            root node of a given subtree
	 * @param v
	 *            the threshold
	 * @return number of leaves in which the data is less than v in the subtree, 
	 */
	public int numLeavesLessThan(BSTNode n, int v) {
		if (n == null) {
			return 0;
		}
		
		// THIS IS THE LEAF
		if (n.left == null && n.right == null) {
			// THIS NODE IS VALID + 1 to the bank
			if (n.data < v) {
				return 1;
			}
			// NOT VALID
			return 0;
		}
		
		return numLeavesLessThan(n.left, v) + numLeavesLessThan(n.right, v);
	}

	/**
	 * In order insert all nodes from a BST that has n as the root node. 
	 * 
	 * @param n
	 *            the node that roots the subtree.
	 * 
	 */
	public void insertInOrder(BSTNode n) {
		if (n == null) {
			return;
		}else {
			this.insert(n.data);
		}
		insertInOrder(n.left);
		insertInOrder(n.right);
	}
	
	/**
	 * Find the next data of v in the subtree which has n as the root node
	 * 
	 * @param n
	 *            root node of a given subtree
	 * @param v
	 *            the value v
	 * @return next data of v in the given subtree 
	 */
	public int nextOf(BSTNode n,int v) {
		// Base case the next value do not exist
		if (n == null) {
			return v;
		}
		
		// if the current data is more than v it could be the answer but we will go to its left may be something is less than current node but more than v
		if (n.data > v) {
			int left = nextOf(n.left, v);
			
			// NOT THING ON THE LEFT IS MORE THAN v
			if (left == v) {
				return n.data;
			} else {
				return left;
			}
		} else {
			return nextOf(n.right, v);
		}
	}

}
