package volume01;

import java.util.Arrays;
import java.util.Scanner;

//Collatz's Problem
public class AOJ0158 {

	static int[] dp;

	static int f(int n){
		if(dp[n]!=-1)return dp[n];
		if(n%2==0)return dp[n] = f(n/2)+1;
		else return dp[n] = f(n*3+1)+1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		dp = new int[1000001];
		Arrays.fill(dp, -1);
		dp[1] = 0;
		while(true){
			int x = sc.nextInt();
			if(x==0)break;
			System.out.println(f(x));
		}
	}
}
