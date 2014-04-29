package volume01;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

//Byakko Delivery Company
public class AOJ0194 {

	int[] trans(String s){
		String[] t = s.split("-");
		int a = t[0].charAt(0)-'a';
		int b = Integer.parseInt(t[1])-1;
		return new int[]{a, b};
	}
	
	int INF = 1<<29;
	boolean[][][][] dist;
	int[][] move = {{-1,0},{0,1},{1,0},{0,-1}};
	
	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			int h = sc.nextInt(), w = sc.nextInt();
			if((h|w)==0)break;
			int D = sc.nextInt();
			int[][] e = new int[h*w][h*w];
			for(int[]a:e)Arrays.fill(a, D);
			int ns = sc.nextInt();
			int[] k = new int[h*w];
			while(ns--!=0){
				int[] t = trans(sc.next());
				k[t[0]*w+t[1]] = sc.nextInt();
			}
			int nc = sc.nextInt();
			while(nc--!=0){
				int[] t1 = trans(sc.next()), t2 = trans(sc.next());
				int s = t1[0]*w+t1[1], t = t2[0]*w+t2[1];
				e[s][t] = e[t][s] = INF;
			}
			int njj = sc.nextInt();
			while(njj--!=0){
				int[] t1 = trans(sc.next()), t2 = trans(sc.next());
				int d = sc.nextInt();
				int s = t1[0]*w+t1[1], t = t2[0]*w+t2[1];
				e[s][t] = e[t][s] = D+d;
			}
			int[] start = trans(sc.next()), goal = trans(sc.next());
			dist = new boolean[h][w][4][101];
			dist[start[0]][start[1]][1][0] = true;
			PriorityQueue<int[]> q = new PriorityQueue<int[]>(h, new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
					return o1[3]-o2[3];
				}
			});
			q.add(new int[]{start[0], start[1], 1, 0});
			while(!q.isEmpty()){
				int[] a = q.poll();
				int i = a[0], j = a[1], dir = a[2];
				if(i==goal[0]&&j==goal[1]){
					System.out.println(a[3]); break;
				}
				for(int m=3;m<=5;m++){
					int nd = (dir+m)%4;
					int ni = i+move[nd][0], nj = j+move[nd][1];
					if(0<=ni&&ni<h&&0<=nj&&nj<w&&e[i*w+j][ni*w+nj]!=INF){
						int nt = a[3] + e[i*w+j][ni*w+nj];
						if(k[ni*w+nj]==0){
							if(nt<=100&&!dist[ni][nj][nd][nt]){
								dist[ni][nj][nd][nt] = true;
								q.add(new int[]{ni, nj, nd, nt});
							}
						}
						else{
							boolean nsblue = (nt/k[ni*w+nj])%2==0;
							if(nd%2==0&&!nsblue||nd%2==1&&nsblue)continue;
							if(nt<=100&&!dist[ni][nj][nd][nt]){
								dist[ni][nj][nd][nt] = true;
								q.add(new int[]{ni, nj, nd, nt});
							}
						}
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new AOJ0194().run();
	}
}
