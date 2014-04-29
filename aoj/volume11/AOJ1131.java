package volume11;

import java.util.Scanner;

//Unit Fraction Partition
public class AOJ1131 {

	static int p, q, a, n;
	static int c;
	
	static void dfs(int num, int den, int x, int k){
		if(p*den==q*num){
			c++;
			return;
		}
		if(k==n)return;
		if(p*den<q*num)return;
		for(int i=x;i*den<=a;i++){
			int nn = num*i+den;
			int nd = i*den;
			dfs(nn, nd, i, k+1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			p = sc.nextInt();
			q = sc.nextInt();
			a = sc.nextInt();
			n = sc.nextInt();
			if((p|q|a|n)==0)break;
			c = 0;
			dfs(0,1,1,0);
			System.out.println(c);
		}
	}
}
