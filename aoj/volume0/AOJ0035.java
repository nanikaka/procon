package volume0;

import java.util.Scanner;

//Is it Convex?
public class AOJ0035 {

	static class Point {
		public double x;
		public double y;
		public Point(double x_, double y_) {
			x = x_; y=y_;
		}
		public String toString() {return "(" +x+", "+ y +")";}
	}
	
	static double extp(Point p1, Point p2) {
		return p1.x*p2.y - p2.x*p1.y;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String[] s = sc.next().split(",");
			Point[] p = new Point[4];
			for(int i=0;i<4;i++)p[i]=new Point(Double.parseDouble(s[i*2]),Double.parseDouble(s[i*2+1]));
			boolean l = true;
			boolean r = true;
			for(int i=0;i<4;i++){
				double dx = p[(i+1)%4].x-p[i].x;
				double dy = p[(i+1)%4].y-p[i].y;
				for(int j=0;j<4;j++){
					if(j==i||j==(i+1)%4)continue;
					double dx2 = p[j].x-p[i].x;
					double dy2 = p[j].y-p[i].y;
					double ex = extp(new Point(dx, dy), new Point(dx2, dy2));
					if(ex>0)r=false;
					else l=false;
				}
			}
			System.out.println(l||r?"YES":"NO");
		}
	}
}
