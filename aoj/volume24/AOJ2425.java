package volume24;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

//A Holiday of Miss Brute Force
public class AOJ2425 {

	int[][][] dist;
	int sx, sy, gx, gy, lx, ly;
	
	boolean ok(int x, int y){
		return -lx+100<=x&&x<=lx+100&&-ly+100<=y&&y<=ly+100;
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		boolean[][] rock = new boolean[201][201];
		sx = sc.nextInt()+100; sy = sc.nextInt()+100;
		gx = sc.nextInt()+100; gy = sc.nextInt()+100;
		int n = sc.nextInt();
		while(n--!=0)rock[sc.nextInt()+100][sc.nextInt()+100] = true;
		lx = sc.nextInt(); ly = sc.nextInt();
		dist = new int[201][201][6];
		int INF = 1<<28;
		for(int i=0;i<=200;i++)for(int j=0;j<=200;j++)for(int k=0;k<6;k++)dist[i][j][k]=INF;
		dist[sx][sy][0] = 0;
		PriorityQueue<int[]> q = new PriorityQueue<int[]>(256, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return dist[o1[0]][o1[1]][o1[2]] - dist[o2[0]][o2[1]][o2[2]];
			}
		});
		q.add(new int[]{sx, sy, 0});
		int[][] even = {{0, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}};
		int[][] odd = {{0, 1}, {1, 1}, {1, 0}, {0, -1}, {-1, 0}, {-1, 1}};
		while(!q.isEmpty()){
			int[] V = q.poll();
			int x = V[0], y = V[1], t = V[2], dir = (Math.abs(x-100)*Math.abs(y-100)*t)%6;
			if(dist[x][y][t]+1 < dist[x][y][(t+1)%6]){
				dist[x][y][(t+1)%6] = dist[x][y][t] + 1;
				q.add(new int[]{x, y, (t+1)%6});
			}
			for(int k=0;k<6;k++){
				int nx = x + ((x&1)==0?even[k][0]:odd[k][0]), ny = y + ((x&1)==0?even[k][1]:odd[k][1]);
				int w = dist[x][y][t] + (k==dir?0:1);
				if(ok(nx, ny) && !rock[nx][ny] && w < dist[nx][ny][(t+1)%6]){
					dist[nx][ny][(t+1)%6] = w;
					q.add(new int[]{nx, ny, (t+1)%6});
				}
			}
		}
		int res = INF;
		for(int k=0;k<6;k++)res = Math.min(res, dist[gx][gy][k]);
		System.out.println(res==INF?-1:res);
	}
	
	public static void main(String[] args) {
		new AOJ2425().run();
	}
}
