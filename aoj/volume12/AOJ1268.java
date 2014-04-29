package volume12;

import java.util.Scanner;

//Cubic Eight-Puzzle
public class AOJ1268 {

	int[] top = {0, 0, 1, 1, 2, 2, 3};
	int[][] d = {{-1,0},{0,1},{1,0},{0,-1}};
	int[][] adj = {
			{2, 5, 2, 5},
			{4, 3, 4, 3},
			{0, 4, 0, 4},
			{5, 1, 5, 1},
			{1, 2, 1, 2},
			{3, 0, 3, 0}
	};

	int[][] goal, state;
	boolean dfs(int ei, int ej, int depth, int limit, int pre){
		int dif = 0;
		for(int i=0;i<3;i++)for(int j=0;j<3;j++)dif+=top[state[i][j]]!=goal[i][j]?1:0;
		if(dif==0)return true;
		if(limit<depth)return false;
		if(limit<depth+dif-1)return false;
		for(int k=0;k<4;k++){
			if(pre==(k+2)%4)continue;
			int ni = ei+d[k][0], nj = ej+d[k][1];
			if(0<=ni&&ni<3&&0<=nj&&nj<3){
				state[ei][ej] = adj[state[ni][nj]][k]; state[ni][nj] = 6;
				if(dfs(ni, nj, depth+1, limit, k))return true;
				state[ni][nj] = adj[state[ei][ej]][k]; state[ei][ej] = 6;
			}
		}
		return false;
	}

	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			int x = sc.nextInt(), y = sc.nextInt();
			if((x|y)==0)break;
			goal = new int[3][3];
			for(int i=0;i<3;i++)for(int j=0;j<3;j++){
				char c = sc.next().charAt(0);
				goal[i][j] = c=='W'?0:c=='R'?1:c=='B'?2:3;
			}
			state = new int[3][3];
			for(int i=0;i<3;i++)for(int j=0;j<3;j++){
				state[i][j] = i+1==y&&j+1==x?6:0;
			}
			int res = -1;
			for(int L=0;L<=30;L++){
				if(dfs(y-1, x-1, 0, L, -1)){
					res = L; break;
				}
			}
			System.out.println(res);
		}
	}

	public static void main(String[] args) {
		new AOJ1268().run();
	}
}
