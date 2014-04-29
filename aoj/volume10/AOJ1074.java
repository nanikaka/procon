package volume10;

import java.util.Arrays;
import java.util.Scanner;

//Popularity Estimation
public class AOJ1074 {

	class R implements Comparable<R>{
		String name;
		int p;
		public R(String name) {
			this.name = name;
		}
		public int compareTo(R o) {
			return p==o.p?name.compareTo(o.name):p-o.p;
		}
	}
	
	void run(){
		Scanner sc =  new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			R[] r = new R[n];
			boolean[][] u = new boolean[n][30];
			int[] num = new int[30];
			for(int i=0;i<n;i++){
				r[i] = new R(sc.next());
				int m = sc.nextInt();
				while(m--!=0){
					int d = sc.nextInt();
					u[i][d] = true;
					num[d]++;
				}
			}
			for(int i=0;i<n;i++){
				for(int j=0;j<30;j++){
					if(u[i][j]){
						r[i].p += n-num[j]+1;
					}
				}
			}
			Arrays.sort(r);
			System.out.println(r[0].p+" "+r[0].name);
		}
	}
	
	public static void main(String[] args) {
		new AOJ1074().run();
	}
}
