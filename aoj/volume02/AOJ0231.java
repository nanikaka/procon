package volume02;

import java.util.PriorityQueue;
import java.util.Scanner;

//Dangerous Bridge
public class AOJ0231 {

	public static class E implements Comparable<E>{
		public boolean on;
		public int w;
		public int t;
		public E(boolean on, int w, int t) {
			this.on = on;
			this.w = w;
			this.t = t;
		}
		public int compareTo(E o) {
			if(o.t == t){
				return on?1:-1;
			}
			return t-o.t;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			PriorityQueue<E> q = new PriorityQueue<E>();
			for(int i=0;i<n;i++){
				int w = sc.nextInt();
				q.add(new E(true, w, sc.nextInt()));
				q.add(new E(false, w, sc.nextInt()));
			}
			int s = 0;
			boolean f = true;
			while(!q.isEmpty()){
				E e = q.poll();
				if(e.on){
					s += e.w;
					if(s>150){
						f = false;
						break;
					}
				}
				else{
					s -= e.w;
				}
			}
			System.out.println(f?"OK":"NG");
		}
	}
}
