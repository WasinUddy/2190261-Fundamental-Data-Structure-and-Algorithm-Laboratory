import static org.junit.Assert.*;

import org.junit.Test;

public class TestLinkedList {

	@Test
	public void testSize() throws Exception {
		LinkedList list = new LinkedList();
		assertEquals(0, list.size());

		Contact a = new Contact();
		Contact b = new Contact();
		list.insert(a, new MyListIterator(list.header));
		list.insert(b, new MyListIterator(list.header));
		assertEquals(2, list.size());

		Contact c = new Contact();
		list.insert(c, new MyListIterator(list.header));
		assertEquals(3, list.size());
	}

	@Test // This one you must compare the print result with what you think is
			// correct
	public void testPrintList() throws Exception {
		System.out.println("Test empty list.");
		LinkedList list = new LinkedList();
		list.printList(); // expect "The list has no data."

		Contact a = new Contact();
		a.name = "Ann";
		a.email = "ann@gmail.com";
		a.phone = "0812345678";

		Contact b = new Contact();
		b.name = "Kate";
		b.email = "kato@gmail.com";
		b.phone = "0856723232";

		list.insert(a, new MyListIterator(list.header));
		list.insert(b, new MyListIterator(list.header));
		System.out.println("Test list with 2 data.");
		list.printList(); // expect Kate info and then Ann info.

	}

	@Test
	public void testFindPosition() throws Exception {

		LinkedList list = new LinkedList();
		Iterator i = list.findPosition("Kate");
		assertNull(i);

		Contact ann = new Contact();
		ann.name = "Ann";
		ann.email = "ann@gmail.com";
		ann.phone = "0812345678";

		Contact kate = new Contact();
		kate.name = "Kate";
		kate.email = "kato@gmail.com";
		kate.phone = "0856723232";

		Contact jane = new Contact();
		jane.name = "Jane";
		jane.email = "jane@gmail.com";
		jane.phone = "0802340078";

		Contact jojo = new Contact();
		jojo.name = "Jojo";
		jojo.email = "jojo@gmail.com";
		jojo.phone = "0836527732";
		list.insert(jojo, new MyListIterator(list.header));
		list.insert(jane, new MyListIterator(list.header));
		list.insert(ann, new MyListIterator(list.header));
		list.insert(kate, new MyListIterator(list.header));

		MyListIterator itr = (MyListIterator) (list.findPosition("Jojo"));
		Contact d = (Contact) (itr.currentNode.data);
		assertEquals("Jojo", d.name);
		assertEquals("jojo@gmail.com", d.email);
		assertEquals("0836527732", d.phone);

		MyListIterator itr2 = (MyListIterator) (list.findPosition("Ann"));
		Contact d2 = (Contact) (itr2.currentNode.data);
		assertEquals("Ann", d2.name);
		assertEquals("ann@gmail.com", d2.email);
		assertEquals("0812345678", d2.phone);

		MyListIterator itr3 = (MyListIterator) (list.findPosition("Tora"));
		assertNull(itr3);

	}

	@Test
	public void testAdd() throws Exception {
		LinkedList list = new LinkedList();

		Contact ann = new Contact();
		ann.name = "Ann";
		ann.email = "ann@gmail.com";
		ann.phone = "0812345678";

		Contact kate = new Contact();
		kate.name = "Kate";
		kate.email = "kato@gmail.com";
		kate.phone = "0856723232";

		Contact jane = new Contact();
		jane.name = "Jane";
		jane.email = "jane@gmail.com";
		jane.phone = "0802340078";

		Contact jojo = new Contact();
		jojo.name = "Jojo";
		jojo.email = "jojo@gmail.com";
		jojo.phone = "0836527732";

		list.add(jojo);
		Contact data = (Contact) (list.header.nextNode.data);
		assertEquals("Jojo", data.name);
		assertEquals("jojo@gmail.com", data.email);
		assertEquals("0836527732", data.phone);

		list.add(kate);
		list.add(ann);
		list.add(jane);

		Contact first = (Contact) (list.header.nextNode.data);
		assertEquals("Ann", first.name);
		assertEquals("ann@gmail.com", first.email);
		assertEquals("0812345678", first.phone);

		Contact second = (Contact) (list.header.nextNode.nextNode.data);
		assertEquals("Jane", second.name);
		assertEquals("jane@gmail.com", second.email);
		assertEquals("0802340078", second.phone);

		Contact third = (Contact) (list.header.nextNode.nextNode.nextNode.data);
		assertEquals("Jojo", third.name);
		assertEquals("jojo@gmail.com", third.email);
		assertEquals("0836527732", third.phone);

		Contact forth = (Contact) (list.header.nextNode.nextNode.nextNode.nextNode.data);
		assertEquals("Kate", forth.name);
		assertEquals("kato@gmail.com", forth.email);
		assertEquals("0856723232", forth.phone);

		assertNull(list.header.nextNode.nextNode.nextNode.nextNode.nextNode);

	}

