package volume02;

import java.util.Arrays;
import java.util.Scanner;

//Traveling Alone: One-way Ticket of Youth
public class AOJ0200 {

	public static int n;
	public static int m;

	public static int[][] cost;
	public static int[][] time;

	public static int[] dist;


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			n = sc.nextInt();
			m = sc.nextInt();
			if(n==0&&m==0)break;
			cost = new int[m][m];
			time = new int[m][m];
			dist = new int[m];
			int[][] dcost = new int[m][m];
			int[][] dtime = new int[m][m];
			for(int[] a:cost)Arrays.fill(a, Integer.MAX_VALUE);
			for(int[] a:time)Arrays.fill(a, Integer.MAX_VALUE);
			for(int[] a:dcost)Arrays.fill(a, 1000000);
			for(int[] a:dtime)Arrays.fill(a, 1000000);
			for(int i=0;i<m;i++)dcost[i][i]=dtime[i][i]=0;
			while(n--!=0){
				int a = sc.nextInt()-1;
				int b = sc.nextInt()-1;
				int c = sc.nextInt();
				int t = sc.nextInt();
				cost[a][b] = cost[b][a] = c;
				dcost[a][b] = dcost[b][a] = Math.min(dcost[a][b], c);
				time[a][b] = time[b][a] = t;
				dtime[a][b] = dtime[b][a] = Math.min(dtime[a][b], t);
			}
			for(int k=0;k<m;k++){
				for(int i=0;i<m;i++){
					for(int j=0;j<m;j++){
						dcost[i][j] = Math.min(dcost[i][j], dcost[i][k]+dcost[k][j]);
						dtime[i][j] = Math.min(dtime[i][j], dtime[i][k]+dtime[k][j]);
					}
				}
			}
			int k = sc.nextInt();
			while(k--!=0){
				int s = sc.nextInt()-1;
				int t = sc.nextInt()-1;
				int x = sc.nextInt();
				System.out.println(x==0?dcost[s][t]:dtime[s][t]);
			}
		}
	}
}
