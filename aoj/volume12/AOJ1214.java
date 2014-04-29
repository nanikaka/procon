package volume12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Walking Ant
public class AOJ1214 {

	void run(){
		int[][] move = {{-1,0},{0,1},{1,0},{0,-1}};
		Scanner sc = new Scanner(System.in);
		for(;;){
			int w = sc.nextInt(), h = sc.nextInt();
			if((w|h)==0)break;
			int[][] map = new int[h][w];
			int si = -1, sj = -1;
			for(int i=0;i<h;i++)for(int j=0;j<w;j++){
				map[i][j] = sc.nextInt();
				if(map[i][j]==2){
					si = i; sj = j;
					map[i][j] = 1;
				}
			}
			boolean[][][] u = new boolean[h][w][7];
			u[si][sj][6] = true;
			List<int[]> l = new ArrayList<int[]>();
			l.add(new int[]{si, sj, 6});
			int step = 0;
			int ans = -1;
			while(!l.isEmpty()){
				List<int[]> next = new ArrayList<int[]>();
				for(int[]a:l){
					int i = a[0], j = a[1], hp = a[2];
					if(map[i][j]==3){
						ans = step;
						next.clear();
						break;
					}
					if(hp<=1)continue;
					for(int k=0;k<4;k++){
						int ni = i+move[k][0];
						int nj = j+move[k][1];
						if(0<=ni&&ni<h&&0<=nj&&nj<w&&map[ni][nj]!=0){
							if(map[ni][nj]==4){
								if(u[ni][nj][6])continue;
								u[ni][nj][6] = true;
								next.add(new int[]{ni, nj, 6});
							}
							else{
								if(u[ni][nj][hp-1])continue;
								u[ni][nj][hp-1] = true;
								next.add(new int[]{ni, nj, hp-1});
							}
						}
					}
				}
				step++;
				l = next;
			}
			System.out.println(ans);
		}
	}
	
	public static void main(String[] args) {
		new AOJ1214().run();
	}
}
