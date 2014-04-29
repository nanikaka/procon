package volume10;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

//Provident Housewife
public class AOJ1048 {

	int[][] dist, wf;
	
	void run(){
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			Map<String, Integer> ref = new HashMap<String, Integer>();
			int[][] s = new int[n+1][];
			int[][] p = new int[n+1][1000];
			int[] num = new int[n+1];
			int ID = 0;
			for(int i=1;i<=n;i++){
				num[i] = sc.nextInt();
				s[i] = new int[num[i]];
				Arrays.fill(p[i], 1<<29);
				for(int j=0;j<num[i];j++){
					String item = sc.next();
					int id = -1;
					if(ref.containsKey(item))id = ref.get(item);
					else{
						id = ID;
						ref.put(item, ID++);
					}
					p[i][id] = sc.nextInt();
				}
			}
			int q = sc.nextInt();
			int[] need = new int[q];
			boolean enable = true;
			for(int i=0;i<q;i++){
				String item = sc.next();
				if(!ref.containsKey(item)){
					enable = false;
				}
				if(!enable)continue;
				need[i] = ref.get(item);
			}
			wf = new int[n+1][n+1];
			for(int i=0;i<=n;i++)Arrays.fill(wf[i], 1<<29);
			for(int i=0;i<=n;i++)wf[i][i] = 0;
			int m = sc.nextInt();
			for(int i=0;i<m;i++){
				int a = sc.nextInt();
				int b = sc.nextInt();
				int dist = sc.nextInt();
				wf[a][b] = wf[b][a] = dist;
			}
			if(!enable){
				System.out.println("impossible");continue;
			}
			int[] has = new int[n+1];
			for(int i=1;i<=n;i++){
				for(int j=0;j<q;j++){
					if(p[i][need[j]]!=1<<29)has[i]|=1<<j;
				}
			}
			int[] price = new int[1<<(n+1)];
			int Q = (1<<q)-1;
			int opt = 1<<29;
			for(int i=0;i<1<<(n+1);i++){
				int state = 0;
				for(int j=0;j<=n;j++)if((i>>j&1)>0)state|=has[j];
				if(state!=Q){
					price[i] = 1<<29;
					continue;
				}
				int sum = 0;
				for(int j=0;j<q;j++){
					int mm = 1<<24;
					for(int k=1;k<=n;k++){
						if((i>>k&1)==0)continue;
						mm = Math.min(mm, p[k][need[j]]);
					}
					sum += mm;
				}
				price[i] = sum;
				opt = Math.min(opt, price[i]);
			}
			for(int k=0;k<=n;k++){
				for(int i=0;i<=n;i++){
					for(int j=0;j<=n;j++){
						wf[i][j] = Math.min(wf[i][j], wf[i][k]+wf[k][j]);
					}
				}
			}
			dist = new int[1<<(n+1)][n+1];
			for(int i=0;i<1<<n+1;i++)Arrays.fill(dist[i], 1<<29);
			dist[1][0] = 0;
			PriorityQueue<int[]> que = new PriorityQueue<int[]>(n, new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
					return dist[o1[0]][o1[1]]+wf[o1[1]][0]-dist[o2[0]][o2[1]]-wf[o2[1]][0];
				}
			});
			que.add(new int[]{1, 0});
			int min = 1<<29;
			while(!que.isEmpty()){
				int[] a = que.poll();
				int state = a[0];
				int last = a[1];
				if(price[state]==opt){
					min = Math.min(min, dist[state][last]+wf[last][0]);
				}
				for(int i=0;i<=n;i++){
					if(wf[last][i]==1<<29||(state>>i&1)>0)continue;
					int ns = state | 1<<i;
					int v = dist[state][last] + wf[last][i];
					if(v<dist[ns][i]){
						dist[ns][i] = v;
						que.add(new int[]{ns, i});
					}
				}
			}
			System.out.println(opt+" "+min);
		}
	}
	
	public static void main(String[] args) {
		new AOJ1048().run();
	}
}
