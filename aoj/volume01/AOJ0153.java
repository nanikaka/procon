package volume01;

import java.util.Scanner;

//Triangle and Circle
public class AOJ0153 {

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
	public static double distanceSP(Line s, Point p) {
		Point r = proj(s, p);
		if (intersectSP(s, r)) return norm(sub(r, p));
		return Math.min(norm(sub(s.s, p)), norm(sub(s.t, p)));
	}
	public static boolean intersectSP(Line s, Point p) {
		return ccw(s.s, s.t, p) == 0;
	}
	public static int ccw(Point a, Point b, Point c) {
		Point p = sub(b, a);
		Point q = sub(c, a);
		if(extp(p, q) > EPS) return 1;		// counter clockwise
		if(extp(p, q) < -EPS)return -1;		// clockwise
		if(inp(p, q) < -EPS) return 2;		// c--a--b on line
		if(Math.abs(norm(p) - norm(q)) < EPS) return -2;	// a--b--c on line
		return 0;				// a--c--b(or a--c=b) on line 
	}
	public static Point sub(Point p1, Point p2) {
		return new Point(p1.x-p2.x, p1.y-p2.y);
	}
	public static Point proj(Line l, Point p) {
		double t = inp(sub(p, l.s), sub(l.s, l.t)) / Math.pow(norm(sub(l.s, l.t)),2);
		Point tp = sub(l.s, l.t);
		return new Point(l.s.x + t*tp.x, l.s.y + t*tp.y);
	}
	public static double inp(Point p1, Point p2) {
		return p1.x*p2.x + p1.y*p2.y;
	}
	public static double extp(Point p1, Point p2) {
		return p1.x*p2.y - p2.x*p1.y;
	}
	public static final double EPS = 1.0e-8;
	public static double norm(Point p) {
		return Math.hypot(p.x, p.y);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			Point pp = new Point(sc.nextDouble(), sc.nextDouble());
			if(pp.x==0&&pp.y==0)break;
			Point[] p = new Point[3];
			p[0]=pp;
			for(int i=1;i<3;i++)p[i]=new Point(sc.nextDouble(),sc.nextDouble());
			Point c = new Point(sc.nextDouble(),sc.nextDouble());
			double r = sc.nextDouble();
			boolean isB = true;
			for(int i=0;i<3;i++){
				if(!(Math.pow(c.x-p[i].x, 2)+Math.pow(c.y-p[i].y, 2)<=r*r))isB = false;
			}
			if(isB){
				System.out.println("b");continue;
			}
			boolean left = true;
			boolean right = true;
			double min = Integer.MAX_VALUE;
			double max = 0;
			for(int i=0;i<3;i++){
				double ex = extp(sub(p[(i+1)%3], p[i]), sub(c, p[i]));
				if(ex < 0)left = false;
				else if(ex > 0)right = false;
				Line l = new Line(p[i], p[(i+1)%3]);
				//逆向きの線分も考えないと通らない AOJ0129参照
				Line m = new Line(p[(i+1)%3], p[i]);
				double d = Math.max(distanceSP(l, c), distanceSP(m, c));
				min = Math.min(min, d);
				max = Math.max(max, d);
			}
			boolean in = left|right;
			if(in && min >= r)System.out.println("a");
			else if(!in && min > r)System.out.println("d");
			else System.out.println("c");
		}
	}
}
