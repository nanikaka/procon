package volume21;

import java.util.Arrays;
import java.util.Scanner;

//Adaptive Time Slicing Quantization
public class AOJ2143 {

	int n, M, L, INF = 1<<29;
	double res;
	double[] a;
	double[][] dp;
	
	double bs(double min, double max, double x){
		int l = 1, r = 1<<L;
		while(r-l>1){
			int m = (l+r)/2;
			double v = min+(m-1)*(max-min)/((1<<L)-1);
			if(v<x)l=m;
			else r=m;
		}
		double lv = min+(l-1)*(max-min)/((1<<L)-1), rv = min+(r-1)*(max-min)/((1<<L)-1);
		return Math.abs(x-lv)<Math.abs(x-rv)?lv:rv;
	}
	
	double get(int k, int m){
		if(n==k){
			return m==0?0:INF;
		}
		if(m<0)return INF;
		if(dp[k][m]!=-1)return dp[k][m];
		if(n<=k+1)return INF;
		double min = a[k], max = a[k], res = INF;
		for(int i=k+1;i<n;i++){
			min = Math.min(min, a[i]); max = Math.max(max, a[i]);
			if(n<i+1+2*(m-1))break;
			double e = 0;
			for(int j=k;j<=i;j++){
				double s = bs(min, max, a[j]);
				e += (s-a[j])*(s-a[j]);
			}
			res = Math.min(res, e+get(i+1, m-1));
		}
		return dp[k][m] = res;
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			n = sc.nextInt(); M = sc.nextInt(); L = sc.nextInt();
			if((n|M|L)==0)break;
			a = new double[n];
			for(int i=0;i<n;i++)a[i]=sc.nextDouble();
			dp = new double[n][M+1];
			for(double[]d:dp)Arrays.fill(d, -1);
			System.out.printf("%.8f\n", get(0, M));
		}
	}
	
	public static void main(String[] args) {
		new AOJ2143().run();
	}
}
