package volume12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Heavenly Jewels
public class AOJ1213 {

	double EPS = 1e-8;
	double norm(Point p) {
		return Math.hypot(p.x, p.y);
	}
	double inp(Point p1, Point p2) {
		return p1.x*p2.x + p1.y*p2.y;
	}
	double extp(Point p1, Point p2) {
		return p1.x*p2.y - p2.x*p1.y;
	}
	Point sub(Point p1, Point p2) {
		return new Point(p1.x-p2.x, p1.y-p2.y);
	}
	int ccw(Point a, Point b, Point c) {
		Point p = sub(b, a);
		Point q = sub(c, a);
		if(extp(p, q) > EPS) return 1;		// counter clockwise
		if(extp(p, q) < -EPS)return -1;		// clockwise
		if(inp(p, q) < -EPS) return 2;		// c--a--b on line
		if(Math.abs(norm(p) - norm(q)) < EPS) return -2;	// a--b--c on line
		return 0;				// a--c--b(or a--c=b) on line 
	}
	Point crosspoint(Line l, Line m) {
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
	boolean isParallel(Line l, Line m){
		Point a = new Point(l.t.x - l.s.x, l.t.y - l.s.y);
		Point b = new Point(m.t.x - m.s.x, m.t.y - m.s.y);
		if(Math.abs(Math.abs((a.x*b.x + a.y*b.y)/(Math.hypot(a.x, a.y)*Math.hypot(b.x, b.y)) - 1)) < EPS){
			return true;
		}
		return false;
	}

	double area(Point[] p) {
		double s = 0;
		for(int i=0; i<p.length; i++) {
			int j = (i+1)%p.length;
			s += extp(p[i], p[j]);
		}
		s /= 2;
		return Math.abs(s);
	}
	Point[] convexCut(Point[] p, Line l) {
		List<Point> q = new ArrayList<Point>();
		for (int i = 0; i < p.length; ++i) {
			Point a= p[i], b = p[(i+1)%p.length];
			if (ccw(l.s, l.t, a) != -1) q.add(a);
			if (ccw(l.s, l.t, a)*ccw(l.s, l.t, b) < 0)
				q.add(crosspoint(new Line(a, b), l));
		}
		return q.toArray(new Point[q.size()]);
	}

	class Point {
		double x;
		double y;
		public Point(double x_, double y_) {
			x = x_; y=y_;
		}
	}
	class Line {
		Point s,t;
		public Line(Point s_, Point t_) {
			s = s_; t = t_;
		}
	}

	void run(){
		Scanner sc = new Scanner(System.in);
		int T = 1;
		for(;;){
			int x1 = sc.nextInt(), y1 = sc.nextInt(), x2 = sc.nextInt(), y2 = sc.nextInt(), x3 = sc.nextInt(), y3 = sc.nextInt();
			if((x1|y1|x2|y2|x3|y3)==0)break;
			Point[] p = new Point[4];
			p[0] = new Point(0, 0);
			p[1] = new Point(10000, 0);
			p[2] = new Point(10000, 10000);
			p[3] = new Point(0, 10000);
			Point ic = new Point(x1, y1);
			Point pc = new Point(x2, y2);
			Point ac = new Point(x3, y3);
			Point mid = new Point((x1+x2)/2.0, (y1+y2)/2.0);
			Point sub = sub(pc, ic);
			Point r = new Point(mid.x-sub.y, mid.y+sub.x);
			p = convexCut(p, new Line(mid, r));
			mid = new Point((x1+x3)/2.0, (y1+y3)/2.0);
			sub = sub(ac, ic);
			r = new Point(mid.x-sub.y, mid.y+sub.x);
			p = convexCut(p, new Line(mid, r));
			double a = area(p);
			System.out.printf("%d %.5f\n", T++, a/(100000000));
		}
	}

	public static void main(String[] args) {
		new AOJ1213().run();
	}
}
