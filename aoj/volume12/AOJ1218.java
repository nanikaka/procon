package volume12;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

//Push!!
public class AOJ1218 {

	int[][] dist;
	
	void run(){
		Scanner sc = new Scanner(System.in);
		int[][] move = {{-1,0},{0,1},{1,0},{0,-1}};
		for(;;){
			int w = sc.nextInt();
			int h = sc.nextInt();
			if((w|h)==0)break;
			int[][] map = new int[h][w];
			int si = 0, sj = 0, ci = 0, cj = 0;
			for(int i=0;i<h;i++)for(int j=0;j<w;j++){
				map[i][j] = sc.nextInt();
				if(map[i][j]==4){
					si = i; sj = j;
					map[i][j] = 0;
				}
				if(map[i][j]==2){
					ci = i; cj = j;
					map[i][j] = 0;
				}
			}
			dist = new int[w*h][w*h];
			for(int[]a:dist)Arrays.fill(a, 1<<29);
			dist[si*w+sj][ci*w+cj] = 0;
			PriorityQueue<int[]> q = new PriorityQueue<int[]>(w, new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
					return dist[o1[0]][o1[1]]-dist[o2[0]][o2[1]];
				}
			});
			q.add(new int[]{si*w+sj, ci*w+cj});
			int ans = -1;
			while(!q.isEmpty()){
				int[] a = q.poll();
				si = a[0]/w; sj = a[0]%w;
				ci = a[1]/w; cj = a[1]%w;
				if(map[ci][cj]==3){
					ans = dist[a[0]][a[1]];
					break;
				}
				for(int k=0;k<4;k++){
					int ni = si+move[k][0];
					int nj = sj+move[k][1];
					if(0<=ni&&ni<h&&0<=nj&&nj<w){
						if(ni==ci&&nj==cj){
							int i = ci+move[k][0], j = cj+move[k][1];
							if(0<=i&&i<h&&0<=j&&j<w&&map[i][j]!=1&&dist[a[0]][a[1]]+1<dist[ni*w+nj][i*w+j]){
								dist[ni*w+nj][i*w+j] = dist[a[0]][a[1]]+1;
								q.add(new int[]{ni*w+nj, i*w+j});
							}
						}
						else if(map[ni][nj]!=1){
							if(dist[a[0]][a[1]]<dist[ni*w+nj][a[1]]){
								dist[ni*w+nj][a[1]] = dist[a[0]][a[1]];
								q.add(new int[]{ni*w+nj, a[1]});
							}
						}
					}
				}
			}
			System.out.println(ans);
		}
	}
	
	public static void main(String[] args) {
		new AOJ1218().run();
	}
}