	@Test
	public void testremoveAt() throws Exception {
		LinkedList list = new LinkedList();

		Contact ann = new Contact();
		ann.name = "Ann";
		ann.email = "ann@gmail.com";
		ann.phone = "0812345678";

		Contact kate = new Contact();
		kate.name = "Kate";
		kate.email = "kato@gmail.com";
		kate.phone = "0856723232";

		Contact jane = new Contact();
		jane.name = "Jane";
		jane.email = "jane@gmail.com";
		jane.phone = "0802340078";

		Contact jojo = new Contact();
		jojo.name = "Jojo";
		jojo.email = "jojo@gmail.com";
		jojo.phone = "0836527732";
		
		
		assertNull(null,list.removeAt(null));
		
		MyListIterator itr = new MyListIterator(list.header.nextNode);
		assertNull(null,list.removeAt(itr));
		
		itr = new MyListIterator(list.header);
		assertNull(null,list.removeAt(itr));
		
		
		list.insert(kate, new MyListIterator(list.header));
		list.insert(jojo, new MyListIterator(list.header));
		list.insert(jane, new MyListIterator(list.header));
		list.insert(ann, new MyListIterator(list.header));
		
		LinkedList list2 = new LinkedList(); 
		
		MyListIterator itr2 = new MyListIterator(list2.header);
		assertNull(null,list.removeAt(itr2));
		
		itr.next();
		itr.next();
		
		
		//remove jane
		MyListIterator j1 = (MyListIterator)(list.removeAt(itr));
		Contact c = (Contact)(j1.currentNode.data);
		assertEquals("Jojo", c.name);
		assertEquals("jojo@gmail.com", c.email);
		assertEquals("0836527732", c.phone);
		
		
		Contact first = (Contact) (list.header.nextNode.data);
		assertEquals("Ann", first.name);
		assertEquals("ann@gmail.com", first.email);
		assertEquals("0812345678", first.phone);

		Contact second = (Contact) (list.header.nextNode.nextNode.data);
		assertEquals("Jojo", second.name);
		assertEquals("jojo@gmail.com", second.email);
		assertEquals("0836527732", second.phone);

		Contact third = (Contact) (list.header.nextNode.nextNode.nextNode.data);
		assertEquals("Kate", third.name);
		assertEquals("kato@gmail.com", third.email);
		assertEquals("0856723232", third.phone);
		
		assertEquals(3,list.size());

		
		//remove kate 
		j1.next();
		j1 = (MyListIterator)(list.removeAt(j1));
		c = (Contact)(j1.currentNode.data);
		assertEquals("Ann", c.name);
		assertEquals("ann@gmail.com", c.email);
		assertEquals("0812345678", c.phone);
		
		first = (Contact) (list.header.nextNode.data);
		assertEquals("Ann", first.name);
		assertEquals("ann@gmail.com", first.email);
		assertEquals("0812345678", first.phone);

		second = (Contact) (list.header.nextNode.nextNode.data);
		assertEquals("Jojo", second.name);
		assertEquals("jojo@gmail.com", second.email);
		assertEquals("0836527732", second.phone);

		assertEquals(2,list.size());
		
		
		// remove ann
		j1 = (MyListIterator)(list.removeAt(j1));
		c = (Contact)(j1.currentNode.data);
		assertEquals("Jojo", c.name);
		assertEquals("jojo@gmail.com", c.email);
		assertEquals("0836527732", c.phone);
		
		first = (Contact) (list.header.nextNode.data);
		assertEquals("Jojo", first.name);
		assertEquals("jojo@gmail.com", first.email);
		assertEquals("0836527732", first.phone);
		
		assertEquals(1,list.size());
		
		//remove jojo
		j1 = (MyListIterator)(list.removeAt(j1));
		assertEquals(list.header, j1.currentNode);
		assertEquals(0,list.size());
		
		
		
		
	}

}
