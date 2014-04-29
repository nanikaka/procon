package volume05;

import java.util.Scanner;

//Longest Steps
public class AOJ0517 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			int k = sc.nextInt();
			if(n==0&&k==0)break;
			int[][] a = new int[n+1][2];
			//a[i][0]: 白紙カードを使わず、カードiを右端とするステップの長さ
			//a[i][1]: 白紙カードを使って、カードiを右端とするステップの長さ
			boolean[] c = new boolean[n+1];
			for(int i=0;i<k;i++)c[sc.nextInt()] = true;
			int m0 = 0;
			int m1 = 0;
			for(int i=1;i<=n;i++){
				a[i][0] = c[i]?a[i-1][0]+1:0;
				a[i][1] = c[i]?a[i-1][1]+1:a[i-1][0]+1;
				m0 = Math.max(m0, a[i][0]);
				m1 = Math.max(m1, a[i][1]);
			}
			System.out.println(c[0]?m1:m0);
		}
	}
}
