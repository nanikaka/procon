package volume10;

import java.util.Scanner;

//Finding the Largest Carbon Compound Given Its Longest Chain
public class AOJ1011 {

	void run(){
		Scanner sc = new Scanner(System.in);
		int[] dp = new int[31];
		dp[1] = 1;
		dp[2] = 2;
		int sum = 0;
		for(int i=3;i<=30;i+=2){
			sum+=Math.pow(3, (i-3)/2);
			dp[i] = 1+4*sum;
		}
		sum = 0;
		for(int i=4;i<=30;i+=2){
			sum+=Math.pow(3, (i-4)/2);
			dp[i] = 2+6*sum;
		}
		while(sc.hasNext())System.out.println(dp[sc.nextInt()]);
	}
	
	public static void main(String[] args) {
		new AOJ1011().run();
	}
}
