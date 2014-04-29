package volume01;

import java.util.Arrays;
import java.util.Scanner;

//Sport Meet
public class AOJ0161 {

	static class T implements Comparable<T>{
		int id, t;
		public T(int id, int t) {
			this.id = id;
			this.t = t;
		}
		public int compareTo(T o) {
			return t-o.t;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			T[] t = new T[n];
			for(int i=0;i<n;i++){
				int id = sc.nextInt();
				int s = 0;
				for(int j=0;j<4;j++)s += sc.nextInt()*60+sc.nextInt();
				t[i] = new T(id, s);
			}
			Arrays.sort(t);
			System.out.println(t[0].id+"\n"+t[1].id+"\n"+t[n-2].id);
		}
	}
}
