package volume01;

import java.util.Arrays;
import java.util.Scanner;

//Baseball Championship
public class AOJ0196 {

	static class T implements Comparable<T>{
		int id, w, l;
		char s;
		public T(int id, char s, int w, int l) {
			this.id = id;
			this.w = w;
			this.l = l;
			this.s = s;
		}
		public int compareTo(T o) {
			return w!=o.w?o.w-w:l!=o.l?l-o.l:id-o.id;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			T[] t = new T[n];
			for(int i=0;i<n;i++){
				char s = sc.next().charAt(0);
				int w = 0;
				int l = 0;
				for(int j=0;j<n-1;j++){
					int x = sc.nextInt();
					w += x==0?1:0;
					l += x==1?1:0;
				}
				t[i] = new T(i, s, w, l);
			}
			Arrays.sort(t);
			for(int i=0;i<n;i++)System.out.println(t[i].s);
		}
	}
}
