package volume22;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//Seishun 18 Kippu
public class AOJ2283 {

	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			int n = sc.nextInt();
			int m = sc.nextInt();
			if((n|m)==0)break;
			Map<String, Integer> ref = new HashMap<String, Integer>();
			int id = 0;
			int s = id; ref.put(sc.next(), id++);
			int p = id; ref.put(sc.next(), id++);
			int g = id; ref.put(sc.next(), id++);
			int[][] e = new int[n][n];
			for(int[]a:e)Arrays.fill(a, 1<<29);
			while(m--!=0){
				String A = sc.next();
				String B = sc.next();
				int a = -1, b = -1;
				if(ref.containsKey(A))a = ref.get(A);
				else {
					a = id; ref.put(A, id++);
				}
				if(ref.containsKey(B))b = ref.get(B);
				else{
					b = id; ref.put(B, id++);
				}
				int d = sc.nextInt(), t = sc.nextInt();
				e[a][b] = e[b][a] = d/40+t;
			}
			for(int k=0;k<n;k++)for(int i=0;i<n;i++)for(int j=0;j<n;j++)e[i][j] = Math.min(e[i][j], e[i][k]+e[k][j]);
			System.out.println(e[s][p]+e[p][g]);
		}
	}
	
	public static void main(String[] args) {
		new AOJ2283().run();
	}
}
