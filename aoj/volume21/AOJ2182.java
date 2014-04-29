package volume21;

import java.util.Arrays;
import java.util.Scanner;

//Eleven Lover
public class AOJ2182 {

	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			char[] s = sc.next().toCharArray();
			if(s.length==1&&s[0]=='0')break;
			int[][] dp = new int[2][11];
			int x = 0, res = 0;
			for(int i=0;i<s.length;i++,x=1-x){
				int r = s[i]-'0';
				Arrays.fill(dp[x], 0);
				for(int j=0;j<11;j++){
					dp[x][(10*j+r)%11]+=dp[1-x][j];
				}
				if(r!=0)dp[x][r]++;
				res+=dp[x][0];
			}
			System.out.println(res);
		}
	}
	
	public static void main(String[] args) {
		new AOJ2182().run();
	}
}
