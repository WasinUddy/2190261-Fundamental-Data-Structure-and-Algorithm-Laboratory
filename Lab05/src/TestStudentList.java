import static org.junit.Assert.*;

import org.junit.Test;

public class TestStudentList {


	@Test 
	public void testSwapInSameList() throws Exception {
		Student a = new Student("1", "a", "female");
		Student b = new Student("2", "b", "male");
		Student c = new Student("3", "c", "female");
		Student d = new Student("4", "d", "male");
		Student e = new Student("5", "e", "female");
		
		StudentList s1 = new StudentList();
		s1.insert(e, new DListIterator(s1.header));
		s1.insert(d, new DListIterator(s1.header));
		s1.insert(c, new DListIterator(s1.header));
		s1.insert(b, new DListIterator(s1.header));
		s1.insert(a, new DListIterator(s1.header));
		
		DListIterator i1 = new DListIterator(s1.header);
		i1.next();
		i1.next();
		DListIterator i2 = new DListIterator(i1.currentNode);
		i2.next();
		i2.next();
		
		s1.swapNode(i1, i2);
		DListIterator i3 = new DListIterator(s1.header);
		i3.next();
		assertEquals("1", ((Student) i3.currentNode.data).getId());		
		i3.next();
		assertEquals("4", ((Student) i3.currentNode.data).getId());		
		i3.next();
		assertEquals("3", ((Student) i3.currentNode.data).getId());		
		i3.next();
		assertEquals("2", ((Student) i3.currentNode.data).getId());		
		i3.next();
		assertEquals("5", ((Student) i3.currentNode.data).getId());	
		i3.previous();
		assertEquals("2", ((Student) i3.currentNode.data).getId());	
		i3.previous();
		assertEquals("3", ((Student) i3.currentNode.data).getId());	
		i3.previous();
		assertEquals("4", ((Student) i3.currentNode.data).getId());	
		i3.previous();
		assertEquals("1", ((Student) i3.currentNode.data).getId());	
	}
	
	@Test 
	public void testSwapfromOtherList() throws Exception {
		Student a = new Student("1", "a", "female");
		Student b = new Student("2", "b", "male");
		Student c = new Student("3", "c", "female");
		Student d = new Student("4", "d", "male");
		Student e = new Student("5", "e", "female");

		Student f = new Student("6", "f", "female");
		Student g = new Student("7", "g", "male");
		Student h = new Student("8", "h", "female");


		StudentList s1 = new StudentList();
		s1.insert(e, new DListIterator(s1.header));
		s1.insert(d, new DListIterator(s1.header));
		s1.insert(c, new DListIterator(s1.header));
		s1.insert(b, new DListIterator(s1.header));
		s1.insert(a, new DListIterator(s1.header));

		StudentList s2 = new StudentList();
		s2.insert(h, new DListIterator(s2.header));
		s2.insert(g, new DListIterator(s2.header));
		s2.insert(f, new DListIterator(s2.header));

		DListIterator i1 = new DListIterator(s1.header);
		i1.next();
		i1.next();
		DListIterator i2 = new DListIterator(s2.header);
		i2.next();
		i2.next();
		
		s1.swapNode(i1, i2);
		DListIterator i3 = new DListIterator(s1.header);
		i3.next();
		assertEquals("1", ((Student) i3.currentNode.data).getId());		
		i3.next();
		assertEquals("7", ((Student) i3.currentNode.data).getId());		
		i3.next();
		assertEquals("3", ((Student) i3.currentNode.data).getId());		
		i3.next();
		assertEquals("4", ((Student) i3.currentNode.data).getId());		
		i3.next();
		assertEquals("5", ((Student) i3.currentNode.data).getId());		

		i3 = new DListIterator(s2.header);
		i3.next();
		assertEquals("6", ((Student) i3.currentNode.data).getId());		
		i3.next();
		assertEquals("2", ((Student) i3.currentNode.data).getId());		
		i3.next();
		assertEquals("8", ((Student) i3.currentNode.data).getId());		
	}

