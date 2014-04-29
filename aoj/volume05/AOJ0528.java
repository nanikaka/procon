package volume05;

import java.util.Scanner;

//Common Sub-String
public class AOJ0528 {

	void run(){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			char[] s = sc.next().toCharArray();
			char[] t = sc.next().toCharArray();
			int ns = s.length;
			int nt = t.length;
			int[][] dp = new int[ns][nt];
			for(int i=0;i<ns;i++)dp[i][0]=s[i]==t[0]?1:0;
			for(int j=0;j<nt;j++)dp[0][j]=s[0]==t[j]?1:0;
			int m = 0;
			for(int i=1;i<ns;i++){
				for(int j=1;j<nt;j++){
					dp[i][j] = s[i]==t[j]?dp[i-1][j-1]+1:0;
					m = Math.max(m, dp[i][j]);
				}
			}
			System.out.println(m);
		}
	}

	public static void main(String[] args) {
		new AOJ0528().run();
	}
}
