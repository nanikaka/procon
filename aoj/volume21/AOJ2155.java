package volume21;

import java.util.Arrays;
import java.util.Scanner;

//Infected Computer
public class AOJ2155 {

	class L implements Comparable<L>{
		long t;
		int from, to;
		L(long t,int from,int to){
			this.t = t;
			this.from = from;
			this.to = to;
		}
		public int compareTo(L o) {
			return (int) (this.t - o.t);
		}
	}

	void run() {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			int m = sc.nextInt();
			if((n|m) == 0) break;
			boolean infected[] = new boolean[n];
			infected[0] = true;
			L logs[] = new L[m];
			for(int i=0; i<m; i++){
				long t = sc.nextLong();
				int from = sc.nextInt() -1;
				int to = sc.nextInt() -1;
				logs[i] = new L(t,from,to);
			}
			Arrays.sort(logs);
			for(int i=0; i<m; i++)
				if(infected[logs[i].from])
					infected[logs[i].to] = true;

			int count = 0;
			for(int i=0; i<n; i++)
				if(infected[i])
					count++;
			System.out.println(count);
		}
	}
	public static void main(String[] args) {
		new AOJ2155().run();
	}

}
