package volume23;

import java.util.Scanner;

//Unequal Dice
public class AOJ2363 {

	void run(){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		double e = 0;
		while(t--!=0){
			sc.next();
			int m = sc.nextInt();
			double[][] a = new double[m][2];
			double r = 0;
			for(int i=0;i<m;i++){
				a[i][0] = sc.nextDouble(); a[i][1] = sc.nextDouble();
				r+=a[i][1];
			}
			double p = 0;
			for(int i=0;i<m;i++)p+=a[i][0]*a[i][1]/r;
			e = Math.max(e, p);
		}
		sc.nextInt();
		int q = sc.nextInt();
		double x = 0, r = 0;
		double[][] a = new double[q][2];
		for(int i=0;i<q;i++){
			a[i][0] = sc.nextDouble(); a[i][1] = sc.nextDouble();
			r+=a[i][1];
		}
		for(int i=0;i<q;i++)x+=a[i][0]*a[i][1]/r;
		System.out.println(x+1e-7<e?"YES":"NO");
	}
	
	public static void main(String[] args) {
		new AOJ2363().run();
	}
}
