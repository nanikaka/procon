package volume12;

import java.util.Arrays;
import java.util.Scanner;

//Sum of Different Primes
public class AOJ1269 {

	int N = 1120, num;
	int[] p;
	int[][][] dp;
	
	int get(int x, int index, int rest){
		if(rest==0){
			if(x==0)return dp[x][index][rest] = 1;
			else return dp[x][index][rest] = 0;
		}
		if(dp[x][index][rest]!=-1)return dp[x][index][rest];
		int res = 0;
		for(int i=index;i<num;i++){
			if(x<p[i])break;
			res += get(x-p[i], i+1, rest-1);
		}
		return dp[x][index][rest] = res;
	}
	
	void run(){
		num = 0;
		p = new int[187];
		boolean[] prime = new boolean[N+1];
		Arrays.fill(prime, true);
		prime[0]=prime[1]=false;
		for(int i=2;i<=N;i++)if(prime[i]){
			p[num++] = i;
			for(int j=i+i;j<=N;j+=i)prime[j]=false;
		}
		dp = new int[N+1][num+1][15];
		for(int i=0;i<=N;i++)for(int j=0;j<=num;j++)for(int k=0;k<=14;k++)dp[i][j][k]=-1;
		Scanner sc = new Scanner(System.in);
		for(;;){
			int n = sc.nextInt(), k = sc.nextInt();
			if((n|k)==0)break;
			System.out.println(get(n, 0, k));
		}
	}
	
	public static void main(String[] args) {
		new AOJ1269().run();
	}
}
