package volume12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

//True Liars
public class AOJ1238 {

	int m, p1, p2, n, c1, c2, idx;
	Set<Integer>[] yes, no;
	boolean[] u;
	int[] id, mark;
	
	void f(int k, int x){
		if(u[k])return;
		if(x==0)c1++;
		else c2++;
		u[k] = true;
		id[k] = idx;
		mark[k] = x;
		for(int v:yes[k])f(v, x);
		for(int v:no[k])f(v, 1-x);
	}
	
	class R{
		int s, t;
		public R(int s, int t) {
			this.s = s;
			this.t = t;
		}
	}
	
	@SuppressWarnings("unchecked")
	void run(){
		Scanner sc = new Scanner(System.in);
		yes = new Set[600];
		no = new Set[600];
		u = new boolean[600];
		id = new int[600];
		mark = new int[600];
		for(;;){
			m = sc.nextInt(); p1 = sc.nextInt(); p2 = sc.nextInt();
			if((m|p1|p2)==0)break;
			n = p1+p2;
			for(int i=0;i<n;i++){
				yes[i] = new HashSet<Integer>();
				no[i] = new HashSet<Integer>();
			}
			while(m--!=0){
				int s = sc.nextInt()-1, t = sc.nextInt()-1;
				String r = sc.next();
				if("yes".equals(r)){
					yes[s].add(t); yes[t].add(s);
				}
				else{
					no[s].add(t); no[t].add(s);
				}
			}
			Arrays.fill(u, false);
			Arrays.fill(id, 0);
			Arrays.fill(mark, 0);
			List<R> list = new ArrayList<R>();
			idx = 0;
			for(int i=0;i<n;i++){
				c1 = c2 = 0;
				f(i, 0);
				if(0<c1+c2){
					idx++;
					list.add(new R(c1, c2));
				}
			}
			int N = list.size();
			int[][] dp = new int[N+1][p1+1];
			dp[0][0] = 1;
			for(int i=1;i<=N;i++){
				R r = list.get(i-1);
				for(int j=0;j<=p1;j++){
					if(r.s<=j)dp[i][j]+=dp[i-1][j-r.s];
					if(r.t<=j)dp[i][j]+=dp[i-1][j-r.t];
				}
			}
			if(dp[N][p1]!=1){
				System.out.println("no"); continue;
			}
			List<Integer> res = new ArrayList<Integer>();
			for(int i=N-1;i>=0;i--){
				R r = list.get(i);
				if(r.s<=p1 && dp[i][p1-r.s]==1){
					p1-=r.s;
					for(int j=0;j<n;j++)if(id[j]==i&&mark[j]==0)res.add(j);
				}
				else{
					p1-=r.t;
					for(int j=0;j<n;j++)if(id[j]==i&&mark[j]==1)res.add(j);
				}
			}
			Collections.sort(res);
			for(int x:res)System.out.println(x+1);
			System.out.println("end");
		}
	}
	
	public static void main(String[] args) {
		new AOJ1238().run();
	}
}
