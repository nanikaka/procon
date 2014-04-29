package volume12;

import java.util.PriorityQueue;
import java.util.Scanner;

//Mobile Phone Coverage
public class AOJ1202 {

	void run(){
		Scanner sc = new Scanner(System.in);
		double EPS = 1e-8;
		int T = 1;
		for(;;){
			int n = sc.nextInt();
			if(n==0)break;
			double[][] p = new double[n][3];
			PriorityQueue<Double> qx = new PriorityQueue<Double>();
			PriorityQueue<Double> qy = new PriorityQueue<Double>();
			for(int i=0;i<n;i++){
				double x = sc.nextDouble();
				double y = sc.nextDouble();
				double r = sc.nextDouble();
				if(!qx.contains(x-r))qx.add(x-r);
				if(!qy.contains(y-r))qy.add(y-r);
				if(!qx.contains(x+r))qx.add(x+r);
				if(!qy.contains(y+r))qy.add(y+r);
				p[i][0] = x; p[i][1] = y; p[i][2] = r;
			}
			double[] x = new double[qx.size()];
			double[] y = new double[qy.size()];
			int id = 0;
			while(!qx.isEmpty())x[id++]=qx.poll();
			id = 0;
			while(!qy.isEmpty())y[id++]=qy.poll();
			double ans = 0;
			for(int i=0;i<x.length-1;i++)for(int j=0;j<y.length-1;j++){
				for(int k=0;k<n;k++){
					double lx = p[k][0]-p[k][2];
					double rx = p[k][0]+p[k][2];
					double dy = p[k][1]-p[k][2];
					double uy = p[k][1]+p[k][2];
					if(lx<x[i]+EPS&&x[i+1]<rx+EPS&&dy<y[j]+EPS&&y[j+1]<uy+EPS){
						ans += (x[i+1]-x[i])*(y[j+1]-y[j]);
						break;
					}
				}
			}
			System.out.printf("%d %.2f\n", T++, ans);
		}
	}
	
	public static void main(String[] args) {
		new AOJ1202().run();
	}
}
