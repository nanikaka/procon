package volume11;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//Cut the Cakes
public class AOJ1149 {
	
	static class C implements Comparable<C>{
		public int w;
		public int d;
		public int cutTime;
		public C(int w, int d, int cutTime) {
			this.w = w;
			this.d = d;
			this.cutTime = cutTime;
		}
		public int compareTo(C o) {
			if(cutTime==o.cutTime)return w*d-o.w*o.d;
			return cutTime-o.cutTime;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			int w = sc.nextInt();
			int d = sc.nextInt();
			if((n|w|d)==0)break;
			C[] cake = new C[1];
			cake[0] = new C(w, d, 0);
			for(int i=1;i<=n;i++){
				C[] next = new C[i+1];
				int id = sc.nextInt()-1;
				int s = sc.nextInt();
				C target = cake[id];
				int j=0;
				for(int k=0;k<i;k++){
					if(k!=id)next[j++]=cake[k];
				}
				s %= 2*(target.w+target.d);
				if(0<=s&&s<=target.w){
					next[j++] = new C(target.w-s, target.d, i);
					next[j++] = new C(s, target.d, i);
				}
				else if(target.w <= s && s <= target.w + target.d){
					next[j++] = new C(target.w, s-target.w, i);
					next[j++] = new C(target.w, target.d-(s-target.w), i);
				}
				else if(target.w + target.d <= s && s <= target.w*2 + target.d){
					next[j++] = new C(s-(target.w+target.d), target.d, i);
					next[j++] = new C(target.w-(s-(target.w+target.d)), target.d, i);
				}
				else {
					next[j++] = new C(target.w, s-(target.w*2+target.d), i);
					next[j++] = new C(target.w, target.d-(s-(target.w*2+target.d)), i);
				}
				cake = next;
				Arrays.sort(cake);
			}
			Arrays.sort(cake, new Comparator<C>() {
				public int compare(C o1, C o2) {
					return o1.w*o1.d-o2.w*o2.d;
				}
			});
			for(int i=0;i<cake.length;i++){
				if(i==0)System.out.print(cake[i].w*cake[i].d);
				else System.out.print(" " + cake[i].w*cake[i].d);
			}
			System.out.println();
		}
	}
}
