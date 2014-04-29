package volume12;

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.Math.*;

//Telescope
public class AOJ1222 {

	int n, m, INF = 1<<29, s;
	double[] p;
	double[][] dp;
	
	double area(int i, int j){
		return sin((p[j]-p[i])*2*PI)/2;
	}
	
	double get(int j, int k){
		if(j==m-1)return area(k, s);
		if(dp[j][k]!=-INF)return dp[j][k];
		double max = -INF;
		for(int i=k+1;i<n;i++)max=max(max, area(k, i)+get(j+1, i));
		return dp[j][k] = max;
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			n = sc.nextInt(); m = sc.nextInt();
			if((n|m)==0)break;
			p = new double[n];
			for(int i=0;i<n;i++)p[i] = sc.nextDouble();
			double max = 0;
			for(int i=0;i<n;i++){
				dp = new double[m][n];
				for(double[]a:dp)Arrays.fill(a, -INF);
				s = i;
				max = max(max, get(0, s));
			}
			System.out.printf("%.6f\n", max);
		}
	}
	
	public static void main(String[] args) {
		new AOJ1222().run();
	}
}
