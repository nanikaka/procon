package volume10;

import java.util.Scanner;

//Extraordinary Grid 1
public class AOJ1002 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t--!=0){
			int n = sc.nextInt();
			boolean[] b = new boolean[4*n+1];
			char[] yn = sc.next().toCharArray();
			for(int i=1;i<=4*n;i++)b[i]=yn[i-1]=='Y';
			int[][] cost = new int[n+1][3];
			if(b[4*n]){
				cost[n][0]=6;
				cost[n][1]=4;
				cost[n][2]=4;
			}
			else if(b[2*n]){
				cost[n][0]=2;
				cost[n][1]=2;
				cost[n][2]=4;
			}
			else {
				cost[n][0]=0;
				cost[n][1]=2;
				cost[n][2]=4;
			}
			for(int i=n-1;i>0;i--){
				boolean f1 = b[2*i]||b[2*i+1];
				boolean f2 = b[2*n+2*i]||b[2*n+2*i+1];
				if(f1&&f2){
					cost[i][0] = Math.min(6+cost[i+1][2], Math.min(4+cost[i+1][1], 6+cost[i+1][0]));
					cost[i][1] = Math.min(4+cost[i+1][2], Math.min(4+cost[i+1][1], 4+cost[i+1][0]));
					cost[i][2] = Math.min(6+cost[i+1][2], Math.min(4+cost[i+1][1], 4+cost[i+1][0]));
				}
				else if(f1&&!f2){
					cost[i][0] = Math.min(4+cost[i+1][2], Math.min(2+cost[i+1][1], 2+cost[i+1][0]));
					cost[i][1] = Math.min(4+cost[i+1][2], Math.min(2+cost[i+1][1], 2+cost[i+1][0]));
					cost[i][2] = Math.min(6+cost[i+1][2], Math.min(4+cost[i+1][1], 4+cost[i+1][0]));
				}
				else if(!f1&&f2){
					cost[i][0] = Math.min(4+cost[i+1][2], Math.min(4+cost[i+1][1], 6+cost[i+1][0]));
					cost[i][1] = Math.min(2+cost[i+1][2], Math.min(2+cost[i+1][1], 4+cost[i+1][0]));
					cost[i][2] = Math.min(2+cost[i+1][2], Math.min(2+cost[i+1][1], 4+cost[i+1][0]));
				}
				else{
					cost[i][0] = Math.min(4+cost[i+1][2], Math.min(2+cost[i+1][1], cost[i+1][0]));
					cost[i][1] = Math.min(2+cost[i+1][2], Math.min(cost[i+1][1], 2+cost[i+1][0]));
					cost[i][2] = Math.min(cost[i+1][2], Math.min(2+cost[i+1][1], 4+cost[i+1][0]));
				}
			}
			boolean f1 = b[1];
			boolean f2 = b[2*n+1];
			if(f1&&f2)
				cost[0][0] = Math.min(4+cost[1][2], Math.min(4+cost[1][1], 6+cost[1][0]));
			else if(f1&&!f2)
				cost[0][0] = Math.min(4+cost[1][2], Math.min(2+cost[1][1], 2+cost[1][0]));
			else if(!f1&&f2)
				cost[0][0] = Math.min(4+cost[1][2], Math.min(4+cost[1][1], 6+cost[1][0]));
			else
				cost[0][0] = Math.min(4+cost[1][2], Math.min(2+cost[1][1], cost[1][0]));
			System.out.println(n+cost[0][0]/2);
		}
	}
}
