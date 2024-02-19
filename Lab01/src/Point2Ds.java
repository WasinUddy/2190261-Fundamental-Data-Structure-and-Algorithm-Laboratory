import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class Point2Ds {
	private Point2D[] points;
	
	public Point2D getPoint(int i) {
		// Return the point object at index i 
		
		// Put your code here
		return this.points[i];
	}
	
	public void readFromFile(String filename) throws FileNotFoundException {
		// Read all points stored in filename
		// Store them in the array points 
	
		
		// Put your code here
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line;

			while ((line = br.readLine()) != null) {
				String[] coor = line.split(" ");
				if (points == null) {
					points = new Point2D[1];
					points[0] = new Point2D(Double.parseDouble(coor[0]), Double.parseDouble(coor[1]));
				} else {
					int len = points.length + 1;
					Point2D[] newPoints = new Point2D[len];
					for (int i = 0; i < points.length; i++) {
						newPoints[i] = points[i];
					}

					newPoints[len - 1] = new Point2D(Double.parseDouble(coor[0]), Double.parseDouble(coor[1]));
					points = newPoints;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Point2D getClosestPointToOrigin() {
		// Return the point that is closest to the origin 
		
		// Put your code here

		
		return this.getClosestPoint(0.0, 0.0);
	}

	public Point2D getClosestPoint(double x, double y) {
		double minimum = Double.POSITIVE_INFINITY;
		Point2D ref = new Point2D(x, y);
		Point2D minp = null;
		for (Point2D point : this.points) {
			double distance = point.distance(ref);
			if (distance < minimum) {
				minimum = distance;
				minp = point;
			}
		}
		return minp;
	}
}
