package volume22;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

///Rectangular Stamps
public class AOJ2297 {

	void run(){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] h = new int[n], w = new int[n];
		for(int i=0;i<n;i++){
			h[i] = sc.nextInt(); w[i] = sc.nextInt();
		}
		int[][] a = new int[4][4];
		for(int i=0;i<4;i++){
			char[] c = sc.next().toCharArray();
			for(int j=0;j<4;j++)a[i][j] = c[j]=='R'?0:c[j]=='G'?1:2;
		}
		int[] d = new int[1<<16];
		int INF = 1<<29;
		Arrays.fill(d, INF);
		d[65535] = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(65535);
		while(!q.isEmpty()){
			int S = q.poll();
			if(S==0){
				System.out.println(d[S]); break;
			}
			for(int k=0;k<n;k++){
				for(int i=-3;i<=3;i++)for(int j=-3;j<=3;j++){
					int cov = 0, app = 0;
					for(int y=0;y<h[k];y++)for(int x=0;x<w[k];x++){
						if(0<=i+y&&i+y<4&&0<=j+x&&j+x<4){
							int p = (i+y)*4+j+x;
							if(((S>>p)&1)==0)continue;
							app|=1<<a[i+y][j+x];
							cov+=1<<p;
						}
					}
					if(app==1||app==2||app==4){
						int ns = S&~cov;
						if(d[ns]==INF){
							d[ns] = d[S]+1; q.add(ns);
						}
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new AOJ2297().run();
	}
}
