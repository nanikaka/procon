package volume0;

import java.util.Scanner;

//Sum of 4 Integers
public class AOJ0008 {

	public static int n;
	public static int ans;

	public static void dfs(int k, int s){
		if(n<s)return;
		if(k==4){
			if(s==n)ans++;
			return;
		}
		for(int i=0;i<10;i++){
			dfs(k+1, s+i);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			n = sc.nextInt();
			ans = 0;
			dfs(0, 0);
			System.out.println(ans);
		}
	}
}
