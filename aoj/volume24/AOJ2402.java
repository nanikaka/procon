package volume24;

import java.util.Scanner;

//Milky Way
public class AOJ2402 {

	final double EPS = 1e-10;
	
	double dot(double[] a, double[] b){
		return a[0]*b[0]+a[1]*b[1];
	}
	double cross(double[] a, double[] b){
		return a[0]*b[1]-a[1]*b[0];
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
	boolean crossing(double[] a, double[] b, double[] s, double[] t){
		if(Math.abs(cross(sub(b, a), sub(t, s)))<EPS){
			return Math.min(dist(a, b, s), Math.min(dist(a, b, t), Math.min(dist(s, t, a), dist(s, t, b))))<EPS;
		}
		if(ex(a, b, s)*ex(a, b, t)>0)return false;
		if(ex(b, a, s)*ex(b, a, t)>0)return false;
		if(ex(s, t, a)*ex(s, t, b)>0)return false;
		return ex(t, s, a)*ex(t, s, b)<EPS;
	}
	double dist(double[] a, double[] b, double[] p){
		if(dot(sub(b, a), sub(p, a))<EPS)return norm(a, p);
		if(dot(sub(a, b), sub(p, b))<EPS)return norm(b, p);
		return Math.abs(cross(sub(b, a), sub(p, a)))/norm(a, b);
	}
	double dist(double[] a, double[] b, double[] s, double[] t){
		if(crossing(a, b, s, t))return 0;
		return Math.min(dist(a, b, s), Math.min(dist(a, b, t), Math.min(dist(s, t, a), dist(s, t, b))));
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		int[][] seg = {{0, 2},{0, 3},{1, 4},{1, 3},{2, 4}};
		for(;;){
			int n = sc.nextInt(), S = sc.nextInt(), T = sc.nextInt();
			if((n|S|T)==0)break;
			S--; T--;
			double[] cx = new double[n], cy = new double[n], a = new double[n], r = new double[n];
			for(int i=0;i<n;i++){
				cx[i] = sc.nextDouble(); cy[i] = sc.nextDouble(); a[i] = sc.nextDouble(); r[i] = sc.nextDouble();
			}
			double[][][] p = new double[n][5][2];
			for(int i=0;i<n;i++){
				for(int k=0;k<5;k++){
					double x = -Math.sin((a[i]+72*k)*Math.PI/180)*r[i], y = Math.cos((a[i]+72*k)*Math.PI/180)*r[i];
					p[i][k][0] = cx[i]+x; p[i][k][1] = cy[i]+y;
				}
			}
			double[][] wf = new double[n][n];
			for(int i=0;i<n;i++)for(int j=0;j<n;j++)wf[i][j]=1<<29;
			for(int i=0;i<n;i++)wf[i][i]=0;
			for(int i=0;i<n;i++)for(int j=i+1;j<n;j++){
				double min = 1<<29;
				for(int k=0;k<5;k++){
					double[] A = p[i][seg[k][0]], B = p[i][seg[k][1]];
					for(int m=0;m<5;m++){
						double[] C = p[j][seg[m][0]], D = p[j][seg[m][1]];
						min = Math.min(min, dist(A, B, C, D));
					}
				}
				wf[i][j] = wf[j][i] = min;
			}
			for(int k=0;k<n;k++)for(int i=0;i<n;i++)for(int j=0;j<n;j++)wf[i][j]=Math.min(wf[i][j], wf[i][k]+wf[k][j]);
			System.out.printf("%.10f\n", wf[S][T]);
		}
	}
	
	public static void main(String[] args) {
		new AOJ2402().run();
	}
}
