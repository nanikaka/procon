package volume21;

import java.util.Scanner;

//Battle Town
public class AOJ2103 {

	int[][] move = {{-1,0},{0,1},{1,0},{0,-1}};
	char[] c = {'^', '>', 'v', '<'};
	int h, w;
	char[][] map;
	
	void run(){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=0;t<T;t++){
			if(t>0)System.out.println();
			h = sc.nextInt(); w = sc.nextInt();
			map = new char[h][];
			for(int i=0;i<h;i++)map[i]=sc.next().toCharArray();
			sc.nextInt();
			int pi = -1, pj = -1, d = -1;
			for(int i=0;i<h;i++)for(int j=0;j<w;j++){
				if(map[i][j]=='^'||map[i][j]=='>'||map[i][j]=='v'||map[i][j]=='<'){
					for(d=0;d<4;d++)if(map[i][j]==c[d])break;
					map[i][j] = '.';
					pi = i; pj = j;
				}
			}
			for(char cmd:sc.next().toCharArray()){
				if(cmd=='S'){
					int ni = pi, nj = pj;
					while(0<=ni&&ni<h&&0<=nj&&nj<w){
						if(map[ni][nj]=='*'){
							map[ni][nj] = '.'; break;
						}
						else if(map[ni][nj]=='#')break;
						ni += move[d][0]; nj += move[d][1];
					}
				}
				else{
					d = cmd=='U'?0:cmd=='R'?1:cmd=='D'?2:3;
					int ni = pi+move[d][0], nj = pj+move[d][1];
					if(0<=ni&&ni<h&&0<=nj&&nj<w&&map[ni][nj]=='.'){
						pi = ni; pj = nj;
					}
				}
			}
			map[pi][pj] = c[d];
			for(int i=0;i<h;i++)System.out.println(new String(map[i]));
		}
	}
	
	public static void main(String[] args) {
		new AOJ2103().run();
	}
}
