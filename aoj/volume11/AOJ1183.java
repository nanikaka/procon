package volume11;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

//Chain-Confined Path
public class AOJ1183 {

	final double EPS = 1e-8;
	
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
	double[][] circleCrossPoint(double x1, double y1, double r1, double x2, double y2, double r2){
		double vx = x2-x1, vy = y2-y1, D = Math.sqrt(vx*vx+vy*vy);
		vx/=D; vy/=D;
		vx*=r1; vy*=r1;
		double thita = Math.acos((r1*r1+D*D-r2*r2)/(2*r1*D));
		double px = Math.cos(thita)*vx-Math.sin(thita)*vy, py = Math.sin(thita)*vx+Math.cos(thita)*vy;
		double px2 = Math.cos(-thita)*vx-Math.sin(-thita)*vy, py2 = Math.sin(-thita)*vx+Math.cos(-thita)*vy;
		double[][] res = new double[2][2];
		res[0][0] = x1+px; res[0][1] = y1+py;
		res[1][0] = x1+px2; res[1][1] = y1+py2;
		return res;
	}
	
	int INF = 1<<29;
	double[][] dist;
	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			int n = sc.nextInt();
			if(n==0)break;
			double[] cx = new double[n], cy = new double[n], r = new double[n];
			for(int i=0;i<n;i++){
				cx[i] = sc.nextDouble(); cy[i] = sc.nextDouble(); r[i] = sc.nextDouble();
			}
			double[][] x = new double[n+1][2], y = new double[n+1][2];
			x[0][0] = x[0][1] = cx[0];
			y[0][0] = y[0][1] = cy[0];
			x[n][0] = x[n][1] = cx[n-1];
			y[n][0] = y[n][1] = cy[n-1];
			for(int i=0;i+1<n;i++){
				double[][] p = circleCrossPoint(cx[i], cy[i], r[i], cx[i+1], cy[i+1], r[i+1]);
				x[i+1][0] = p[0][0]; y[i+1][0] = p[0][1];
				x[i+1][1] = p[1][0]; y[i+1][1] = p[1][1];
			}
			double[][][][] adj = new double[n+1][2][n+1][2];
			for(int i=0;i<=n;i++)for(int j=0;j<2;j++)for(int k=0;k<=n;k++)for(int l=0;l<2;l++)adj[i][j][k][l] = INF;
			for(int i=0;i<=n;i++)for(int j=0;j<2;j++)for(int k=i+1;k<=n;k++)for(int l=0;l<2;l++){
				boolean ok = true;
				double[] A = new double[]{x[i][j], y[i][j]}, B = new double[]{x[k][l], y[k][l]};
				for(int m=i+1;m<k;m++){
					if(ex(A, B, new double[]{x[m][0], y[m][0]}) * ex(A, B, new double[]{x[m][1], y[m][1]}) > -EPS)ok = false;
				}
				if(ok)adj[i][j][k][l] = norm(A, B);
			}
			dist = new double[n+1][2];
			for(double[]d:dist)Arrays.fill(d, INF);
			dist[0][0] = dist[0][1] = 0;
			PriorityQueue<int[]> q = new PriorityQueue<int[]>(n, new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
					return (int)Math.signum(dist[o1[0]][o1[1]] - dist[o2[0]][o2[1]]);
				}
			});
			q.add(new int[]{0, 0});
			while(!q.isEmpty()){
				int[] V = q.poll();
				int i = V[0], j = V[1];
				for(int k=i+1;k<=n;k++)for(int l=0;l<2;l++){
					double w = dist[i][j] + adj[i][j][k][l];
					if(w < dist[k][l]){
						dist[k][l] = w; q.add(new int[]{k, l});
					}
				}
			}
			System.out.printf("%.8f\n", dist[n][0]);
		}
	}
	
	public static void main(String[] args) {
		new AOJ1183().run();
	}
}
