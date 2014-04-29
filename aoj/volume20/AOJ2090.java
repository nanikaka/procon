package volume20;

import java.util.Scanner;

//Repeated Subsequences
public class AOJ2090 {

	String lcs(String a, String b){
		int na = a.length(), nb = b.length();
		int dp[][] = new int[na+1][nb+1];
		for(int i=1;i<=na;i++)for(int j=1;j<=nb;j++){
			if(a.charAt(i-1)==b.charAt(j-1))dp[i][j] = dp[i-1][j-1] + 1;
			else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
		}
		char[] r = new char[dp[na][nb]];
		int i = na, j = nb;
		while(0<i&&0<j){
			if(dp[i][j]==dp[i-1][j])i--;
			else if(dp[i][j]==dp[i][j-1])j--;
			else{
				r[dp[i-1][j-1]] = a.charAt(i-1);
				i--; j--;
			}
		}
		return new String(r);
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			String s = sc.next();
			if("#END".equals(s))break;
			String res = "";
			for(int i=1;i<s.length();i++){
				String l = lcs(s.substring(0, i), s.substring(i));
				if(res.length()<l.length())res = l;
			}
			System.out.println(res);
		}
	}
	
	public static void main(String[] args) {
		new AOJ2090().run();
	}
}
