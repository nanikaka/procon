package volume24;

import java.util.Arrays;
import java.util.Comparator;

//Village
public class AOJ2412 {

	class Scanner {
		int nextInt() {
			try {
				int c = System.in.read();
				while (c != '-' && (c < '0' || '9' < c))
					c = System.in.read();
				if (c == '-') return -nextInt();
				int res = 0;
				do {
					res *= 10;
					res += c - '0';
					c = System.in.read();
				} while ('0' <= c && c <= '9');
				return res;
			} catch (Exception e) {
				return -1;
			}
		}
		double nextDouble() {
			return Double.parseDouble(next());
		}
		String next() {
			try {
				StringBuilder res = new StringBuilder("");
				int c = System.in.read();
				while (Character.isWhitespace(c))
					c = System.in.read();
				do {
					res.append((char) c);
				} while (!Character.isWhitespace(c = System.in.read()));
				return res.toString();
			} catch (Exception e) {
				return null;
			}
		}
	}
	
	double[] x, y;
	
	void run(){
		Scanner sc = new Scanner();
		int n = sc.nextInt();
		double R = sc.nextDouble(), EPS = 1e-8;
		double cos1 = Math.cos(1*Math.PI/180), sin1 = Math.sin(1*Math.PI/180);
		x = new double[n]; y = new double[n];
		for(int i=0;i<n;i++){
			double X = sc.nextDouble(), Y = sc.nextDouble();
			x[i] = cos1*X-sin1*Y;
			y[i] = sin1*X+cos1*Y;
		}
		Integer[] V = new Integer[n];
		for(int i=0;i<n;i++)V[i]=i;
		Arrays.sort(V, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return (int)Math.signum(x[o1]-x[o2]);
			}
		});
		int[] v = new int[n];
		for(int i=0;i<n;i++)v[i]=V[i];
		int res = 0;
		boolean[] u = new boolean[n];
		for(int i=0;i<n;i++){
			int idx = v[i];
			if(u[idx])continue;
			u[idx] = true;
			res++;
			double lx = x[idx]-R-EPS;
			int l = 0, r = n;
			while(r-l>1){
				int m = (l+r)/2;
				if(lx<=x[v[m]])r=m;
				else l=m;
			}
			for(int j=l;j<n;j++){
				int k = v[j];
				if(x[idx]+R+EPS<x[k])break;
				if(u[k])continue;
				if((x[idx]-x[k])*(x[idx]-x[k]) + (y[idx]-y[k])*(y[idx]-y[k]) < R*R + EPS){
					u[k] = true;
				}
			}
		}
		System.out.println(res);
	}
	
	public static void main(String[] args) {
		new AOJ2412().run();
	}
}
