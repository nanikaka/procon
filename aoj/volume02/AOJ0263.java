package volume02;

import java.util.Arrays;
import java.util.Scanner;

//Beat Panel
public class AOJ0263 {

	void run(){
		Scanner sc = new Scanner(System.in);
		int[][] dp = new int[2][1<<16];
		for(;;){
			int n = sc.nextInt(), c = sc.nextInt();
			if(n+c==0)break;
			int[] a = new int[n], b = new int[c];
			for(int i=0;i<n;i++)for(int j=0;j<16;j++)a[i] = (a[i]<<1) + sc.nextInt();
			for(int i=0;i<c;i++)for(int j=0;j<16;j++)b[i] = (b[i]<<1) + sc.nextInt();
			Arrays.fill(dp[0], -1);
			dp[0][0] = 0;
			int X = 1;
			for(int i=0;i<n;i++,X=1-X){
				Arrays.fill(dp[X], -1);
				for(int S=0;S<1<<16;S++)if(dp[1-X][S]!=-1){
					int light = S|a[i];
					for(int j=0;j<c;j++){
						int pushed = light & b[j];
						int point = Integer.bitCount(pushed);
						int nx = light & ~pushed;
						dp[X][nx] = Math.max(dp[X][nx], dp[1-X][S] + point);
					}
				}
			}
			int res = 0;
			for(int S=0;S<1<<16;S++)res = Math.max(res, dp[1-X][S]);
			System.out.println(res);
		}
	}
	
	public static void main(String[] args) {
		new AOJ0263().run();
	}
}
