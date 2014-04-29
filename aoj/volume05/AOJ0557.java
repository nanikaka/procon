package volume05;

import java.util.Scanner;

//A First Grader
public class AOJ0557 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;i++)a[i]=sc.nextInt();
		long[][] dp = new long[n-1][21];
		dp[0][a[0]] = 1;
		for(int i=1;i<n-1;i++){
			for(int p=0;p<=20;p++){
				long sum = 0;
				if(0<=p-a[i]&&p-a[i]<=20)sum+=dp[i-1][p-a[i]];
				if(0<=p+a[i]&&p+a[i]<=20)sum+=dp[i-1][p+a[i]];
				dp[i][p] = sum;
			}
		}
		System.out.println(dp[n-2][a[n-1]]);
	}
}
