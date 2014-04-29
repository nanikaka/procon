package volume02;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

//Ninja Climbing
public class AOJ0230 {

	static int[][] dist;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			int[][] a = new int[n][2];
			for(int i=0;i<2;i++)for(int j=0;j<n;j++)a[j][i]=sc.nextInt();
			dist = new int[n][2];
			for(int i=0;i<n;i++)Arrays.fill(dist[i], Integer.MAX_VALUE);
			dist[0][0] = dist[0][1] = 0;
			PriorityQueue<int[]> q = new PriorityQueue<int[]>(n, new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
					return dist[o1[0]][o1[1]]-dist[o2[0]][o2[1]];
				}
			});
			q.add(new int[]{0,0});
			q.add(new int[]{0,1});
			int ans = -1;
			while(!q.isEmpty()){
				int[] v = q.poll();
				int h = v[0];
				int w = v[1];
				if(h==n-1 && a[n-1][w]!=2){
					ans = dist[n-1][w];
					break;
				}
				if(a[h][w]==2){
					if(dist[h][w] < dist[h-1][w]){
						dist[h-1][w] = dist[h][w];
						q.add(new int[]{h-1,w});
					}
				}
				else if(a[h][w]==1){
					if(a[h+1][w]==1){
						if(dist[h][w] < dist[h+1][w]){
							dist[h+1][w] = dist[h][w];
							q.add(new int[]{h+1, w});
						}
					}
					else {
						int d = w==0?1:0;
						for(int k=0;k<3;k++){
							int nh = h + k;
							if(nh > n-1)break;
							if(dist[h][w]+1 < dist[nh][d]){
								dist[nh][d] = dist[h][w]+1;
								q.add(new int[]{nh,d});
							}
						}
					}
				}
				else{
					int d = w==0?1:0;
					for(int k=0;k<3;k++){
						int nh = h + k;
						if(nh > n-1)break;
						if(dist[h][w]+1 < dist[nh][d]){
							dist[nh][d] = dist[h][w]+1;
							q.add(new int[]{nh,d});
						}
					}
				}
			}
			System.out.println(ans==-1?"NA":ans);
		}
	}
}
