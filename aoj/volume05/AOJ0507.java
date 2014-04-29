package volume05;

import java.util.Scanner;

//Square
public class AOJ0507 {

	public static int[] a;

	public static void dfs(int k, int rest, int left){
		if(rest < 0)return;
		if(rest == 0){
			for(int i=0;i<k-1;i++){
				System.out.print(a[i] + " ");
			}
			System.out.println(a[k-1]);
			return;
		}
		for(int i=left;i>=1;i--){
			a[k] = i;
			dfs(k+1, rest-i, i);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			a = new int[30];
			dfs(0, n, n);
		}
	}
}
