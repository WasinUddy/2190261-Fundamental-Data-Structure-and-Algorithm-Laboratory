
public class Point2D {
	private double x;
	private double y;
	public Point2D(double x,double y) {
		// Store x,y in this.x,this.y

		// Put your code here
		this.x = x;
		this.y = y;
		
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double distance(Point2D other) {
		// Return a double that is the distance between this and other
		
		
		// Put your code here
		double dx_sq = Math.pow((this.x - other.getX()), 2);
		double dy_sq = Math.pow((this.y - other.getY()), 2);
		
		return Math.sqrt(dx_sq + dy_sq);
	}
}
