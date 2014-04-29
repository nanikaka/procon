package volume20;

import java.util.Scanner;

//Gather the Maps!
public class AOJ2011 {

	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			int n = sc.nextInt();
			if(n==0)break;
			boolean[][] f = new boolean[n][31];
			for(int i=0;i<n;i++){
				int k = sc.nextInt();
				while(k--!=0)f[i][sc.nextInt()] = true;
			}
			long[][] dp = new long[n][31];
			for(int i=0;i<n;i++)dp[i][0] = 1L << i;
			int res = -1;
			for(int j=1;j<=30;j++){
				if(res!=-1)break;
				for(int i=0;i<n;i++){
					if(!f[i][j]){
						dp[i][j] = dp[i][j-1]; continue;
					}
					for(int k=0;k<n;k++){
						if(!f[k][j])continue;
						dp[i][j]|=dp[k][j-1];
					}
					if(dp[i][j]==(1L<<n)-1){
						res = j; break;
					}
				}
			}
			System.out.println(res);
		}
	}
	
	public static void main(String[] args) {
		new AOJ2011().run();
	}
}
