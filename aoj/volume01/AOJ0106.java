package volume01;

import java.util.Scanner;

//Discounts of Buckwheat
public class AOJ0106 {

	static int[] m = {200,300,500};
	static int[] p = {380,550,850};
	static int[] d = {5,4,3};
	static double[] r = {0.8,0.85,0.88};
	
	static int min;
	
	static void dfs(int k, int rest, double x){
		if(rest==0){
			min = (int) Math.min(min, x);
			return;
		}
		if(k==3||rest<0)return;
		for(int i=0;i<=40;i++){
			dfs(k+1, rest-m[k]*i, x + p[k]*(i-i%d[k])*r[k] + p[k]*(i%d[k]));
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			min = Integer.MAX_VALUE;
			dfs(0,n,0);
			System.out.println(min);
		}
	}
}
