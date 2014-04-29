package volume11;

import java.util.Scanner;

//How Many Islands?
public class AOJ1160 {

	static int h;
	static int w;
	static int[][] map;
	
	static int[][] move = {{0,1},{0,-1},{1,0},{-1,0},{1,1},{-1,-1},{1,-1},{-1,1}};
	
	static void dfs(int i, int j){
		map[i][j] = 0;
		for(int k=0;k<8;k++){
			int ni = i+move[k][0];
			int nj = j+move[k][1];
			if(0<=ni&&ni<h&&0<=nj&&nj<w&&map[ni][nj]==1)dfs(ni, nj);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			w = sc.nextInt();
			h = sc.nextInt();
			if((w|h)==0)break;
			map = new int[h][w];
			for(int i=0;i<h;i++)for(int j=0;j<w;j++)map[i][j]=sc.nextInt();
			int c = 0;
			for(int i=0;i<h;i++)
				for(int j=0;j<w;j++)
					if(map[i][j]==1){
						c++;
						dfs(i, j);
					}
			System.out.println(c);
		}
	}
}
