package volume11;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

//Cliff Climbing
public class AOJ1150 {

	static int[][][] dist;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] leftMove = {{-2,-1},{-1,-1},{0,-1},{1,-1},{2,-1},{-1,-2},{0,-2},{1,-2},{0,-3}};
		int[][] rightMove = {{-2,1},{-1,1},{0,1},{1,1},{2,1},{-1,2},{0,2},{1,2},{0,3}};
		while(true){
			int w = sc.nextInt();
			int h = sc.nextInt();
			if((w|h)==0)break;
			char[][] m = new char[h][w];
			for(int i=0;i<h;i++)for(int j=0;j<w;j++)m[i][j]=sc.next().charAt(0);
			dist = new int[h][w][2];
			for(int i=0;i<h;i++)for(int j=0;j<w;j++)for(int k=0;k<2;k++)dist[i][j][k]=Integer.MAX_VALUE;
			PriorityQueue<int[]> q = new PriorityQueue<int[]>(h*w, new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
					return dist[o1[0]][o1[1]][o1[2]] - dist[o2[0]][o2[1]][o2[2]];
				}
			});
			for(int i=0;i<h;i++){
				for(int j=0;j<w;j++){
					if(m[i][j]=='S'){
						dist[i][j][0] = 0;
						dist[i][j][1] = 0;
						q.add(new int[]{i, j, 0});
						q.add(new int[]{i, j, 1});
					}
				}
			}
			int ans = -1;
			while(!q.isEmpty()){
				int[] a = q.poll();
				int i = a[0];
				int j = a[1];
				int foot = a[2];
				if(m[i][j]=='T'){
					ans = dist[i][j][foot];
					break;
				}
				//next movement is right side
				if(foot==0){
					for(int k=0;k<9;k++){
						int ni = i+rightMove[k][0];
						int nj = j+rightMove[k][1];
						if(0<=ni&&ni<h&&0<=nj&&nj<w&&m[ni][nj]!='X'){
							int v = dist[i][j][foot] + (Character.isDigit(m[ni][nj])?(int)(m[ni][nj]-'0'):0);
							if(v < dist[ni][nj][1]){
								dist[ni][nj][1] = v;
								q.add(new int[]{ni, nj, 1});
							}
						}
					}
				}
				else{
					for(int k=0;k<9;k++){
						int ni = i+leftMove[k][0];
						int nj = j+leftMove[k][1];
						if(0<=ni&&ni<h&&0<=nj&&nj<w&&m[ni][nj]!='X'){
							int v = dist[i][j][foot] + (Character.isDigit(m[ni][nj])?(int)(m[ni][nj]-'0'):0);
							if(v < dist[ni][nj][0]){
								dist[ni][nj][0] = v;
								q.add(new int[]{ni, nj, 0});
							}
						}
					}
				}
			}
			System.out.println(ans);
		}
	}
}
