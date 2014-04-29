package volume11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//Cleaning Robot
public class AOJ1140 {

	static int min;
	static boolean[] used;
	static int[][] dist;
	
	static void dfs(int[] order, int k){
		if(k==order.length){
			int s = 0;
			int from = 0;
			for(int i=0;i<order.length;i++){
				s += dist[from][order[i]];
				from = order[i];
			}
			min = Math.min(min, s);
			return;
		}
		for(int i=1;i<=order.length;i++){
			if(!used[i]){
				used[i] = true;
				order[k] = i;
				dfs(order, k+1);
				used[i] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] move = {{1,0},{-1,0},{0,1},{0,-1}};
		while(true){
			int w = sc.nextInt();
			int h = sc.nextInt();
			if((w|h)==0)break;
			char[][] m = new char[h][w];
			int id = 1;
			Map<Integer, Integer> ref = new HashMap<Integer, Integer>();
			for(int i=0;i<h;i++){
				char[] s = sc.next().toCharArray();
				for(int j=0;j<w;j++){
					m[i][j] = s[j];
					if(m[i][j]=='*'){
						ref.put(i*w+j, id++);
					}
					if(m[i][j]=='o'){
						ref.put(i*w+j, 0);
					}
				}
			}
			dist = new int[id][id];
			for(int[]a:dist)Arrays.fill(a, Integer.MAX_VALUE);
			for(int i=0;i<h;i++){
				for(int j=0;j<w;j++){
					if(m[i][j]=='o'||m[i][j]=='*'){
						int from = ref.get(i*w+j);
						boolean[][] visited = new boolean[h][w];
						visited[i][j] = true;
						int step = 0;
						List<int[]> list = new ArrayList<int[]>();
						list.add(new int[]{i, j});
						while(!list.isEmpty()){
							List<int[]> next = new ArrayList<int[]>();
							for(int[] a:list){
								if(ref.containsKey(a[0]*w+a[1])){
									dist[from][ref.get(a[0]*w+a[1])] = step;
								}
								for(int k=0;k<4;k++){
									int ni = a[0] + move[k][0];
									int nj = a[1] + move[k][1];
									if(0<=ni&&ni<h&&0<=nj&&nj<w&&m[ni][nj]!='x'&&!visited[ni][nj]){
										visited[ni][nj] = true;
										next.add(new int[]{ni, nj});
									}
								}
							}
							list = next;
							step++;
						}
					}
				}
			}
			boolean f = true;
			for(int i=0;i<id;i++)if(dist[0][i]==Integer.MAX_VALUE)f = false;
			if(!f){
				System.out.println(-1);
				continue;
			}
			min = Integer.MAX_VALUE;
			used = new boolean[id];
			used[0] = true;
			dfs(new int[id-1], 0);
			System.out.println(min);
		}
	}
}
