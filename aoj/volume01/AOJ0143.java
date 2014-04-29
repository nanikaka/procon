package volume01;

import java.util.Scanner;

//Altair and Vega
public class AOJ0143 {

	public static class Point {
		public double x;
		public double y;
		public Point(double x_, double y_) {
			x = x_; y=y_;
		}
	}
	public static Point sub(Point p1, Point p2) {
		return new Point(p1.x-p2.x, p1.y-p2.y);
	}
	public static double extp(Point p1, Point p2) {
		return p1.x*p2.y - p2.x*p1.y;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t--!=0){
			Point[] p = new Point[3];
			for(int i=0;i<3;i++)p[i]=new Point(sc.nextDouble(), sc.nextDouble());
			Point p1 = new Point(sc.nextDouble(), sc.nextDouble());
			Point p2 = new Point(sc.nextDouble(), sc.nextDouble());
			boolean in1 = false;
			boolean in2 = false;
			boolean right = true;
			boolean left = true;
			boolean right2 = true;
			boolean left2 = true;
			for(int i=0;i<3;i++){
				Point base = sub(p[(i+1)%3], p[i]);
				Point bec = sub(p1, p[i]);
				Point bec2 = sub(p2, p[i]);
				if(extp(base, bec)<0) left = false;
				else right = false;
				if(extp(base, bec2)<0) left2 = false;
				else right2 = false;
			}
			in1 = left|right;
			in2 = left2|right2;
			System.out.println(in1!=in2?"OK":"NG");
		}
	}
}
