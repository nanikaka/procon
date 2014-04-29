package volume01;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

//Spider Jin
public class AOJ0155 {

	static double[] d;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			int[] id = new int[n];
			int[][] p = new int[n][2];
			Map<Integer, Integer> ref = new HashMap<Integer, Integer>();
			for(int i=0;i<n;i++){
				id[i] = sc.nextInt();
				p[i][0] = sc.nextInt();
				p[i][1] = sc.nextInt();
				ref.put(id[i], i);
			}
			double[][] cost = new double[n][n];
			for(int i=0;i<n;i++){
				for(int j=i+1;j<n;j++){
					double r = Math.hypot(p[i][0]-p[j][0], p[i][1]-p[j][1]);
					if(r<=50) cost[i][j] = cost[j][i] = r;
					else cost[i][j] = cost[j][i] = Integer.MAX_VALUE;
				}
			}
			int m = sc.nextInt();
			while(m--!=0){
				int s = ref.get(sc.nextInt());
				int g = ref.get(sc.nextInt());
				int[] pre = new int[1001];
				d = new double[n];
				Arrays.fill(d, Integer.MAX_VALUE);
				d[s] = 0;
				pre[s] = -1;
				PriorityQueue<Integer> q = new PriorityQueue<Integer>(n, new Comparator<Integer>() {
					public int compare(Integer o1, Integer o2) {
						return d[o1]-d[o2]<0?-1:d[o1]-d[o2]>0?1:0;
					}
				});
				q.add(s);
				String ans = "NA";
				while(!q.isEmpty()){
					int v = q.poll();
					if(v==g){
						int ID = v;
						ans = "";
						while(ID!=s){
							ans = " "+id[ID]+ans;
							ID = ref.get(pre[id[ID]]);
						}
						ans = id[s]+ans;
						break;
					}
					for(int i=0;i<n;i++){
						if(cost[v][i]!=Integer.MAX_VALUE){
							double c = d[v] + cost[v][i];
							if(c < d[i]){
								d[i] = c;
								pre[id[i]] = id[v];
								q.add(i);
							}
						}
					}
				}
				System.out.println(ans);
			}
		}
	}
}
