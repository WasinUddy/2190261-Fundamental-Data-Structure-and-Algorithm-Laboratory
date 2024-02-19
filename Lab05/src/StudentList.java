
public class StudentList extends CDLinkedList {
    // you can write additional methods.

	// implement this method
	public void swapNode(DListIterator i1, DListIterator i2) {
		// Change pointer from previous node of both i1 and i2 
		i1.currentNode.previousNode.nextNode = i2.currentNode;
		i2.currentNode.previousNode.nextNode = i1.currentNode;
		
		// Change pointer for next node of i1 and i2 to point back to new
		i1.currentNode.nextNode.previousNode = i2.currentNode;
		i2.currentNode.nextNode.previousNode = i1.currentNode;
		
		// Swap current prev point
		DListNode temp = i1.currentNode.previousNode;
		i1.currentNode.previousNode = i2.currentNode.previousNode;
		i2.currentNode.previousNode = temp;
		
		temp = i1.currentNode.nextNode;
		i1.currentNode.nextNode = i2.currentNode.nextNode;
		i2.currentNode.nextNode = temp;
	}
	
	// implement this method
	public void insertList(DListIterator i1, CDLinkedList st) {
		if (st.isEmpty()) {
			return;
		}
		
		// Change next node of i1 to n head of st
		DListNode temp = i1.currentNode.nextNode;
		
		i1.currentNode.nextNode = st.header.nextNode;
		st.header.nextNode.previousNode = i1.currentNode;
		
		st.header.previousNode.nextNode = temp;
		temp.previousNode = st.header.previousNode;
		
	}

	// implement this method
	public void gender(String g) throws Exception {
		DListIterator head = new DListIterator(this.header);
		DListIterator iter = new DListIterator(this.header);
		DListIterator tail = new DListIterator(this.header.previousNode);
		
		// Loop through linkedlist and rehead everytime it found and reloop
		// Loop till the end that next node is the header
		while (iter.currentNode.nextNode != this.header) {
			iter.next();
			
			if ((((Student) iter.currentNode.data).getSex()).equals(g)) {
				// Insert and shift header
				super.insert(iter.currentNode.data, head);
				head.next();
				
				// Remove it
				iter.currentNode.previousNode.nextNode = iter.currentNode.nextNode;
				iter.currentNode.nextNode.previousNode = iter.currentNode.previousNode;
				
			}
		}
	}

}
