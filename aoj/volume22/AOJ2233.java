package volume22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//Carrot Tour
public class AOJ2233 {

	double norm(double[] a){
		return Math.hypot(a[0], a[1]);
	}
	double dot(double[] a, double[] b){
		return a[0]*b[0]+a[1]*b[1];
	}
	double cross(double[] a, double[] b){
		return a[0]*b[1]-a[1]*b[0];
	}
	double angleCos(double[] a, double[] b){
		double na = norm(a), nb = norm(b);
		return Math.acos(dot(a, b)/na/nb);
	}
	double[] sub(double[] a, double[] b){
		return new double[]{a[0]-b[0], a[1]-b[1]};
	}
	double EPS = 1e-10;
	int INF = 1<<29;
	
	@SuppressWarnings("unchecked")
	void run(){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		double R = sc.nextDouble(), thita = sc.nextDouble()*Math.PI/180;
		double[][] p = new double[n][2];
		for(int i=0;i<n;i++)for(int j=0;j<2;j++)p[i][j]=sc.nextDouble();
		double[][] d = new double[n][n];
		for(int i=0;i<n;i++)for(int j=0;j<n;j++)d[i][j]=Math.hypot(p[i][0]-p[j][0], p[i][1]-p[j][1]);
		List<Integer>[][] l = new List[n][n];
		for(int i=0;i<n;i++)for(int j=0;j<n;j++){
			l[i][j] = new ArrayList<Integer>();
			if(i==j)continue;
			for(int k=0;k<n;k++){
				if(k==i)continue;
				double t = angleCos(sub(p[k], p[i]), sub(p[i], p[j]));
				if(t<thita+EPS)l[i][j].add(k);
			}
		}
		double[][] dp = new double[n][n];
		for(double[]a:dp)Arrays.fill(a, INF);
		int res = 0;
		boolean f = false;
		for(int k=1;k<n;k++)if(d[0][k]<R+EPS){
			f = true; dp[k][0] = d[0][k];
		}
		while(f){
			res++;
			f = false;
			double[][] next = new double[n][n];
			for(double[]a:next)Arrays.fill(a, INF);
			for(int i=0;i<n;i++)for(int j=0;j<n;j++){
				if(i==j||dp[i][j]==INF)continue;
				for(int k:l[i][j]){
					if(dp[i][j]+d[i][k]<R+EPS){
						next[k][i] = Math.min(next[k][i], dp[i][j]+d[i][k]); f = true;
					}
				}
			}
			dp = next;
		}
		System.out.println(res);
	}
	
	public static void main(String[] args) {
		new AOJ2233().run();
	}
}
