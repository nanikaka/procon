package volume10;

import java.util.Scanner;

//Ben Toh
public class AOJ1056 {
	
	void run(){
		double EPS = 1e-13;
		double[] res = new double[100001];
		res[1] = 1;
		for(int n=2;n<=100000;n++){
			double p = 1, win = 0.5;
			int k = 1;
			while(EPS<p && k<n){
				double not = p*(1-win);
				res[n] += not*(k+res[Math.max(0, n-k-1)]);
				p*=win; win/=2; k++;
			}
			res[n]+=n*p;
		}
		Scanner sc = new Scanner(System.in);
		for(;;){
			int n = sc.nextInt();
			if(n==0)break;
			System.out.printf("%.8f\n", res[n]);
		}
	}
	
	public static void main(String[] args) {
		new AOJ1056().run();
	}
}
