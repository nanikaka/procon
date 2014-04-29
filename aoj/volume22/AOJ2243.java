package volume22;

import java.util.Scanner;

//Step Step Evolution
public class AOJ2243 {

	void run(){
		int[] pos = {0,0,1,2,0,0,2,0,1,2};
		Scanner sc = new Scanner(System.in);
		while(true){
			char[] s = sc.next().toCharArray();
			if(s[0]=='#')break;
			int n = s.length;
			int[][][][] dp = new int[n+1][3][3][2];
			for(int i=0;i<=n;i++)for(int j=0;j<3;j++)for(int k=0;k<3;k++)for(int l=0;l<2;l++)dp[i][j][k][l]=1<<28;
			for(int i=0;i<3;i++){
				for(int j=0;j<3;j++){
					for(int k=0;k<2;k++){
						dp[0][i][j][k] = i<=j?0:1<<28;
					}
				}
			}
			for(int i=0;i<n;i++){
				int p = pos[s[i]-'0'];
				for(int j=0;j<3;j++){
					for(int k=0;k<3;k++){
						for(int l=0;l<2;l++){
							if(l==0){
								if(p<=k){
									dp[i+1][p][k][1] = Math.min(dp[i+1][p][k][1], dp[i][j][k][l]);
								}
								if(j<=p){
									dp[i+1][j][p][0] = Math.min(dp[i+1][j][p][l], dp[i][j][k][l]+1);
								}
							}
							else {
								if(j<=p){
									dp[i+1][j][p][0] = Math.min(dp[i+1][j][p][0], dp[i][j][k][l]);
								}
								if(p<=k){
									dp[i+1][p][k][1] = Math.min(dp[i+1][p][k][1], dp[i][j][k][l]+1);
								}
							}
						}
					}
				}
			}
			int min = 1<<28;
			for(int i=0;i<3;i++)for(int j=0;j<3;j++)for(int k=0;k<2;k++)min=Math.min(min, dp[n][i][j][k]);
			System.out.println(min);
		}
	}
	
	public static void main(String[] args) {
		new AOJ2243().run();
	}
}
