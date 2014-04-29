package volume11;

import java.util.Scanner;

//Curling 2.0
public class AOJ1144 {

	static int w;
	static int h;
	static int[][] m;
	static int gi;
	static int gj;
	static int ans;
	static int[][] move = {{0,1},{0,-1},{1,0},{-1,0}};
	
	static void dfs(int i, int j, int step){
		if(step >= ans)return;
		for(int k=0;k<4;k++){
			int ti = i+move[k][0];
			int tj = j+move[k][1];
			if(0<=ti&&ti<h&&0<=tj&&tj<w&&m[ti][tj]!=1){
				if(ti==gi&&tj==gj){
					ans = step;
					return;
				}
				boolean out = false;
				while(true){
					int ni = ti + move[k][0];
					int nj = tj + move[k][1];
					if(0<=ni&&ni<h&&0<=nj&&nj<w){
						if(ni==gi&&nj==gj){
							ans = step;
							return;
						}
						if(m[ni][nj]==1){
							break;
						}
						ti = ni;
						tj = nj;
					}
					else{
						out = true;
						break;
					}
				}
				if(out)continue;
				int ni = ti + move[k][0];
				int nj = tj + move[k][1];
				m[ni][nj] = 0;
				dfs(ti, tj, step+1);
				m[ni][nj] = 1;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			w = sc.nextInt();
			h = sc.nextInt();
			if((w|h)==0)break;
			m = new int[h][w];
			int si = 0;
			int sj = 0;
			for(int i=0;i<h;i++){
				for(int j=0;j<w;j++){
					m[i][j]=sc.nextInt();
					if(m[i][j]==2){
						si = i;
						sj = j;
					}
					if(m[i][j]==3){
						gi = i;
						gj = j;
					}
				}
			}
			ans = 11;
			dfs(si, sj, 1);
			System.out.println(ans==11?-1:ans);
		}
	}
}
