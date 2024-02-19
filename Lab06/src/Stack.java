
public interface Stack {
    //check if the stack is empty.
	public boolean isEmpty();

	//check if the stack is full.
	public boolean isFull();

	//set the stack to be an empty stack.
	public void makeEmpty();

	//return value on top of stack. If the stack is empty, throw exception.
	public int top() throws Exception;

	//remove value on top of stack. If the stack is empty, throw exception.
	public void pop() throws Exception;

	//push data on top of stack.
	public void push(int data) throws Exception;

}
