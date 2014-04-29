package volume21;

import java.util.Scanner;

//Can I go there?
public class AOJ2107 {

	long[][] modpow(long[][] A, long n){
		long[][] res = new long[A.length][A.length];
		for(int i=0;i<A.length;i++){
			res[i][i] = 1L;
		}
		while(n>0){
			if((n&1)>0){
				res = modmul(res, A);
				for(int i=0;i<A.length;i++)for(int j=0;j<A.length;j++)res[i][j] = Math.min(res[i][j], 1);
			}
			A = modmul(A, A);
			for(int i=0;i<A.length;i++)for(int j=0;j<A.length;j++)A[i][j] = Math.min(A[i][j], 1);
			n>>=1;
		}
		return res;
	}
	
	long[][] modmul(long[][] A, long[][] B){
		long[][] res = new long[A.length][B[0].length];
		for(int i=0;i<A.length;i++){
			for(int j=0;j<B[0].length;j++){
				for(int k=0;k<A[0].length;k++){
					res[i][j] = (res[i][j] + A[i][k]*B[k][j]);
				}
			}
		}
		return res;
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			int n = sc.nextInt(), m = sc.nextInt(), Z = sc.nextInt();
			if((n|m|Z)==0)break;
			int[] pre = new int[2*m], now = new int[2*m];
			for(int i=0;i<m;i++){
				int s = sc.nextInt(), t = sc.nextInt();
				pre[i*2] = s; now[i*2] = t;
				pre[i*2+1] = t; now[i*2+1] = s;
			}
			long[][] A = new long[2*m+1][2*m+1];
			for(int i=0;i<2*m;i++)for(int j=0;j<2*m;j++){
				if(now[i]==pre[j] && now[j]!=pre[i])A[i][j] = 1;
			}
			for(int i=0;i<2*m;i++)if(pre[i]==1)A[2*m][i] = 1;
			A = modpow(A, Z);
			String res = "no";
			for(int i=0;i<2*m;i++){
				if(now[i]==n && A[2*m][i]!=0){
					res = "yes"; break;
				}
			}
			System.out.println(res);
		}
	}
	
	public static void main(String[] args) {
		new AOJ2107().run();
	}
}
