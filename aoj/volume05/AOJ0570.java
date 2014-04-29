package volume05;

import java.math.BigInteger;
import java.util.Scanner;

//Zig-Zag Numbers
public class AOJ0570 {

	int[] s;
	int n, MOD, M = 10000;
	//idx, free, isUp, pre, M
	int[][][][][] dp;
	
	int get(int k, int f, int u, int pre, int m, boolean zero){
		if(k==n)return zero?0:m==0?1:0;
		int res = 0;
		if(zero){
			res+=get(k+1,f,u,0,0,true);
			for(int p=1;p<10;p++){
				res+=get(k+1,f,0,p,p%MOD,false);
				if(k+1!=n)res+=get(k+1,f,1,p,p%MOD,false);
			}
			return res%M;
		}
		if(dp[k][f][u][pre][m]!=-1)return dp[k][f][u][pre][m];
		if(f==1){
			if(u==1){
				for(int p=pre+1;p<10;p++){
					res+=get(k+1,f,1-u,p,(m*10+p)%MOD,false);
				}
			}
			else{
				for(int p=0;p<pre;p++){
					res+=get(k+1,f,1-u,p,(m*10+p)%MOD,false);
				}
			}
		}
		else{
			if(u==1){
				for(int p=pre+1;p<=s[k];p++){
					if(p==s[k])res+=get(k+1,0,1-u,p,(m*10+p)%MOD,false);
					else res+=get(k+1,1,1-u,p,(m*10+p)%MOD,false);
				}
			}
			else{
				int t = Math.min(pre-1, s[k]);
				for(int p=0;p<=t;p++){
					if(p==s[k])res+=get(k+1,0,1-u,p,(m*10+p)%MOD,false);
					else res+=get(k+1,1,1-u,p,(m*10+p)%MOD,false);
				}
			}
		}
		return dp[k][f][u][pre][m] = res%M;
	}
	
	int f(String r){
		n = r.length();
		s = new int[n];
		for(int i=0;i<n;i++)s[i]=r.charAt(i)-'0';
		dp = new int[n+1][2][2][10][MOD];
		for(int i=0;i<=n;i++)for(int j=0;j<2;j++)for(int k=0;k<2;k++)for(int p=0;p<10;p++)for(int m=0;m<MOD;m++)dp[i][j][k][p][m]=-1;
		int res = 0;
		res += get(1, 1, 0, 0, 0, true);
		for(int p=1;p<=s[0];p++){
			if(p==s[0]){
				res+=get(1,0,0,p,p%MOD,false);
				if(n!=1)res+=get(1,0,1,p,p%MOD,false);
			}
			else{
				res+=get(1,1,0,p,p%MOD,false);
				if(n!=1)res+=get(1,1,1,p,p%MOD,false);
			}
		}
		return res%M;
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		String A = sc.nextBigInteger().subtract(BigInteger.ONE).toString(), B = sc.next();
		MOD = sc.nextInt();
		System.out.println((f(B)-f(A)+M)%M);
	}
	
	public static void main(String[] args) {
		new AOJ0570().run();
	}
}
