package volume0;

import java.util.Scanner;

//Circumscribed Circle of a Triangle
public class AOJ0010 {

	public static class Point {
		public double x;
		public double y;
		public Point(double x_, double y_) {
			x = x_; y=y_;
		}
	}
	
	public static class Line {
		public Point s,t;
		public Line(Point s_, Point t_) {
			s = s_; t = t_;
		}
	}
	
	public static Point crosspoint(Line l, Line m) {
		if(isParallel(l, m)){
			throw new IllegalArgumentException("parallel");
		}
		  double A = extp(sub(l.t, l.s), sub(m.t, m.s));
		  double B = extp(sub(l.t, l.s), sub(l.t, m.s));
		  if (Math.abs(A) < EPS && Math.abs(B) < EPS) return m.s; // same line
		  if (Math.abs(A) < EPS) assert(false); // !!!PRECONDITION NOT SATISFIED!!!
		  Point tp = sub(m.t, m.s);
		  return new Point(m.s.x + B/A*tp.x, m.s.y + B/A*tp.y);
	}
	
	public static boolean isParallel(Line l, Line m){
		Point a = new Point(l.t.x - l.s.x, l.t.y - l.s.y);
		Point b = new Point(m.t.x - m.s.x, m.t.y - m.s.y);
		if(Math.abs(Math.abs((a.x*b.x + a.y*b.y)/(Math.hypot(a.x, a.y)*Math.hypot(b.x, b.y)) - 1)) < EPS){
			return true;
		}
		return false;
	}
	
	public static Point sub(Point p1, Point p2) {
		return new Point(p1.x-p2.x, p1.y-p2.y);
	}
	
	public static double extp(Point p1, Point p2) {
		return p1.x*p2.y - p2.x*p1.y;
	}
	
	public static final double EPS = 1.0e-8;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t--!=0){
			Point[] p = new Point[3];
			for(int i=0;i<3;i++)p[i]=new Point(sc.nextDouble(), sc.nextDouble());
			Point mid1 = new Point((p[0].x+p[1].x)/2, (p[0].y+p[1].y)/2);
			Point dv = new Point(p[1].x-p[0].x, p[1].y-p[0].y);
			Point cv = new Point(-dv.y, dv.x);
			Point c1 = new Point(mid1.x+cv.x, mid1.y+cv.y);
			Point mid2 = new Point((p[0].x+p[2].x)/2, (p[0].y+p[2].y)/2);
			dv = new Point(p[2].x-p[0].x, p[2].y-p[0].y);
			cv = new Point(-dv.y, dv.x);
			Point c2 = new Point(mid2.x+cv.x, mid2.y+cv.y);
			Point c = crosspoint(new Line(mid1, c1), new Line(mid2, c2));
			double r = Math.hypot(c.x-p[0].x, c.y-p[0].y);
			System.out.printf("%.3f %.3f %.3f\n", c.x, c.y, r);
		}
	}
}
