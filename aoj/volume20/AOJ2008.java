package volume20;

import java.util.Scanner;

//Dragon Fantasy
public class AOJ2008 {

	int n, hx, hy, dx, dy;
	int[][] p;
	double[] r;
	double[][] d;
	double EPS = 1e-8;
	
	boolean dfs(int k, int S, double t){
		if(S==(1<<n)-1)return true;
		for(int i=0;i<n;i++){
			if(((S>>i)&1)>0)continue;
			if(r[i]<t+d[k][i]+EPS)return false;
		}
		for(int i=0;i<n;i++){
			if(((S>>i)&1)>0)continue;
			if(r[i]>t+d[k][i]){
				if(dfs(i, S+(1<<i), t+d[k][i]))return true;
			}
		}
		return false;
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			n = sc.nextInt(); hx = sc.nextInt(); hy = sc.nextInt(); dx = sc.nextInt(); dy = sc.nextInt();
			if((n|hx|hy|dx|dy)==0)break;
			p = new int[n][2];
			for(int i=0;i<n;i++)for(int j=0;j<2;j++)p[i][j]=sc.nextInt();
			r = new double[n];
			for(int i=0;i<n;i++)r[i]=Math.hypot(p[i][0]-dx, p[i][1]-dy);
			d = new double[n+1][n+1];
			for(int i=0;i<n;i++){
				d[n][i] = d[i][n] = Math.hypot(hx-p[i][0], hy-p[i][1]);
				for(int j=i+1;j<n;j++)d[i][j] = d[j][i] = Math.hypot(p[i][0]-p[j][0], p[i][1]-p[j][1]);
			}
			System.out.println(dfs(n, 0, 0)?"YES":"NO");
		}
	}
	
	public static void main(String[] args) {
		new AOJ2008().run();
	}
}
