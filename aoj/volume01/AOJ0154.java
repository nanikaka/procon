package volume01;

import java.util.Scanner;

//Sum of Cards
public class AOJ0154 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int m = sc.nextInt();
			if(m==0)break;
			int[] v = new int[m+1];
			int[] num = new int[m+1];
			for(int i=1;i<=m;i++){
				v[i] = sc.nextInt();
				num[i] = sc.nextInt();
			}
			int[][] dp = new int[m+1][1001];
			dp[0][0] = 1;
			for(int i=1;i<=m;i++){
				for(int k=0;k<1001;k++){
					for(int s=0;s<=num[i];s++){
						if(k-v[i]*s<0)break;
						dp[i][k] += dp[i-1][k-s*v[i]];
					}
				}
			}
			int g = sc.nextInt();
			while(g--!=0)System.out.println(dp[m][sc.nextInt()]);
		}
	}
}
