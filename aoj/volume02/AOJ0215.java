package volume02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

//Pachimon Creature
public class AOJ0215 {

	static class N{
		int i, j, id, k;
		public N(int i, int j, int id, int k) {
			this.i = i;
			this.j = j;
			this.id = id;
			this.k = k;
		}
	}

	static int[][] dist;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int w = sc.nextInt();
			int h = sc.nextInt();
			if((w|h)==0)break;
			List<N>[] node = new ArrayList[5];
			for(int i=0;i<5;i++)node[i]=new ArrayList<N>();
			N[] ns = new N[6000];
			N start = null;
			N goal = null;
			int id = 0;
			for(int i=0;i<h;i++){
				char[] s = sc.next().toCharArray();
				for(int j=0;j<w;j++){
					if(s[j]=='S'){
						start = new N(i, j, id, 5);
						ns[id++] = start;
					}
					if(s[j]=='G'){
						goal = new N(i, j, id, 6);
						ns[id++] = goal;
					}
					if(Character.isDigit(s[j])){
						int k = s[j]-'0'-1;
						N nn = new N(i, j, id, k);
						node[k].add(nn);
						ns[id++] = nn;
					}
				}
			}
			int min = 1<<30;
			int ans = -1;
			for(int z=0;z<5;z++){
				ns[start.id].k = z;
				dist = new int[6][id];
				for(int[]d:dist)Arrays.fill(d, 1<<30);
				dist[1][start.id] = 0;
				PriorityQueue<int[]> q = new PriorityQueue<int[]>(id, new Comparator<int[]>() {
					public int compare(int[] o1, int[] o2) {
						return dist[o1[0]][o1[1]]-dist[o2[0]][o2[1]];
					}
				});
				q.add(new int[]{1, start.id});
				while(!q.isEmpty()){
					int[] a = q.poll();
					int num = a[0];
					int v = a[1];
					if(v==goal.id){
						continue;
					}
					if(num==5){
						int cos = dist[num][v] + Math.abs(goal.i-ns[v].i) + Math.abs(goal.j-ns[v].j);
						if(cos < dist[5][goal.id]){
							dist[5][goal.id] = cos;
							q.add(new int[]{5, goal.id});
						}
						continue;
					}
					int next = (ns[v].k+1)%5;
					for(N n:node[next]){
						int cos = dist[num][v] + Math.abs(n.i-ns[v].i) + Math.abs(n.j-ns[v].j);
						if(cos < dist[num+1][n.id]){
							dist[num+1][n.id] = cos;
							q.add(new int[]{num+1, n.id});
						}
					}
				}
				if(dist[5][goal.id] < min){
					ans = z+1;
					min = dist[5][goal.id];
				}
			}
			System.out.println(ans==-1?"NA":(ans+" "+min));
		}
	}
}
