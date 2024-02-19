import java.util.NoSuchElementException;

public class MyListIterator implements Iterator {
	ListNode currentNode; // interested position

	/**
	 * @param theNode
	 *            any node in the list
	 */
	MyListIterator(ListNode theNode) {
		currentNode = theNode;
	}

	@Override
	public boolean hasNext() {
		return currentNode.nextNode != null;
	}

	@Override
	public Object next() throws Exception {
		// Throw exception if the next data
		// does not exist.
		if (!hasNext())
			throw new NoSuchElementException();
		currentNode = currentNode.nextNode;
		return currentNode.data;

	}

	@Override
	public void set(Object value) {
		currentNode.data = value;
	}

}
