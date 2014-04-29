package volume05;

import java.util.Scanner;

//Crossing Black Ice
public class AOJ0535 {

	int w, h, max;
	int[][] move = {{-1,0},{0,1},{1,0},{0,-1}};
	int[][] a;
	boolean[][] u;
	
	void dfs(int i, int j, int c){
		max = Math.max(max, c);
		for(int k=0;k<4;k++){
			int ni = i+move[k][0], nj = j+move[k][1];
			if(0<=ni&&ni<h&&0<=nj&&nj<w&&!u[ni][nj]&&a[ni][nj]==1){
				u[ni][nj] = true; dfs(ni, nj, c+1); u[ni][nj] = false;
			}
		}
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			w = sc.nextInt(); h = sc.nextInt();
			if((w|h)==0)break;
			a = new int[h][w];
			for(int i=0;i<h;i++)for(int j=0;j<w;j++)a[i][j]=sc.nextInt();
			u = new boolean[h][w];
			max = 0;
			for(int i=0;i<h;i++)for(int j=0;j<w;j++){
				if(a[i][j]==0)continue;
				u[i][j] = true; dfs(i, j, 1); u[i][j] = false;
			}
			System.out.println(max);
		}
	}
	
	public static void main(String[] args) {
		new AOJ0535().run();
	}
}
