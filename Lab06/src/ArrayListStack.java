import java.util.ArrayList;

public class ArrayListStack implements Stack {
	private ArrayList<Integer> a;

	// implement a default constructor and all methods from interface Stack.
	// Additional methods maybe required in order to run tests.
	public ArrayListStack() {
		this.a = new ArrayList<Integer>();
	}

	public ArrayList<Integer> getA() {
		return this.a;
	}

	@Override
	public boolean isEmpty() {
		return this.a.isEmpty();
	}

	@Override
	public boolean isFull() {
		// if size over 100,000
		if (this.a.size() == 100000) {
			return true;
		}
		return false;
	}

	@Override
	public void makeEmpty() {
		this.a = new ArrayList<Integer>();
	}

	@Override
	public int top() throws Exception {
		if (this.isEmpty()) {
			throw new EmptyStackException();
		}
		return this.a.get(this.a.size() - 1);
	}

	@Override
	public void pop() throws Exception {
		if (this.isEmpty()) {
			throw new EmptyStackException();
		}
		this.a.remove(this.a.size() - 1);
	}

	@Override
	public void push(int data) throws Exception {
		if (this.isFull()) {
			throw new Exception("Stack is F Full");
		}
		a.add(data);
	}
	
}
