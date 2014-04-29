package volume22;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//Consistet Unit System
public class AOJ2207 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			int id = 0;
			Map<String, Integer> ref = new HashMap<String, Integer>();
			int[][] cost = new int[2*n][2*n];
			for(int[]c:cost)Arrays.fill(c, 1<<28);
			for(int i=0;i<n;i++){
				sc.next();
				String s = sc.next();
				if(!ref.containsKey(s)){
					ref.put(s, id++);
				}
				int to = ref.get(s);
				sc.next();
				String[] num = sc.next().split("\\^");
				int c = Integer.parseInt(num[1]);
				s = sc.next();
				if(!ref.containsKey(s))ref.put(s, id++);
				int from = ref.get(s);
				cost[from][to] = c;
				cost[to][from] = -c;
			}
			int[][] wf = new int[id][id];
			for(int[] w:wf)Arrays.fill(w, 1<<28);
			for(int i=0;i<id;i++)for(int j=0;j<id;j++)wf[i][j]=cost[i][j];
			for(int k=0;k<id;k++){
				for(int i=0;i<id;i++){
					for(int j=0;j<id;j++){
						wf[i][j] = Math.min(wf[i][j], wf[i][k]+wf[k][j]);
					}
				}
			}
			boolean f = true;
			for(int i=0;i<id;i++){
				for(int j=0;j<id;j++){
					if(cost[i][j]!=1<<28 && wf[i][j] < cost[i][j]){
						f = false;
						break;
					}
				}
			}
			System.out.println(f?"Yes":"No");
		}
	}
}
