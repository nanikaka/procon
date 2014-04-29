package volume11;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

//Twirling Robot
public class AOJ1156 {

	static int[][][] dist;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] move = {{-1,0},{0,1},{1,0},{0,-1}};
		while(true){
			int w = sc.nextInt();
			int h = sc.nextInt();
			if((w|h)==0)break;
			int[][] m = new int[h][w];
			for(int i=0;i<h;i++)for(int j=0;j<w;j++)m[i][j]=sc.nextInt();
			int[] cost = new int[4];
			for(int i=0;i<4;i++)cost[i]=sc.nextInt();
			dist = new int[h][w][4];
			for(int i=0;i<h;i++)for(int j=0;j<w;j++)for(int k=0;k<4;k++)dist[i][j][k]=Integer.MAX_VALUE;
			dist[0][0][1] = 0;
			PriorityQueue<int[]> q = new PriorityQueue<int[]>(h*w, new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
					return dist[o1[0]][o1[1]][o1[2]]-dist[o2[0]][o2[1]][o2[2]];
				}
			});
			q.add(new int[]{0,0,1});
			while(!q.isEmpty()){
				int[] a = q.poll();
				int i = a[0];
				int j = a[1];
				int dir = a[2];
				if(i==h-1&&j==w-1){
					System.out.println(dist[i][j][dir]);
					break;
				}
				for(int k=0;k<4;k++){
					int nd = (dir+k)%4;
					int ni = i+move[nd][0];
					int nj = j+move[nd][1];
					if(0<=ni&&ni<h&&0<=nj&&nj<w){
						int c = dist[i][j][dir] + (m[i][j]==k?0:cost[k]);
						if(c < dist[ni][nj][nd]){
							dist[ni][nj][nd] = c;
							q.add(new int[]{ni,nj,nd});
						}
					}
				}
			}
		}
	}
}
