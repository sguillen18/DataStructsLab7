package Lab7;

public class Line {
	private Point2d start;
	private Point2d end;

	
	//in professor's prompt, y2 is actually just y
	public Line(double x1, double y1, double x2, double y2) {
		Point2d first = new Point2d(x1, y2);
		Point2d second = new Point2d(x2, y2);
		start = first;
		end = second;
	}
	
	public Line(Point2d start, Point2d end) {
		this.start = start;
		this.end = end;
	}
	
	public Point2d getStart() {
		return start;
	}
	
	public Point2d getEnd() {
		return end;
	}
	
	public void setStart(Point2d s) {
		start = s;
	}
	
	public void setEnd(Point2d e) {
		end = e;
	}
}
