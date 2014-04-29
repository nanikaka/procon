package volume10;

import java.util.Arrays;
import java.util.Scanner;

//Old Bridges
public class AOJ1052 {

	class R implements Comparable<R>{
		int a, b;
		public R(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}
		public int compareTo(R o) {
			return b-o.b;
		}
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			R[] r = new R[n];
			for(int i=0;i<n;i++)r[i]=new R(sc.nextInt(), sc.nextInt());
			Arrays.sort(r);
			int s = 0;
			boolean f = true;
			for(int i=0;i<n;i++){
				s += r[i].a;
				if(r[i].b < s)f = false;
			}
			System.out.println(f?"Yes":"No");
		}
	}
	
	public static void main(String[] args) {
		new AOJ1052().run();
	}
}
