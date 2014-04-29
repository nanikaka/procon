package volume23;

import java.util.Arrays;
import java.util.Scanner;

//Butterfly
public class AOJ2321 {

	int n;
	int[] d, s, dp;
	
	int get(int S){
		if(dp[S]!=-1)return dp[S];
		int max = 0;
		for(int i=0;i<n;i++){
			if((S&d[i])==d[i]){
				max = Math.max(max, s[i]+get(S-d[i]));
			}
		}
		return dp[S] = max;
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			n = sc.nextInt();
			if(n==0)break;
			d = new int[n]; s = new int[n];
			for(int i=0;i<n;i++){
				int k = sc.nextInt();
				s[i] = sc.nextInt();
				while(k--!=0){
					int S = sc.nextInt()-6, E = sc.nextInt()-6;
					for(int j=S;j<E;j++)d[i]+=1<<j;
				}
			}
			dp = new int[1<<16];
			Arrays.fill(dp, -1);
			System.out.println(get((1<<16)-1));
		}
	}
	
	public static void main(String[] args) {
		new AOJ2321().run();
	}
}
