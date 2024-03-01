
//Queue that stores integers.
public interface MyQueue {
	
	//Return the value of the first data.
	//Throw Exception if the queue is empty.
	public int front() throws EmptyQueueException; 
	
	//Return the value of the last data.
	//Throw Exception if the queue is empty.
	public int back() throws EmptyQueueException; 
	
	//Remove the first data (return its value too).
	//Throw Exception if the queue is empty.
	public int removeFirst() throws EmptyQueueException; 
	
	//Insert new data after the last data. The new data becomes the new last data.
	//Throw exception if the insert fails for some reason.
	public void insertLast(int data) throws Exception; 
	
	//Check if the queue is empty.
	public boolean isEmpty(); 
	
	//Check if the queue has no more space to store new data.
	public boolean isFull();
	
	//Return the number of data currently stored in the queue.
	public int size();        
}
