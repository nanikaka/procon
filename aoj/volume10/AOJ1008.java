package volume10;

import java.util.HashMap;
import java.util.Map;

//What Color Is The Universe?
public class AOJ1008 {

	public static class Scanner {
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
		long nextLong() {
			try {
				int c = System.in.read();
				while (c != '-' && (c < '0' || '9' < c))
					c = System.in.read();
				if (c == '-') return -nextLong();
				long res = 0;
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
		String nextLine(){
			try{
				StringBuilder res =new StringBuilder("");
				int c = System.in.read();
				while (c=='\r' || c=='\n')
					c = System.in.read();
				do {
					res.append((char) c);
					c = System.in.read();
				} while (c!='\r' && c!='\n');
				return res.toString();
			}catch (Exception e) {
				return null;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner();
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			String a = "NO COLOR";
			boolean f = false;
			int[] c = new int[n];
			int id = 0;
			Map<Integer, Integer> m = new HashMap<Integer, Integer>();
			for(int i=0;i<n;i++){
				int x = sc.nextInt();
				if(!f){
					if(!m.containsKey(x)){
						m.put(x, id++);
					}
					int ref = m.get(x);
					c[ref]++;
					if(!f && c[ref]>n>>1){
						f = true;
						a = x+"";
					}
				}
			}
			System.out.println(a);
		}
	}
}
