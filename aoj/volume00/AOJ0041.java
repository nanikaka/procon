package volume0;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Expression
public class AOJ0041 {

	static int[] a;
	static int[] order;
	static boolean[] used;
	static String s;

	static class E{
		public int x;
		public String e;
		public E(int x, String e) {
			this.x = x;
			this.e = e;
		}
	}

	static List<E> g(int[] a, int l, int r){
		List<E> result = new ArrayList<E>();
		if(r-l==0){
			result.add(new E(a[l], ""+a[l]));
			return result;
		}
		if(r-l==1){
			result.add(new E(a[l]+a[r], "("+a[l]+" + "+a[r]+")"));
			result.add(new E(a[l]-a[r], "("+a[l]+" - "+a[r]+")"));
			result.add(new E(a[l]*a[r], "("+a[l]+" * "+a[r]+")"));
			return result;
		}
		if(r-l==2){
			List<E> t = g(a, l+1, r);
			for(E e:t){
				result.add(new E(a[l]+e.x, "("+a[l]+" + "+e.e+")"));
				result.add(new E(a[l]-e.x, "("+a[l]+" - "+e.e+")"));
				result.add(new E(a[l]*e.x, "("+a[l]+" * "+e.e+")"));
			}
			t = g(a, l, r-1);
			for(E e:t){
				result.add(new E(e.x+a[r], "("+e.e+" + "+a[r]+")"));
				result.add(new E(e.x-a[r], "("+e.e+" - "+a[r]+")"));
				result.add(new E(e.x*a[r], "("+e.e+" * "+a[r]+")"));
			}
			return result;
		}
		for(int i=l;i<r;i++){
			List<E> t1 = g(a, l, i);
			List<E> t2 = g(a, i+1, r);
			for(E e1:t1){
				for(E e2:t2){
					result.add(new E(e1.x+e2.x, "("+e1.e+" + "+e2.e+")"));
					result.add(new E(e1.x-e2.x, "("+e1.e+" - "+e2.e+")"));
					result.add(new E(e1.x*e2.x, "("+e1.e+" * "+e2.e+")"));
				}
			}
		}
		return result;
	}

	static void f(int k){
		if(!s.equals(""))return;
		if(k==4){
			int[] t = new int[4];
			for(int i=0;i<4;i++)t[i]=a[order[i]];
			for(E e:g(t,0,3)){
				if(e.x==10){
					s = e.e;
					break;
				}
			}
			return;
		}
		for(int i=0;i<4;i++){
			if(!used[i]){
				used[i] = true;
				order[k] = i;
				f(k+1);
				used[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			a = new int[4];
			for(int i=0;i<4;i++)a[i]=sc.nextInt();
			if((a[0]|a[1]|a[2]|a[3])==0)break;
			order = new int[4];
			used = new boolean[4];
			s = "";
			f(0);
			System.out.println(s.equals("")?"0":s);
		}
	}
}
