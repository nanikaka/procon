package volume0;

import java.util.Scanner;

//Era Name Transformation
public class AOJ0083 {

	static class E implements Comparable<E>{
		public int y,m,d;
		public E(int y, int m, int d) {
			this.y = y;
			this.m = m;
			this.d = d;
		}
		public int compareTo(E o) {
			return y!=o.y?y-o.y:m!=o.m?m-o.m:d-o.d;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		E[] e = {new E(1868,9,7), new E(1912,7,29), new E(1926,12,24), new E(1989,1,7)};
		int[] t = {0,1867,1911,1925,1988};
		String[] n = {"pre-meiji","meiji","taisho","showa","heisei"};
		while(sc.hasNext()){
			E f = new E(sc.nextInt(),sc.nextInt(),sc.nextInt());
			int k=0;
			while(k<4&&f.compareTo(e[k])>0)k++;
			if(k==0)System.out.println(n[k]);
			else System.out.println(n[k]+" "+(f.y-t[k])+" "+f.m+" "+f.d);
		}
	}
}
