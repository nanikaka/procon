package volume23;

import java.util.Scanner;

//Sleeping Time
public class AOJ2301 {

	int K, R, L;
	double P, E, T;
	double ans = 0;
	double EPS = 1e-12;
	
	void dfs(double l, double r, double p, int k){
		if(l+EPS>T+E||r<T-E+EPS)return;
		if(T-E<l+EPS&&r<T+E+EPS){
			ans += p;
			return;
		}
		double h = (l+r)/2;
		if(k==K){
			if(T-E<h+EPS&&h<T+E+EPS)ans+=p;
			return;
		}
		if(h+EPS>T){
			dfs(l, h, p*(1-P), k+1);
			dfs(h, r, p*P, k+1);
		}
		else{
			dfs(h, r, p*(1-P), k+1);
			dfs(l, h, p*P, k+1);
		}
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		R = sc.nextInt();
		L = sc.nextInt();
		P = sc.nextDouble();
		E = sc.nextDouble();
		T = sc.nextDouble();
		dfs(R, L, 1.0, 0);
		System.out.printf("%.7f\n", ans);
	}
	
	public static void main(String[] args) {
		new AOJ2301().run();
	}
}
