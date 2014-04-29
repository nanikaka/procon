package volume13;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

//The Two Men of the Japanese Alps
public class AOJ1309 {

	int INF = 1<<29;
	Map<Integer, Double>[] map;
	
	double calc(double x1, double y1, double x2, double y2){
		return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
	}
	
	@SuppressWarnings("unchecked")
	void run(){
		Scanner sc = new Scanner(System.in);
		int[] xs = new int[100], ys = new int[100], y = new int[5000];
		double[] x = new double[5000];
		for(;;){
			int n = sc.nextInt();
			if(n==0)break;
			Set<Integer> yset = new HashSet<Integer>();
			for(int i=0;i<n;i++){
				xs[i] = sc.nextInt();
				yset.add(ys[i]=sc.nextInt());
			}
			int[] Y = new int[yset.size()];
			int id = 0;
			for(int yy:yset)Y[id++]=yy;
			Arrays.sort(Y);
			id = 0;
			for(int i=0;i+1<n;i++){
				if(ys[i]==ys[i+1]){
					x[id] = xs[i];
					y[id++] = ys[i];
				}
				else if(ys[i]<ys[i+1]){
					for(int j=0;j<Y.length&&Y[j]<ys[i+1];j++){
						if(Y[j]<ys[i])continue;
						x[id] = (xs[i+1]-xs[i])*(Y[j]-ys[i]+0.)/(ys[i+1]-ys[i]) + xs[i];
						y[id++] = Y[j];
					}
				}
				else{
					for(int j=Y.length-1;j>=0&&Y[j]>ys[i+1];j--){
						if(Y[j]>ys[i])continue;
						x[id] = (xs[i+1]-xs[i])*(Y[j]-ys[i]+0.)/(ys[i+1]-ys[i]) + xs[i];
						y[id++] = Y[j];
					}
				}
			}
			x[id] = xs[n-1];
			y[id++] = 0;
			map = new Map[id];
			for(int i=0;i<id;i++)map[i]=new HashMap<Integer, Double>();
			map[0].put(id-1, 0.);
			PriorityQueue<int[]> q = new PriorityQueue<int[]>(id, new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
					return (int)Math.signum(map[o1[0]].get(o1[1]) - map[o2[0]].get(o2[1]));
				}
			});
			q.add(new int[]{0, id-1});
			double res = INF;
			while(!q.isEmpty()){
				int[] V = q.poll();
				int i = V[0], j = V[1];
				if(i==j){
					res = map[i].get(j); break;
				}
				for(int di=-1;di<=1;di++){
					int ni = i+di;
					if(ni<0 || id<=ni)continue;
					for(int dj=-1;dj<=1;dj++){
						int nj = j+dj;
						if(nj<0 || id<=nj || nj < ni || y[ni]!=y[nj])continue;
						double w = map[i].get(j) + calc(x[i], y[i], x[ni], y[ni]) + calc(x[j], y[j], x[nj], y[nj]);
						if(!map[ni].containsKey(nj) || w < map[ni].get(nj)){
							map[ni].put(nj, w);
							q.add(new int[]{ni, nj});
						}
					}
				}
			}
			System.out.println(res);
		}
	}
	
	public static void main(String[] args) {
		new AOJ1309().run();
	}
}
