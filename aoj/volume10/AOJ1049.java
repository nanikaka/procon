package volume10;

import java.util.Arrays;
import java.util.Scanner;

//Building Houses
public class AOJ1049 {

	int n, res, INF = 1<<29;
	int[][] a;
	int[] p;
	boolean[] u;
	int[] mem;
	
	int get(int S){
		if(mem[S]!=-1)return mem[S];
		if(Integer.bitCount(S)<2)return mem[S] = 0;
		int min = 0;
		for(int i=0;i<n;i++)if(!u[i]){
			int m = INF;
			for(int j=0;j<n;j++)if(!u[j] && i!=j){
				m = Math.min(m, a[i][j]);
			}
			min+=m;
		}
		return mem[S] = min/2;
	}
	
	void f(int k, int last, int S){
		if(res<=last+get(S))return;
		if(k==n){
			res = Math.min(res, last); return;
		}
		for(int i=0;i<n;i++)if(!u[i]){
			p[i] = 0;
			if(k!=0){
				p[i] = INF;
				for(int j=0;j<n;j++)if(u[j]){
					int pos = p[j] + a[j][i];
					if(pos<=last)continue;
					boolean ok = true;
					for(int x=0;x<n;x++)if(u[x] && Math.abs(pos-p[x])<a[x][i])ok=false;
					if(ok)p[i] = Math.min(p[i], pos);
				}
			}
			u[i] = true;
			f(k+1, p[i], S-(1<<i));
			u[i] = false;
		}
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			n = sc.nextInt();
			if(n==0)break;
			a = new int[n][n];
			for(int i=0;i<n;i++)for(int j=0;j<n;j++)a[i][j] = a[j][i] = Math.max(sc.nextInt(), Math.max(a[i][j], a[j][i]));
			res = INF;
			p = new int[n];
			u = new boolean[n];
			mem = new int[1<<n];
			Arrays.fill(mem, -1);
			f(0, 0, (1<<n)-1);
			System.out.println(res);
		}
	}
	
	public static void main(String[] args) {
		new AOJ1049().run();
	}
}
