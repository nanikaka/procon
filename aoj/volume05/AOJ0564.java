package volume05;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

//Bug Party
public class AOJ0564 {

	class B implements Comparable<B>{
		int a, b;
		public B(int a, int b) {
			this.a = a;
			this.b = b;
		}
		public int compareTo(B o) {
			return o.b-b;
		}
	}
	
	int n;
	B[] r;
	
	boolean ok(int x){
		if(x==0)return true;
		PriorityQueue<B> q = new PriorityQueue<B>(x, new Comparator<B>() {
			public int compare(B o1, B o2) {
				return o2.a-o1.a;
			}
		});
		long A = 0;
		for(int i=0;i<x-1;i++){
			A+=r[i].a;
			q.add(r[i]);
		}
		for(int i=x-1;i<n;i++){
			long w = (long)x*r[i].b-r[i].a;
			if(A<=w)return true;
			A+=r[i].a;
			q.add(r[i]);
			A-=q.poll().a;
		}
		return false;
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		r = new B[n];
		for(int i=0;i<n;i++)r[i]=new B(sc.nextInt(), sc.nextInt());
		Arrays.sort(r);
		int L = 0, R = n;
		while(R-L>1){
			int m = (L+R)/2;
			if(ok(m))L=m;
			else R=m;
		}
		System.out.println(ok(R)?R:L);
	}
	
	public static void main(String[] args) {
		new AOJ0564().run();
	}
}
