package volume22;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//The Number of the Real Roots of a Cubic Equation
public class AOJ2220 {

	int a, b, c, d;
	double EPS = 1e-8;
	List<Double> ans;
	
	double f(double x){
		return a*x*x*x + b*x*x + c*x + d;
	}
	double df(double x){
		return 3*a*x*x + 2*b*x + c;
	}
	void bs(double L, double R, boolean up){
		if(f(L)==0){
			ans.add(L); return;
		}
		if(f(R)==0){
			ans.add(R); return;
		}
		if(L <= 0 && 0 <= R && f(0)==0)return;
		while(R-L > 1e-12){
			double M = (L+R)/2;
			if(0 < f(M)){
				if(up)R=M;
				else L=M;
			}
			else if(f(M) < 0){
				if(up)L=M;
				else R=M;
			}
			else{
				ans.add(M); return;
			}
		}
		if(Math.abs(f(L)) < EPS)ans.add(L);
	}

	void run(){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int INF = 1000000;
		while(T--!=0){
			a = sc.nextInt(); b = sc.nextInt(); c = sc.nextInt(); d = sc.nextInt();
			int D = b*b-3*a*c, rm = 0, rp = 0;
			ans = new ArrayList<Double>();
			if(0 <= D){
				double x0 = (-b-Math.sqrt(D))/3/a, x1 = (-b+Math.sqrt(D))/3/a;
				if(x1 < x0){
					double tmp = x1;
					x1 = x0;
					x0 = tmp;
				}
				bs(-INF, x0, 0 < df((x0-INF)/2));
				bs(x0, x1, 0 < df((x0+x1)/2));
				bs(x1, INF, 0 < df((x1+INF)/2));
			}
			else{
				bs(-INF, INF, 0 < df(0));
			}
			for(double d:ans){
				if(d == 0)continue;
				if(0 < d)rp++;
				else rm++;
			}
			System.out.println(rp+" "+rm);
		}
	}

	public static void main(String[] args) {
		new AOJ2220().run();
	}
}
