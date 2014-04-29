package volume12;

import java.util.Scanner;

//How I Wonder What You Are!
public class AOJ1266 {

	double dot(double[] a, double[] b){
		return a[0]*b[0]+a[1]*b[1]+a[2]*b[2];
	}
	double norm(double[] a){
		return Math.sqrt(a[0]*a[0]+a[1]*a[1]+a[2]*a[2]);
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			int n = sc.nextInt();
			if(n==0)break;
			double[][] p = new double[n][3];
			for(int i=0;i<n;i++)for(int j=0;j<3;j++)p[i][j]=sc.nextDouble();
			int m = sc.nextInt();
			boolean[] u = new boolean[n];
			while(m--!=0){
				double[] t = new double[3];
				for(int i=0;i<3;i++)t[i]=sc.nextDouble();
				double phi = sc.nextDouble();
				for(int i=0;i<n;i++){
					if(u[i])continue;
					double w = Math.acos(dot(p[i], t)/norm(p[i])/norm(t));
					if(w<phi+1e-8)u[i]=true;
				}
			}
			int res = 0;
			for(boolean f:u)if(f)res++;
			System.out.println(res);
		}
	}
	
	public static void main(String[] args) {
		new AOJ1266().run();
	}
}
