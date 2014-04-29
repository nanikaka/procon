package volume15;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//ID
public class AOJ1500 {

	void run(){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		char[] s = sc.next().toCharArray();
		int m = sc.nextInt();
		Set<Integer> set = new HashSet<Integer>();
		for(int i=0;i<m;i++)set.add(sc.nextInt());
		long[][] dp = new long[2][10];
		int X = 1;
		dp[0][0] = 1;
		for(int i=1;i<=n;i++,X=1-X){
			Arrays.fill(dp[X], 0);
			for(int j=0;j<10;j++){
				if(s[n-i]=='*'){
					for(int x:set){
						if(i%2==0)x*=2;
						dp[X][(j+(x/10)+(x%10))%10]+=dp[1-X][j];
					}
				}
				else{
					int x = s[n-i]-'0';
					if(i%2==0)x*=2;
					dp[X][(j+(x/10)+(x%10))%10]+=dp[1-X][j];
				}
			}
		}
		System.out.println(dp[1-X][0]);
	}
	
	public static void main(String[] args) {
		new AOJ1500().run();
	}
}
