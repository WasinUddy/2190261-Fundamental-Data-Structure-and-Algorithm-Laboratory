public class UseStack {
	
	/*
	//implement this method.
	public static Stack sort(Stack s) throws Exception {
		ArrayListStack tmpStack = new ArrayListStack();
		
		while (!s.isEmpty()) {
			int temp = s.top();
			
			while (!tmpStack.isEmpty() && tmpStack.top() > temp) {
				s.push(tmpStack.top());
				tmpStack.pop();
			}
			
			tmpStack.push(temp);
		}
		
		
		s.makeEmpty();
		// Inverse  it
		while (!tmpStack.isEmpty()) {
			s.push(tmpStack.top());
			tmpStack.pop();
		}
		
		
		return s;
	}
	*/
    public static Stack sort(Stack s) throws Exception {
        ArrayListStack tmpStack = new ArrayListStack(); // Temporary stack to hold sorted elements
        
        while (!s.isEmpty()) {
            int temp = s.top();
            s.pop();
            
            
            while (!tmpStack.isEmpty() && tmpStack.top() > temp) {
                s.push(tmpStack.top());
                tmpStack.pop();
            }
            
            tmpStack.push(temp);
        }
        
        
        s.makeEmpty(); // just for safe
        while (!tmpStack.isEmpty()) {
            s.push(tmpStack.top());
            tmpStack.pop();
        }
        
        return s;
    }

}

