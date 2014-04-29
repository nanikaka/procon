package volume10;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//Everything Starts With Your Vote
public class AOJ1080 {

	class R implements Comparable<R>{
		String s;
		int x;
		public R(String s, int x) {
			this.s = s;
			this.x = x;
		}
		int win(R r){
			return s.compareTo(r.s)<0?r.x-x:(r.x-x+1);
		}
		public int compareTo(R o) {
			return x!=o.x?o.x-x:s.compareTo(o.s);
		}
	}
	
	int N, M, K, L, B;
	R[] r;
	boolean[] fav;
	Set<String> fn;
	
	long need(int x){
		if(x<=B)return 0;
		int n = x-B, c = 0;
		int k = K-1;
		for(;;){
			if(fav[k])n++;
			else c++;
			if(c==x-B)break;
			k--;
		}
		R tar = r[k];
		long res = 0;
		for(int i=k+1;i<N&&0<n;i++){
			if(!fav[i])continue;
			n--;
			res+=r[i].win(tar);
		}
		return res;
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		fav = new boolean[100000];
		for(;;){
			N = sc.nextInt(); M = sc.nextInt(); K = sc.nextInt(); L = sc.nextInt();
			if((N|M|K|L)==0)break;
			r = new R[N];
			for(int i=0;i<N;i++)r[i]=new R(sc.next(), sc.nextInt());
			Arrays.sort(r);
			Arrays.fill(fav, false);
			fn = new HashSet<String>();
			for(int i=0;i<M;i++)fn.add(sc.next());
			B = 0;
			for(int i=0;i<N;i++){
				if(fn.contains(r[i].s)){
					fav[i] = true;
					if(i<K)B++;
				}
			}
			int left = B, right = Math.min(M, K);
			while(right-left>1){
				int m = (left+right)/2;
				if(L<need(m))right=m;
				else left=m;
			}
			System.out.println(need(right)<=L?right:left);
		}
	}
	
	public static void main(String[] args) {
		new AOJ1080().run();
	}
}
