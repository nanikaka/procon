package volume01;

import java.util.Scanner;

//Doctor's Strange Particles
public class AOJ0131 {

	static int[][] m;
	static int[][] tmp;
	static boolean[][] ans;
	static int[][] move = {{0,1},{0,-1},{1,0},{-1,0},{0,0}};
	
	static boolean dfs(int k){
		if(k==10){
			tmp = new int[10][10];
			for(int i=0;i<10;i++){
				if(ans[0][i]){
					for(int j=0;j<5;j++){
						int ni = 0+move[j][0];
						int nj = i+move[j][1];
						if(0<=ni&&ni<10&&0<=nj&&nj<10)tmp[ni][nj]++;
					}
				}
			}
			for(int i=1;i<10;i++){
				for(int j=0;j<10;j++){
					if((tmp[i-1][j]+m[i-1][j])%2==1){
						ans[i][j] = true;
						for(int v=0;v<5;v++){
							int ni = i+move[v][0];
							int nj = j+move[v][1];
							if(0<=ni&&ni<10&&0<=nj&&nj<10)tmp[ni][nj]++;
						}
					}
					else ans[i][j] = false;
				}
			}
			for(int i=0;i<10;i++){
				for(int j=0;j<10;j++){
					if((tmp[i][j]+m[i][j])%2==1)return false;
				}
			}
			return true;
		}
		else{
			ans[0][k] = false;
			if(dfs(k+1))return true;
			ans[0][k] = true;
			return dfs(k+1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t--!=0){
			m = new int[10][10];
			ans = new boolean[10][10];
			for(int i=0;i<10;i++)for(int j=0;j<10;j++)m[i][j]=sc.nextInt();
			dfs(0);
			for(int i=0;i<10;i++){
				for(int j=0;j<10;j++){
					if(j>0)System.out.print(" ");
					System.out.print(ans[i][j]?"1":"0");
				}
				System.out.println();
			}
		}
	}
}
