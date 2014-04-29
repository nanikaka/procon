package volume11;

import java.util.Arrays;
import java.util.Scanner;

//Pollock's conjecture
public class AOJ1167 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] p = new int[181];
		for(int i=1;i<181;i++){
			p[i] = (i*(i+1)*(i+2))/6;
		}
		int[] dp = new int[1000000+1];
		int[] dp2 = new int[1000000+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		Arrays.fill(dp2, Integer.MAX_VALUE);
		dp[0] = 0;
		dp2[0] = 0;
		for(int i=1;i<=1000000;i++){
			for(int j=1;j<181;j++){
				if(i-p[j]>=0){
					dp[i] = Math.min(dp[i], dp[i-p[j]]+1);
					if(p[j]%2==1){
						dp2[i] = Math.min(dp2[i], dp2[i-p[j]]+1);
					}
				}
			}
		}
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			System.out.println(dp[n]+" "+dp2[n]);
		}
	}
}
