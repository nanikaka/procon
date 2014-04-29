package volume01;

import java.util.Arrays;
import java.util.Scanner;

//What is the Most Popular Shop in Tokaichi?
public class AOJ0195 {

	static class E implements Comparable<E>{
		char a;
		int s;
		public E(char a, int s) {
			this.a = a;
			this.s = s;
		}
		public int compareTo(E o) {
			return o.s-s;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int s = sc.nextInt()+sc.nextInt();
			if(s==0)break;
			E[] e = new E[5];
			e[0]=new E('A',s);
			for(int i=1;i<5;i++)e[i]=new E((char)(i+'A'),sc.nextInt()+sc.nextInt());
			Arrays.sort(e);
			System.out.println(e[0].a+" "+e[0].s);
		}
	}
}
