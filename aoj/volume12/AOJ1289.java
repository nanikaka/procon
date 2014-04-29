package volume12;

import java.util.Scanner;

//Spherical Mirrors
public class AOJ1289 {

	double dot(double[] a, double[] b){
		double r = 0;
		for (int i = 0; i < a.length; i++) {
			r += a[i]*b[i];
		}
		return r;
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			double[] s = {0, 0, 0};
			double u = sc.nextDouble();
			double v = sc.nextDouble();
			double w = sc.nextDouble();
			double[] p = {u, v, w};
			double[][] c = new double[n][4];
			for(int i=0;i<n;i++)for(int j=0;j<4;j++)c[i][j]=sc.nextDouble();
			while(true){
				double min = 1<<20;
				int id = -1;
				for(int i=0;i<n;i++){
					double a = dot(p, p);
					double[] cs = {s[0]-c[i][0], s[1]-c[i][1], s[2]-c[i][2]};
					double b = 2*dot(p, cs);
					double C = dot(cs, cs)-c[i][3]*c[i][3];
					double D = b*b-4*a*C;
					if(D<0)continue;
					double t = (-b-Math.sqrt(D))/(2*a);
					if(t<0)continue;
					if(t<min){
						min = t;
						id = i;
					}
				}
				if(min==1<<20)break;
				s[0] += min*p[0];
				s[1] += min*p[1];
				s[2] += min*p[2];
				double pnorm = Math.sqrt(p[0]*p[0]+p[1]*p[1]+p[2]*p[2]);
				double nnorm = Math.sqrt(Math.pow(s[0]-c[id][0], 2)+Math.pow(s[1]-c[id][1], 2)+Math.pow(s[2]-c[id][2], 2));
				double[] a = {-p[0]/pnorm, -p[1]/pnorm, -p[2]/pnorm};
				double[] N = {(s[0]-c[id][0])/nnorm, (s[1]-c[id][1])/nnorm, (s[2]-c[id][2])/nnorm};
				double an = 2*dot(a, N);
				double[] b = {an*N[0]-a[0], an*N[1]-a[1], an*N[2]-a[2]};
				p = b;
			}
			System.out.printf("%.4f %.4f %.4f\n", s[0], s[1], s[2]);
		}
	}
	
	public static void main(String[] args) {
		new AOJ1289().run();
	}
}
