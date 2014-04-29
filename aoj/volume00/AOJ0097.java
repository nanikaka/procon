package volume0;

import java.util.Scanner;

//Sum of Integers II
public class AOJ0097 {

	void run(){
		Scanner sc = new Scanner(System.in);
		long[] dp = new long[2001];
		for(int i=0;i<=1000;i++)for(int j=0;j<=1000;j++)dp[i+j]++;
		while(sc.hasNext()){
			int N = sc.nextInt();
			long res = 0;
			for(int s=0;s<=2000;s++)if(0 <= N-s && N-s <= 2000)res+=dp[s]*dp[N-s];
			System.out.println(res);
		}
	}
	
	public static void main(String[] args) {
		new AOJ0097().run();
	}
}
