package volume20;

import java.util.Arrays;
import java.util.Scanner;

//Water Pipe Construction
public class AOJ2005 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			int m = sc.nextInt();
			int s = sc.nextInt();
			int g1 = sc.nextInt();
			int g2 = sc.nextInt();
			if(n==0)break;
			int[][] cost = new int[n+1][n+1];
			for(int[]c:cost)Arrays.fill(c, Integer.MAX_VALUE);
			while(m--!=0){
				int a = sc.nextInt();
				int b = sc.nextInt();
				cost[a][b]=sc.nextInt();
			}
			int[][] wf = new int[n+1][n+1];
			for(int i=1;i<=n;i++)
				for(int j=1;j<=n;j++)
					wf[i][j] = cost[i][j];
			for(int i=1;i<=n;i++)wf[i][i]=0;
			for(int k=1;k<=n;k++){
				for(int i=1;i<=n;i++){
					for(int j=1;j<=n;j++){
						if(wf[i][k]!=Integer.MAX_VALUE && wf[k][j]!=Integer.MAX_VALUE)
							wf[i][j] = Math.min(wf[i][j], wf[i][k]+wf[k][j]);
					}
				}
			}
			int min = Integer.MAX_VALUE;
			for(int k=1;k<=n;k++){
				if(wf[s][k]!=Integer.MAX_VALUE && wf[k][g1]!=Integer.MAX_VALUE && wf[k][g2]!=Integer.MAX_VALUE){
					min = Math.min(min, wf[s][k]+wf[k][g1]+wf[k][g2]);
				}
			}
			System.out.println(min);
		}
	}
}
