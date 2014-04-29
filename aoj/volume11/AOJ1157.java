package volume11;

import java.util.Scanner;

//Roll-A-Big-Ball
public class AOJ1157 {

	final double EPS = 1e-8;
	
	double dot(double[] a, double[] b){
		return a[0]*b[0]+a[1]*b[1];
	}
	double cross(double[] a, double[] b){
		return a[0]*b[1]-a[1]*b[0];
	}
	double norm(double[] a){
		return Math.hypot(a[0], a[1]);
	}
	double norm(double[] a, double[] b){
		return Math.hypot(a[0]-b[0], a[1]-b[1]);
	}
	double[] sub(double[] a, double[] b){
		return new double[]{a[0]-b[0], a[1]-b[1]};
	}
	double ex(double[] a, double[] b, double[] c){
		double[] s1 = sub(b, a), s2 = sub(c, a);
		return cross(s1, s2);
	}
	double area(double[] a, double[] b, double[] c){
		double res = cross(a, b)+cross(b, c)+cross(c, a);
		return Math.abs(res)/2;
	}
	boolean crossing(double[] a, double[] b, double[] s, double[] t){
		if(Math.abs(cross(sub(b, a), sub(t, s)))<EPS){
			return Math.min(dist(a, b, s), Math.min(dist(a, b, t), Math.min(dist(s, t, a), dist(s, t, b))))<EPS;
		}
		if(ex(a, b, s)*ex(a, b, t)>0)return false;
		if(ex(b, a, s)*ex(b, a, t)>0)return false;
		if(ex(s, t, a)*ex(s, t, b)>0)return false;
		return ex(t, s, a)*ex(t, s, b)<0;
	}
	//Segment a-b Point p
	double dist(double[] a, double[] b, double[] p){
		if(dot(sub(b, a), sub(p, a))<EPS)return norm(a, p);
		if(dot(sub(a, b), sub(p, b))<EPS)return norm(b, p);
		return Math.abs(cross(sub(b, a), sub(p, a)))/norm(a, b);
	}
	//Segment a-b Segment s-t
	double dist(double[] a, double[] b, double[] s, double[] t){
		if(crossing(a, b, s, t))return 0;
		return Math.min(dist(a, b, s), Math.min(dist(a, b, t), Math.min(dist(s, t, a), dist(s, t, b))));
	}
	
	double[] S, T;
	double[][][] p;
	
	boolean in(int k){
		double area = norm(p[k][0], p[k][1])*norm(p[k][1], p[k][2]);
		double s = 0;
		for(int i=0;i<4;i++)s+=area(p[k][i], p[k][(i+1)%4], S);
		return Math.abs(area-s)<EPS;
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			int n = sc.nextInt();
			if(n==0)break;
			S = new double[]{sc.nextDouble(), sc.nextDouble()}; T = new double[]{sc.nextDouble(), sc.nextDouble()};
			p = new double[n][4][2];
			double[] h = new double[n];
			for(int i=0;i<n;i++){
				double x1 = sc.nextDouble(), y1 = sc.nextDouble(), x2 = sc.nextDouble(), y2 = sc.nextDouble();
				h[i] = sc.nextDouble();
				p[i][0] = new double[]{x1, y1};
				p[i][1] = new double[]{x2, y1};
				p[i][2] = new double[]{x2, y2};
				p[i][3] = new double[]{x1, y2};
			}
			double R = 1000;
			for(int i=0;i<n;i++){
				if(in(i)){
					R = 0; break;
				}
				double d = 1<<29;
				for(int j=0;j<4;j++)d = Math.min(d, dist(S, T, p[i][j], p[i][(j+1)%4]));
				if(h[i]<d)R = Math.min(R, (h[i]*h[i]+d*d)/2/h[i]);
				else R = Math.min(R, d);
			}
			System.out.printf("%.6f\n", R);
		}
	}
	
	public static void main(String[] args) {
		new AOJ1157().run();
	}
}
