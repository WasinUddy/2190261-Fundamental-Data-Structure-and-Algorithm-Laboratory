import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

public class TestJavaReview {

	@Test
	public void testNewPoint() {
		Point2D p1=new Point2D(2.3,4.5);
		assertTrue(p1.getX()==2.3);
		assertTrue(p1.getY()==4.5);
	}

	@Test
	public void testFindDistance() {
		Point2D p1=new Point2D(2.3,4.5);
		Point2D p2=new Point2D(1.3,2.6);
		System.out.println(p1.distance(p2));
		assertTrue(p1.distance(p2)==2.1470910553583886);
	}
	
	@Test
	public void testReadFromFile() {
		Point2Ds points = new Point2Ds();
		try {
			points.readFromFile("./src/points.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(points.getPoint(0).getX()==10.98);
		assertTrue(points.getPoint(0).getY()==14.29);
		assertTrue(points.getPoint(19).getX()==2.11);
		assertTrue(points.getPoint(19).getY()==15.51);		
	}
	
	@Test
	public void testClosestPointToOriginal() {
		Point2Ds points = new Point2Ds();
		try {
			points.readFromFile("./src/points.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Point2D p=points.getClosestPointToOrigin();
		assertTrue(p.getX()==2.27);
		assertTrue(p.getY()==2.35);	
	}

	@Test
	public void testClosestPoint() {
		Point2Ds points = new Point2Ds();
		try {
			points.readFromFile("./src/points.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Point2D p=points.getClosestPoint(0,0);
		assertTrue(p.getX()==2.27);
		assertTrue(p.getY()==2.35);	
		p=points.getClosestPoint(10,10);
		assertTrue(p.getX()==7.81);
		assertTrue(p.getY()==10.08);	
	}
}
