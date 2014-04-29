package volume12;

import java.util.Arrays;
import java.util.Scanner;

//Make a Sequence
public class AOJ1249 {

	int[][][] a;
	int[][] z;
	int[][] move = {
			{0,0,1},
			{0,1,0},
			{1,0,0},
			{1,-1,0},
			{1,1,0},
			{1,0,1},
			{1,0,-1},
			{0,1,1},
			{0,1,-1},
			{1,1,1},
			{1,1,-1},
			{1,-1,1},
			{-1,1,1}
	};

	int seq(int x, int y, int z, int p){
		int max = 0;
		for(int k=0;k<13;k++){
			int r = 0;
			int nx = x, ny = y, nz = z;
			while(a[nx][ny][nz]==p){
				nx += move[k][0]; ny += move[k][1]; nz += move[k][2]; r++;
			}
			max = Math.max(max, r);
		}
		return max;
	}

	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			int n = sc.nextInt(), m = sc.nextInt(), p = sc.nextInt();
			if((n|m|p)==0)break;
			a = new int[n+2][n+2][n+2]; z = new int[n+1][n+1];
			for(int[]v:z)Arrays.fill(v, 1);
			int win = 0, step = 0, t = 1;
			for(int s=1;s<=p;s++){
				int x = sc.nextInt(), y = sc.nextInt();
				if(win!=0)continue;
				a[x][y][z[x][y]++] = t;
				for(int i=1;i<=n;i++)for(int j=1;j<=n;j++)for(int k=1;k<=n;k++){
					if(seq(i, j, k, t)>=m){
						win = t; step = s;
					}
				}
				t=t==1?2:1;
			}
			System.out.println(win==0?"Draw":win==1?"Black "+step:"White "+step);
		}
	}

	public static void main(String[] args) {
		new AOJ1249().run();
	}
}
