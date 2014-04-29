package volume21;

import java.util.Arrays;
import java.util.Scanner;

//Differential Pulse Code Modulation
public class AOJ2199 {

	void run(){
		Scanner sc = new Scanner(System.in);
		int INF = 255*255*20000;
		for(;;){
			int n = sc.nextInt(), m = sc.nextInt();
			if((n|m)==0)break;
			int[] x = new int[n], c = new int[m];
			for(int i=0;i<m;i++)c[i]=sc.nextInt();
			for(int i=0;i<n;i++)x[i]=sc.nextInt();
			int[] dp = new int[256];
			Arrays.fill(dp, INF);
			dp[128] = 0;
			for(int i=0;i<n;i++){
				int[] next = new int[256];
				Arrays.fill(next, INF);
				for(int y=0;y<256;y++){
					if(dp[y]==INF)continue;
					for(int j=0;j<m;j++){
						int nx = y+c[j];
						if(nx<0)nx=0;
						if(255<nx)nx=255;
						int v = dp[y]+(x[i]-nx)*(x[i]-nx);
						next[nx] = Math.min(next[nx], v);
					}
				}
				dp = next;
			}
			int res = INF;
			for(int i=0;i<256;i++)res = Math.min(res, dp[i]);
			System.out.println(res);
		}
	}
	
	public static void main(String[] args) {
		new AOJ2199().run();
	}
}
