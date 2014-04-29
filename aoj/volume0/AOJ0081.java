package volume0;

import java.util.Scanner;

//A Symmetric Point
public class AOJ0081 {
	
	public static class P{
		public double x;
		public double y;
		public P(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}

	public static class Vec{
		public P s;
		public P t;
		public double dx;
		public double dy;
		public Vec(P t){
			this.s = new P(0, 0);
			this.t = t;
			dx = t.x-s.x;
			dy = t.y-s.y;
		}
		public Vec(P s, P t) {
			this.s = s;
			this.t = t;
			dx = t.x-s.x;
			dy = t.y-s.y;
		}
		public P symmetricPoint(P p){
			if(s.x==t.x){
				return new P(p.x+(s.x-p.x)*2, p.y);
			}
			else if(s.y==t.y){
				return new P(p.x, p.y+(s.y-p.y)*2);
			}
			else{
				double alpha = (s.y-t.y)/(s.x-t.x);
				double beta = s.y-s.x*alpha;
				double x = (2*p.y*alpha-2*alpha*beta+p.x-alpha*alpha*p.x)/(alpha*alpha+1);
				double y = (p.x-x)/alpha+p.y;
				return new P(x, y);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String[] s = sc.next().split(",");
			double x1 = Double.parseDouble(s[0]);
			double y1 = Double.parseDouble(s[1]);
			double x2 = Double.parseDouble(s[2]);
			double y2 = Double.parseDouble(s[3]);
			double x3 = Double.parseDouble(s[4]);
			double y3 = Double.parseDouble(s[5]);
			P p1 = new P(x1,y1);
			P p2 = new P(x2,y2);
			P q = new P(x3,y3);
			P r = (new Vec(p1,p2)).symmetricPoint(q);
			System.out.println(r.x+" "+r.y);
		}
	}
}
