package volume01;

import java.util.PriorityQueue;
import java.util.Scanner;

//League Match Score Sheet
public class AOJ0124 {

	static class T implements Comparable<T>{
		int k;
		int s;
		String n;
		public T(int k, String n, int s) {
			this.k = k;
			this.s = s;
			this.n = n;
		}
		public int compareTo(T o) {
			return s==o.s?k-o.k:o.s-s;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean f = true;
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			if(!f)System.out.println();
			f = false;
			PriorityQueue<T> q = new PriorityQueue<T>();
			for(int i=0;i<n;i++)q.add(new T(i,sc.next(),sc.nextInt()*3+sc.nextInt()*0+sc.nextInt()));
			while(!q.isEmpty()){
				T t = q.poll();
				System.out.println(t.n+","+t.s);
			}
		}
	}
}
