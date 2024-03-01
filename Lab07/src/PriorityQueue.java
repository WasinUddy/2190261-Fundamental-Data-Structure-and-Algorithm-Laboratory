
public class PriorityQueue {
	MyQueue q;

	public PriorityQueue(MyQueue q) {
		super();
		this.q = q;
	}

	// implement this.
	public void push(int x) throws Exception {
	    if (this.q.isEmpty()) {
	        this.q.insertLast(x);
	        return;
	    }

	    int size = this.q.size();
	    boolean inserted = false;

	    // Iterate through the queue to find the correct position for the new element
	    for (int i = 0; i < size; i++) {
	        int current = this.q.removeFirst();

	        // If the current element is greater than x, insert x before the current element
	        if (!inserted && current > x) {
	            this.q.insertLast(x);
	            inserted = true;
	        }

	        this.q.insertLast(current);
	    }

	    // If the new element is the largest, insert it at the end of the queue
	    if (!inserted) {
	        this.q.insertLast(x);
	    }
	}

	// implement this.
	public void pop() throws Exception {
		this.q.removeFirst();
	}

	// implement this
	public int top() throws Exception {
		return this.q.front();
	}

}
