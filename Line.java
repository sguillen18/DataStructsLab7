package Lab7;

public class Line {
	private Point2d start;
	private Point2d end;
	
	private class Point2d{
		private double x;
		private double y;
		public Point2d(double x, double y) {
			this.x = x;
			this.y = y;
		}
		
		public double getX() {
			return x;
		}
		
		public double getY() {
			return y;
		}
		
		public void setX(double xNew) {
			x = xNew;
		}
		
		public void setY(double yNew) {
			y = yNew;
		}
		
	}
	
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
