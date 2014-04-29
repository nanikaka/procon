package volume21;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Voronoi Island
public class AOJ2160 {

	final double EPS = 1.0e-8;

	double norm(Point p) {
		return Math.sqrt(Math.pow(p.x, 2)+Math.pow(p.y, 2));
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
		Point p = sub(b, a), q = sub(c, a);
		if (extp(p, q) > 0)    return +1;      // counter clockwise
		if (extp(p, q) < 0)    return -1;      // clockwise
		if (inp(p, q) < 0)     return +2;      // c--a--b on line
		if (norm(p) < norm(q)) return -2;      // a--b--c on line
		return 0;                              // a--c--b(or a--c=b) on line
	}
	public class Point {
		double x,y;
		public Point(double x_, double y_) {
			x = x_; y=y_;
		}
	}
	public class Line {
		Point s,t;
		public Line(Point s_, Point t_) {
			s = s_; t = t_;
		}
	}
	Point[] convex_cut(Point[] p, Line l) {
		List<Point> q = new ArrayList<Point>();
		for (int i = 0; i < p.length; ++i) {
			Point a= p[i], b = p[(i+1)%p.length];
			if (ccw(l.s, l.t, a) != -1) q.add(a);
		    if (ccw(l.s, l.t, a)*ccw(l.s, l.t, b) < 0)
		      q.add(crosspoint(new Line(a, b), l));
		}
		return q.toArray(new Point[q.size()]);
	}
	Point crosspoint(Line l, Line m) {
		  double A = extp(sub(l.t, l.s), sub(m.t, m.s));
		  double B = extp(sub(l.t, l.s), sub(l.t, m.s));
		  if (Math.abs(A) < EPS && Math.abs(B) < EPS) return m.s; // same line
		  if (Math.abs(A) < EPS) assert(false); // !!!PRECONDITION NOT SATISFIED!!!
		  Point tp = sub(m.t, m.s);
		  return new Point(m.s.x + B/A*tp.x, m.s.y + B/A*tp.y);
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

	void run(){
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			int m = sc.nextInt();
			if((n|m)==0)break;
			Point[] p = new Point[n];
			for(int i=0;i<n;i++)p[i]=new Point(sc.nextDouble(), sc.nextDouble());
			Point[] lord = new Point[m];
			for(int i=0;i<m;i++)lord[i]=new Point(sc.nextDouble(), sc.nextDouble());
			for(int i=0;i<m;i++){
				Point[] area = new Point[n];
				for(int j=0;j<n;j++)area[j] = p[j];
				for(int j=0;j<m;j++){
					if(i==j)continue;
					Point mid = new Point((lord[i].x+lord[j].x)/2, (lord[i].y+lord[j].y)/2);
					double dx = lord[j].x-lord[i].x;
					double dy = lord[j].y-lord[i].y;
					double rx = -dy;
					double ry = dx;
					Point v = new Point(mid.x+rx, mid.y+ry);
					area = convex_cut(area, new Line(mid, v));
				}
				System.out.println(area(area));
			}
		}
	}

	public static void main(String[] args) {
		new AOJ2160().run();
	}
}
