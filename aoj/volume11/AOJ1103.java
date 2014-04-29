package volume11;

import java.util.Scanner;

//Board Arrangements for Concentration Games
public class AOJ1103 {

	int[][] r;
	int c;
	int[] p;
	
	void dfs(int k){
		if(k==8){
			boolean[][] a = new boolean[4][4];
			k = 0;
			boolean f = true;
			for(int i=0;i<4;i++){
				for(int j=0;j<4;j++){
					if(a[i][j])continue;
					a[i][j] = true;
					int ni = i+r[p[k]][0];
					int nj = j+r[p[k]][1];
					if(0<=ni&&ni<4&&0<=nj&&nj<4&&!a[ni][nj]){
						a[ni][nj] = true;
						k++;
					}
					else {
						f = false;break;
					}
				}
			}
			if(f)c++;
			return;
		}
		for(int i=0;i<4;i++){
			p[k] = i;
			dfs(k+1);
		}
	}
	
	
	void run(){
		Scanner sc = new Scanner(System.in);
		while(true){
			int x = sc.nextInt();
			if(x>4)break;
			int y = sc.nextInt();
			r = new int[4][2];
			p = new int[8];
			r[0][0] = y;
			r[0][1] = x;
			for(int i=1;i<4;i++)for(int j=1;j>=0;j--)r[i][j]=sc.nextInt();
			c = 0;
			dfs(0);
			System.out.println(c);
		}
	}
	
	public static void main(String[] args) {
		new AOJ1103().run();
	}
}
