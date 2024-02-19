import javax.tools.Diagnostic;

class DListNode {
	// Constructors
	DListNode(Object data) {
		this(data, null, null);
	}

	DListNode(Object theElement, DListNode n, DListNode p) {
		data = theElement;
		nextNode = n;
		previousNode = p;
	}

	// Friendly data; accessible by other package routines
	Object data;
	DListNode nextNode, previousNode;
}

public class CDLinkedList {
	DListNode header;
	int size;

	public CDLinkedList() {
		size = 0;
		header = new DListNode(null);
		header.nextNode = header;
		header.previousNode = header;
	}

	public boolean isEmpty() {
		return header.nextNode == header;
	}

	/** make the list empty. */
	public void makeEmpty() {
		header.nextNode = header;
		header.previousNode = header;
	}

	// put in new data after the position of p.
	public void insert(Object data, Iterator p) throws Exception {
		if (p == null || !(p instanceof DListIterator))
			throw new Exception();
		DListIterator p2 = (DListIterator) p;
		if (p2.currentNode == null)
			throw new Exception();

		DListIterator p3 = new DListIterator(p2.currentNode.nextNode);
		DListNode n = new DListNode(data, p3.currentNode, p2.currentNode);
		p2.currentNode.nextNode = n;
		p3.currentNode.previousNode = n;
		size++;
	}

	// return position number of value found in the list.
	// otherwise, return -1.
	public int find(Object data) throws Exception {
		Iterator itr = new DListIterator(header);
		int index = -1;
		while (itr.hasNext()) {
			Object v = itr.next();
			index++;
			DListIterator itr2 = (DListIterator) itr;
			if (itr2.currentNode == header)
				return -1;
			if (v.equals(data))
				return index; // return the position of value.
		}
		return -1;
	}

	// return data stored at kth position.
	public Object findKth(int kthPosition) throws Exception {
		if (kthPosition < 0)
			throw new Exception();// exit the method if the position is
		// less than the first possible
		// position, throwing exception in the process.
		DListIterator itr = new DListIterator(header);
		int index = -1;
		while (itr.currentNode.nextNode != header) {
			Object v = itr.next();
			index++;
			DListIterator itr2 = (DListIterator) itr;
			if (itr2.currentNode == header)
				throw new Exception();
			if (index == kthPosition)
				return v;
		}
		throw new Exception();
	}

	// Return iterator at position before the first position that stores value.
	// If the value is not found, return null.
	public Iterator findPrevious(Object value) throws Exception {
		if (isEmpty())
			return null;
		Iterator itr1 = new DListIterator(header);
		Iterator itr2 = new DListIterator(header);
		Object currentData = itr2.next();
		while (!currentData.equals(value)) {
			currentData = itr2.next();
			itr1.next();
			if (((DListIterator) itr2).currentNode == header)
				return null;
		}
		if (currentData.equals(value))
			return itr1;
		return null;

	}

	// remove content at position just after the given iterator. Skip header if
	// found.
	public void remove(Iterator p) {
		if (isEmpty())
			return;
		if (p == null || !(p instanceof DListIterator))
			return;
		DListIterator p2 = (DListIterator) p;
		if (p2.currentNode == null)
			return;
		if (p2.currentNode.nextNode == header)
			p2.currentNode = header;
		if (p2.currentNode.nextNode == null)
			return;
		DListIterator p3 = new DListIterator(p2.currentNode.nextNode.nextNode);
		p2.currentNode.nextNode = p3.currentNode;
		p3.currentNode.previousNode = p2.currentNode;
		size--;
	}

	// remove the first instance of the given data.
	public void remove(Object value) throws Exception {
		Iterator p = findPrevious(value);
		if (p == null)
			return;
		remove(p);
	}

	// remove data at position p.
	// if p points to header or the list is empty, do nothing.
	public void removeAt(Iterator p) throws Exception {
		if (isEmpty() || p == null || !(p instanceof DListIterator) || ((DListIterator) p).currentNode == null
				|| ((DListIterator) p).currentNode == header)
			return;

		DListIterator p2 = (DListIterator) (findPrevious(p));
		remove(p2);

	}

	// Print each contact out, one by one.
	// To be completed by students.
	public void printList() throws Exception {
		DListIterator itr = new DListIterator(header);
		while (itr.currentNode.nextNode != header) {
			Object data = itr.next();
			System.out.println(data);
		}
	}

	// Returns the number of data stored in this list.
	// To be completed by students.
	public int size() throws Exception {
		DListIterator itr = new DListIterator(header);
		int count = 0;
		while (itr.currentNode.nextNode != header) {
			itr.next();
			count++;
		}
		return count;
	}

	// Return iterator pointing to value, or null otherwise.
	// To be completed by students.
	// Not used in class.
	public Iterator findPosition(Object value) throws Exception {
		Iterator itr = new DListIterator(header);
		while (itr.hasNext()) {
			Object data = itr.next();
			if (data.equals(value)) {
				return itr;
			}
		}

		return null;
	}

	// return iterator pointing to location before position.
	public Iterator findPrevious(Iterator position) throws Exception {
		if (position == null)
			return null;
		if (!(position instanceof DListIterator))
			return null;
		if (((DListIterator) position).currentNode == null)
			return null;

		DListIterator p = ((DListIterator) position);
		DListIterator p2 = new DListIterator(p.currentNode.previousNode);
		return p2;

	}

}