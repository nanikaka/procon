package volume0;

import java.util.Scanner;

//Intersection of Rectangles
public class AOJ0059 {

	public static final double EPS = 1e-8;

	public static class P implements Comparable<P>{
		public double x;
		public double y;
		public P(double x, double y) {
			this.x = x;
			this.y = y;
		}
		public int compareTo(P o) {
			if(equals(o))return 0;
			if(Math.abs(x-o.x)<EPS){
				return y-o.y<0?1:y-o.y>0?-1:0;
			}
			return x-o.x<0?1:x-o.x>0?-1:0;
		}
		public boolean equals(P o){
			return Math.abs(x-o.x)<EPS && Math.abs(y-o.y)<EPS;
		}
		@Override
		public String toString() {
			return "("+x+","+y+")";
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
		public Vec reverse(){
			return new Vec(t, s);
		}
		public double norm(){
			return Math.sqrt(dx*dx+dy*dy);
		}
		public double dotProduct(Vec o){
			return dx*o.dx + dy*o.dy;
		}
		public double crossProduct(Vec o){
			return dx*o.dy - dy*o.dx;
		}
		public boolean isOrthogonal(Vec o){
			return dotProduct(o)==0;
		}
		public boolean isParallel(Vec o){
			return crossProduct(o)==0;
		}
		public int ccw_(P p){
			return ccw(s, t, p);
		}
		public boolean isCross(Vec o){
			return ccw_(o.s)*ccw_(o.t) < EPS && o.ccw_(s)*o.ccw_(t) < EPS ||
			ccw_(o.s)*ccw_(o.t) < EPS && o.ccw_(s)*o.ccw_(t) < EPS;
		}
		public double distanceFromPoint(P p){
			Vec o = new Vec(s, p);
			return Math.abs(crossProduct(o))/norm();
		}
		@Override
		public String toString() {
			return s+"->"+t;
		}
	}

	public static int ccw(P p1, P p2, P p3){
		Vec a = new Vec(p1, p2);
		Vec b = new Vec(p1, p3);
		if(a.crossProduct(b)<0)return 1;
		if(a.crossProduct(b)>0)return -1;
		//if program run here, three points on line because AxB = 0 shows parallel
		if(a.dotProduct(b)<0)return 2;
		if(a.norm() < b.norm())return -2;
		return 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			P[] p = new P[4];
			for(int i=0;i<4;i++)p[i]=new P(sc.nextDouble(),sc.nextDouble());
			Vec[] v1 = new Vec[4];
			P p1 = new P(p[1].x, p[0].y);
			P p2 = new P(p[0].x, p[1].y);
			v1[0] = new Vec(p[0], p1);
			v1[1] = new Vec(p1, p[1]);
			v1[2] = new Vec(p[1], p2);
			v1[3] = new Vec(p2, p[0]);
			Vec[] v2 = new Vec[4];
			p1 = new P(p[3].x, p[2].y);
			p2 = new P(p[2].x, p[3].y);
			v2[0] = new Vec(p[2], p1);
			v2[1] = new Vec(p1, p[3]);
			v2[2] = new Vec(p[3], p2);
			v2[3] = new Vec(p2, p[2]);
			boolean f = false;
			boolean left1 = true;
			boolean left2 = true;
			for(int i=0;i<4;i++){
				for(int j=0;j<4;j++){
					if(v1[i].isCross(v2[j]))f = true;
					if(v1[i].ccw_(v2[j].s)!=-1||v1[i].ccw_(v2[j].t)!=-1)left1 = false;
					if(v2[j].ccw_(v1[i].s)!=-1||v2[j].ccw_(v1[i].t)!=-1)left2 = false;
				}
			}
			System.out.println(f||left1||left2?"YES":"NO");
		}
	}
}