	@Test 
	public void testInsertAList() throws Exception {
		Student a = new Student("1", "a", "female");
		Student b = new Student("2", "b", "male");
		Student c = new Student("3", "c", "female");
		Student d = new Student("4", "d", "male");
		Student e = new Student("5", "e", "female");

		Student f = new Student("6", "f", "female");
		Student g = new Student("7", "g", "male");
		Student h = new Student("8", "h", "female");


		StudentList s1 = new StudentList();
		s1.insert(e, new DListIterator(s1.header));
		s1.insert(d, new DListIterator(s1.header));
		s1.insert(c, new DListIterator(s1.header));
		s1.insert(b, new DListIterator(s1.header));
		s1.insert(a, new DListIterator(s1.header));

		StudentList s2 = new StudentList();
		
		

		DListIterator i1 = new DListIterator(s1.header);
		i1.next();
		i1.next();
		s1.insertList(i1, s2);
		
		DListIterator i3 = new DListIterator(s1.header);
		i3.next();
		assertEquals("1", ((Student) i3.currentNode.data).getId());		
		i3.next();
		assertEquals("2", ((Student) i3.currentNode.data).getId());		
		i3.next();
		assertEquals("3", ((Student) i3.currentNode.data).getId());		
		i3.next();
		assertEquals("4", ((Student) i3.currentNode.data).getId());		
		i3.next();
		assertEquals("5", ((Student) i3.currentNode.data).getId());		

		
		s2.insert(h, new DListIterator(s2.header));
		s2.insert(g, new DListIterator(s2.header));
		s2.insert(f, new DListIterator(s2.header));
		
		s1.insertList(i1, s2);
		i3 = new DListIterator(s1.header);
		i3.next();
		assertEquals("1", ((Student) i3.currentNode.data).getId());		
		i3.next();
		assertEquals("2", ((Student) i3.currentNode.data).getId());		
		i3.next();
		assertEquals("6", ((Student) i3.currentNode.data).getId());		
		i3.next();
		assertEquals("7", ((Student) i3.currentNode.data).getId());		
		i3.next();
		assertEquals("8", ((Student) i3.currentNode.data).getId());
		i3.next();
		assertEquals("3", ((Student) i3.currentNode.data).getId());		
		i3.next();
		assertEquals("4", ((Student) i3.currentNode.data).getId());		
		i3.next();
		assertEquals("5", ((Student) i3.currentNode.data).getId());		
		i3.previous();
		assertEquals("4", ((Student) i3.currentNode.data).getId());		
		i3.previous();
		assertEquals("3", ((Student) i3.currentNode.data).getId());		
		i3.previous();
		assertEquals("8", ((Student) i3.currentNode.data).getId());		
		i3.previous();
		assertEquals("7", ((Student) i3.currentNode.data).getId());		
		i3.previous();
		assertEquals("6", ((Student) i3.currentNode.data).getId());		
		i3.previous();
		assertEquals("2", ((Student) i3.currentNode.data).getId());		
		i3.previous();
		assertEquals("1", ((Student) i3.currentNode.data).getId());		


	}
	
	@Test
	public void testGender() throws Exception {
		Student a = new Student("1", "a", "female");
		Student b = new Student("2", "b", "male");
		Student c = new Student("3", "c", "female");
		Student d = new Student("4", "d", "male");
		Student e = new Student("5", "e", "female");

		StudentList s1 = new StudentList();
		s1.insert(e, new DListIterator(s1.header));
		s1.insert(d, new DListIterator(s1.header));
		s1.insert(c, new DListIterator(s1.header));
		s1.insert(b, new DListIterator(s1.header));
		s1.insert(a, new DListIterator(s1.header));

		s1.gender("male");
		
		DListIterator i3 = new DListIterator(s1.header);
		i3.next();
		assertEquals("2", ((Student) i3.currentNode.data).getId());		
		i3.next();
		assertEquals("4", ((Student) i3.currentNode.data).getId());		
		i3.next();
		assertEquals("1", ((Student) i3.currentNode.data).getId());		
		i3.next();
		assertEquals("3", ((Student) i3.currentNode.data).getId());		
		i3.next();
		assertEquals("5", ((Student) i3.currentNode.data).getId());		

		s1 = new StudentList();
		s1.insert(e, new DListIterator(s1.header));
		s1.insert(d, new DListIterator(s1.header));
		s1.insert(c, new DListIterator(s1.header));
		s1.insert(b, new DListIterator(s1.header));
		s1.insert(a, new DListIterator(s1.header));

		s1.gender("female");
		i3 = new DListIterator(s1.header);
		i3.next();
		assertEquals("1", ((Student) i3.currentNode.data).getId());		
		i3.next();
		assertEquals("3", ((Student) i3.currentNode.data).getId());		
		i3.next();
		assertEquals("5", ((Student) i3.currentNode.data).getId());		
		i3.next();
		assertEquals("2", ((Student) i3.currentNode.data).getId());		
		i3.next();
		assertEquals("4", ((Student) i3.currentNode.data).getId());		
		
		

	}
}
