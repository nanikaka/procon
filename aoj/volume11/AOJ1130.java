package volume11;

import java.util.Scanner;

//Red and Black
public class AOJ1130 {

	static int c, h, w;
	static int[][] move = {{1,0},{-1,0},{0,1},{0,-1}};
	static char[][] m;
	
	static void dfs(int i, int j){
		for(int k=0;k<4;k++){
			int ni = i + move[k][0];
			int nj = j + move[k][1];
			if(0<=ni&&ni<h&&0<=nj&&nj<w&&m[ni][nj]!='#'){
				m[ni][nj] = '#';
				c++;
				dfs(ni,nj);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			w = sc.nextInt();
			h = sc.nextInt();
			if((w|h)==0)break;
			m = new char[h][w];
			int si = 0;
			int sj = 0;
			for(int i=0;i<h;i++){
				char[] s = sc.next().toCharArray();
				for(int j=0;j<w;j++){
					m[i][j] = s[j];
					if(s[j]=='@'){
						si = i;
						sj = j;
					}
				}
			}
			c = 1;
			m[si][sj] = '#';
			dfs(si,sj);
			System.out.println(c);
		}
	}
}
