package volume02;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//Making Sugoroku
public class AOJ0262 {
	
	boolean[] e = new boolean[252], reach = new boolean[252];
	@SuppressWarnings("unchecked")
	Set<Integer>[] next = new Set[252], rv = new Set[252];
	int max, n;
	
	void f(int v){
		if(e[v])return;
		e[v] = true;
		for(int x:rv[v])f(x);
	}
	
	void g(int v){
		if(reach[v])return;
		reach[v] = true;
		for(int x:next[v])g(x);
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<252;i++){
			next[i] = new HashSet<Integer>();
			rv[i] = new HashSet<Integer>();
		}
		for(;;){
			max = sc.nextInt();
			if(max==0)break;
			n = sc.nextInt();
			int[] d = new int[n+2];
			for(int i=1;i<=n;i++)d[i]=sc.nextInt();
			for(int i=0;i<n+2;i++){
				next[i].clear();
				rv[i].clear();
			}
			for(int i=0;i<n+1;i++)for(int m=1;m<=max;m++){
				int nx = Math.min(i+m, n+1);
				nx = Math.max(0, Math.min(nx+d[nx], n+1));
				next[i].add(nx);
				rv[nx].add(i);
			}
			Arrays.fill(e, false);
			Arrays.fill(reach, false);
			f(n+1);
			g(0);
			boolean OK = true;
			for(int i=0;i<n+2;i++)if(reach[i] && !e[i])OK = false;
			System.out.println(OK?"OK":"NG");
		}
	}
	
	public static void main(String[] args) {
		new AOJ0262().run();
	}
}
