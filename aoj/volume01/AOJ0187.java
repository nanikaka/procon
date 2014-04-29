package volume01;

import java.util.Scanner;

//Stoning Fortune
public class AOJ0187 {

	static class Point {
		public double x;
		public double y;
		public Point(double x_, double y_) {
			x = x_; y=y_;
		}
	}
	static class Line {
		public Point s,t;
		public Line(Point s_, Point t_) {
			s = s_; t = t_;
		}
	}
	static Point crosspoint(Line l, Line m) {
		if(isParallel(l, m)){
			return null;
		}
		  double A = extp(sub(l.t, l.s), sub(m.t, m.s));
		  double B = extp(sub(l.t, l.s), sub(l.t, m.s));
		  if (Math.abs(A) < EPS && Math.abs(B) < EPS) return m.s; // same line
		  if (Math.abs(A) < EPS) assert(false); // !!!PRECONDITION NOT SATISFIED!!!
		  Point tp = sub(m.t, m.s);
		  return new Point(m.s.x + B/A*tp.x, m.s.y + B/A*tp.y);
	}
	static boolean isParallel(Line l, Line m){
		Point a = new Point(l.t.x - l.s.x, l.t.y - l.s.y);
		Point b = new Point(m.t.x - m.s.x, m.t.y - m.s.y);
		if(Math.abs(Math.abs((a.x*b.x + a.y*b.y)/(Math.hypot(a.x, a.y)*Math.hypot(b.x, b.y)) - 1)) < EPS){
			return true;
		}
		return false;
	}
	static final double EPS = 1.0e-8;
	static Point sub(Point p1, Point p2) {
		return new Point(p1.x-p2.x, p1.y-p2.y);
	}
	static double extp(Point p1, Point p2) {
		return p1.x*p2.y - p2.x*p1.y;
	}
	static boolean intersectSS(Line s, Line t) {
		return ccw(s.s,s.t,t.s)*ccw(s.s,s.t,t.t) <= 0 &&
		       ccw(t.s,t.t,s.s)*ccw(t.s,t.t,s.t) <= 0;
	}
	static int ccw(Point a, Point b, Point c) {
		Point p = sub(b, a);
		Point q = sub(c, a);
		if(extp(p, q) > EPS) return 1;		// counter clockwise
		if(extp(p, q) < -EPS)return -1;		// clockwise
		if(inp(p, q) < -EPS) return 2;		// c--a--b on line
		if(Math.abs(norm(p) - norm(q)) < EPS) return -2;	// a--b--c on line
		return 0;				// a--c--b(or a--c=b) on line
	}
	static double inp(Point p1, Point p2) {
		return p1.x*p2.x + p1.y*p2.y;
	}
	static double norm(Point p) {
		return Math.hypot(p.x, p.y);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			double x1 = sc.nextDouble();
			double y1 = sc.nextDouble();
			double x2 = sc.nextDouble();
			double y2 = sc.nextDouble();
			if(x1==0&&y1==0&&x2==0&&y2==0)break;
			Line[] l = new Line[3];
			l[0] = new Line(new Point(x1, y1), new Point(x2, y2));
			for(int i=1;i<3;i++)l[i]=new Line(new Point(sc.nextDouble(),sc.nextDouble()), new Point(sc.nextDouble(), sc.nextDouble()));
			Point[] c = new Point[3];
			boolean f = true;
			for(int i=0;i<3;i++){
				c[i] = crosspoint(l[i], l[(i+1)%3]);
				if(c[i]==null || !intersectSS(l[i], l[(i+1)%3]))f = false;
			}
			String ans = "";
			if(!f)ans = "kyo";
			else{
				double a = 0;
				for(int i=0;i<3;i++)a+=c[i].x*c[(i+1)%3].y-c[i].y*c[(i+1)%3].x;
				a = Math.abs(a/2);
				if(1900000<=a)ans = "dai-kichi";
				else if(1000000<=a)ans = "chu-kichi";
				else if(100000<=a)ans = "kichi";
				else if(0<a)ans = "syo-kichi";
				else ans = "kyo";
			}
			System.out.println(ans);
		}
	}
}
