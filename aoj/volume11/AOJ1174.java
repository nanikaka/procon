package volume11;

import java.util.Scanner;

//Identically Colored Panels Connection
public class AOJ1174 {

	int h, w, t;
	int[][] o;
	int[][] tmp;
	int[] order;
	boolean[][] u;
	int max, c;
	int[][] move = {{-1,0},{0,1},{1,0},{0,-1}};

	void e(){
		for(int k=0;k<5;k++){
			if(tmp[0][0]==order[k])continue;
			flip(0, 0, tmp[0][0], order[k]);
		}
		c = 0;
		u = new boolean[h][w];
		v(0, 0);
	}

	void v(int i, int j){
		if(tmp[i][j]!=t)return;
		c++;
		u[i][j] = true;
		for(int k=0;k<4;k++){
			int ni = i+move[k][0];
			int nj = j+move[k][1];
			if(0<=ni&&ni<h&&0<=nj&&nj<w&&!u[ni][nj]){
				v(ni, nj);
			}
		}
	}

	void flip(int i, int j, int from, int to){
		if(tmp[i][j]!=from)return;
		tmp[i][j] = to;
		for(int k=0;k<4;k++){
			int ni = i+move[k][0];
			int nj = j+move[k][1];
			if(0<=ni&&ni<h&&0<=nj&&nj<w)flip(ni, nj, from, to);
		}
	}

	void run(){
		Scanner sc = new Scanner(System.in);
		while(true){
			h = sc.nextInt();
			w = sc.nextInt();
			t = sc.nextInt();
			if((h|w|t)==0)break;
			o = new int[h][w];
			tmp = new int[h][w];
			for(int i=0;i<h;i++)for(int j=0;j<w;j++)o[i][j]=sc.nextInt();
			max = 0;
			order = new int[5];
			for(int i=1;i<=6;i++){
				for(int j=1;j<=6;j++){
					for(int k=1;k<=6;k++){
						for(int l=1;l<=6;l++){
							order[0] = i;
							order[1] = j;
							order[2] = k;
							order[3] = l;
							order[4] = t;
							for(int x=0;x<h;x++)for(int y=0;y<w;y++)tmp[x][y]=o[x][y];
							e();
							max = Math.max(max, c);
						}
					}
				}
			}
			System.out.println(max);
		}
	}

	public static void main(String[] args) {
		new AOJ1174().run();
	}
}
