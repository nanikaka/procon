package volume11;

import java.math.BigInteger;
import java.util.Scanner;

//The Secret Number
public class AOJ1126 {

	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			int w = sc.nextInt();
			int h = sc.nextInt();
			if((w|h)==0)break;
			char[][] m = new char[h][w];
			for(int i=0;i<h;i++)m[i]=sc.next().toCharArray();
			String[][] dp = new String[h][w];
			String res = "0";
			for(int i=h-1;i>=0;i--)for(int j=w-1;j>=0;j--){
				if(Character.isUpperCase(m[i][j]))continue;
				String l = m[i][j]+"";
				String d = m[i][j]+"";
				if(i+1<h&&!Character.isUpperCase(m[i+1][j]))d+=dp[i+1][j];
				if(j+1<w&&!Character.isUpperCase(m[i][j+1]))l+=dp[i][j+1];
				if(l.length()!=d.length()){
					dp[i][j] = l.length()>d.length()?l:d;
				}
				else{
					BigInteger bl = new BigInteger(l);
					BigInteger bd = new BigInteger(d);
					if(bl.compareTo(bd)>0)dp[i][j] = l;
					else dp[i][j] = d;
				}
				BigInteger b = new BigInteger(dp[i][j]);
				if(b.compareTo(new BigInteger(res))>0){
					res = dp[i][j];
				}
			}
			System.out.println(new BigInteger(res).toString());
		}
	}

	public static void main(String[] args) {
		new AOJ1126().run();
	}
}
