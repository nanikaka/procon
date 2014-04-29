package volume22;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Immortal Jewels
public class AOJ2201 {

	final double EPS = 1e-8;

	double dot(double[] a, double[] b){
		return a[0]*b[0]+a[1]*b[1];
	}
	double cross(double[] a, double[] b){
		return a[0]*b[1]-a[1]*b[0];
	}
	double norm(double[] a){
		return Math.sqrt(a[0]*a[0]+a[1]*a[1]);
	}
	double norm(double[] a, double[] b){
		return norm(sub(a, b));
	}
	double[] sub(double[] a, double[] b){
		return new double[]{a[0]-b[0], a[1]-b[1]};
	}
	double angleCos(double[] a, double[] b){
		double na = norm(a), nb = norm(b);
		return Math.acos(dot(a, b)/na/nb);
	}
	double distLP(double[] a, double[] b, double[] p){
		return Math.abs(cross(sub(b, a), sub(p, a)))/norm(a, b);
	}
	double[] rotate(double[] a, double thita){
		return new double[]{Math.cos(thita)*a[0]-Math.sin(thita)*a[1], Math.sin(thita)*a[0]+Math.cos(thita)*a[1]};
	}
	int checkCircleOverlap(double x1, double y1, double r1, double x2, double y2, double r2){
		double d = (x1-x2)*(x1-x2)+(y1-y2)*(y1-y2), r = (r1-r2)*(r1-r2), R = (r1+r2)*(r1+r2);
		if(R < d)return 0;
		if(Math.abs(d-R)<EPS)return 1;
		if(r < d && d < R)return 2;
		if(Math.abs(d-r)<EPS)return -1;
		return -2;
	}

	List<double[][]> circleTangentialLine(double x1, double y1, double r1, double x2, double y2, double r2){
		List<double[][]> res = new ArrayList<double[][]>();
		int crossPointN = checkCircleOverlap(x1, y1, r1, x2, y2, r2);
		if(crossPointN==-2)return res;
		double[] P = {x1, y1}, Q = {x2, y2};
		if(crossPointN==-1){
			if(r2 < r1){
				double[] v = sub(Q, P);
				double d = norm(v);
				v[0] = v[0]/d*r1;
				v[1] = v[1]/d*r1;
				double[] r = rotate(v, Math.PI/2);
				res.add(new double[][]{{P[0]+v[0], P[1]+v[1]}, {P[0]+v[0]+r[0], P[1]+v[1]+r[1]}});
			}
			else{
				double[] v = sub(P, Q);
				double d = norm(v);
				v[0] = v[0]/d*r2;
				v[1] = v[1]/d*r2;
				double[] r = rotate(v, Math.PI/2);
				res.add(new double[][]{{Q[0]+v[0], Q[1]+v[1]}, {Q[0]+v[0]+r[0], Q[1]+v[1]+r[1]}});
			}
			return res;
		}
		double[] sub = sub(Q, P);
		double d = norm(sub);
		sub[0]/=d; sub[1]/=d;
		double thita = Math.acos(Math.sqrt(d*d-(r1-r2)*(r1-r2))/d);
		double[] v1, v2;
		if(r2 < r1){
			v1 = rotate(sub, Math.PI/2-thita); v2 = rotate(sub, thita-Math.PI/2);
		}
		else{
			v1 = rotate(sub, Math.PI/2+thita); v2 = rotate(sub, -(Math.PI/2+thita));
		}
		res.add(new double[][]{{P[0]+v1[0]*r1, P[1]+v1[1]*r1}, {Q[0]+v1[0]*r2, Q[1]+v1[1]*r2}});
		res.add(new double[][]{{P[0]+v2[0]*r1, P[1]+v2[1]*r1}, {Q[0]+v2[0]*r2, Q[1]+v2[1]*r2}});
		if(crossPointN==1){
			double[] v = {sub[0]*r1, sub[1]*r1};
			double[] r = rotate(v, Math.PI/2);
			res.add(new double[][]{{P[0]+v[0], P[1]+v[1]}, {P[0]+v[0]+r[0], P[1]+v[1]+r[1]}});
		}
		else{
			double A = r1*d/(r1+r2), CC = r1*r1*(d*d-(r1+r2)*(r1+r2))/((r1+r2)*(r1+r2));
			thita = Math.acos((r1*r1+A*A-CC)/(2*A*r1));
			v1 = rotate(sub, thita); v2 = rotate(sub, -thita);
			double[] u1 = {-v1[0], -v1[1]}, u2 = {-v2[0], -v2[1]};
			res.add(new double[][]{{P[0]+v1[0]*r1, P[1]+v1[1]*r1}, {Q[0]+u1[0]*r2, Q[1]+u1[1]*r2}});
			res.add(new double[][]{{P[0]+v2[0]*r1, P[1]+v2[1]*r1}, {Q[0]+u2[0]*r2, Q[1]+u2[1]*r2}});
		}
		return res;
	}
	
	int n;
	double[] x, y, r, m;
	
	int cnt(double[][] line){
		int res = 0;
		for(int i=0;i<n;i++){
			double d = distLP(line[0], line[1], new double[]{x[i], y[i]});
			if(r[i] < d+EPS && d < r[i]+m[i]+EPS)res++;
		}
		return res;
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		x = new double[50]; y = new double[50]; r = new double[50]; m = new double[50];
		for(;;){
			n = sc.nextInt();
			if(n==0)break;
			for(int i=0;i<n;i++){
				x[i] = sc.nextDouble();
				y[i] = sc.nextDouble();
				r[i] = sc.nextDouble();
				m[i] = sc.nextDouble();
			}
			if(n==1){
				System.out.println(1); continue;
			}
			int res = 0;
			for(int i=0;i<n;i++)for(int j=i+1;j<n;j++){
				List<double[][]> lines;
				lines = circleTangentialLine(x[i], y[i], r[i], x[j], y[j], r[j]);
				for(double[][] d:lines)res = Math.max(res, cnt(d));
				lines = circleTangentialLine(x[i], y[i], r[i], x[j], y[j], r[j]+m[j]);
				for(double[][] d:lines)res = Math.max(res, cnt(d));
				lines = circleTangentialLine(x[i], y[i], r[i]+m[i], x[j], y[j], r[j]);
				for(double[][] d:lines)res = Math.max(res, cnt(d));
				lines = circleTangentialLine(x[i], y[i], r[i]+m[i], x[j], y[j], r[j]+m[j]);
				for(double[][] d:lines)res = Math.max(res, cnt(d));
			}
			System.out.println(res);
		}
	}
	
	public static void main(String[] args) {
		new AOJ2201().run();
	}
}
