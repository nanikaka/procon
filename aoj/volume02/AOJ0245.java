package volume02;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

//Time Sale
public class AOJ0245 {

	int h, w, INF = 1<<29, n, si, sj;
	int[][] d = {{-1,0},{0,1},{1,0},{0,-1}};
	int[][] a, wf;
	int[][][] dp;
	int[] s, f, dis, sum;
	Set<Integer>[] set;
	
	int get(int i, int j, int S){
		if(dp[i][j][S]!=-1)return dp[i][j][S];
		if(S==0)return INF;
		int min = INF;
		for(int last=0;last<10;last++)if(((S>>last)&1)>0){
			if(!set[last].contains(i*w+j))continue;
			int sub = S-(1<<last);
			if(sub==0){
				int m = wf[i*w+j][si*w+sj];
				while(m < f[last]){
					if(s[last]<=m)break;
					m+=2;
				}
				if(f[last]<=m)m = INF;
				min = m;
				break;
			}
			for(int p=0;p<h*w;p++){
				if(a[p/w][p%w]!=-1)continue;
				int m = get(p/w, p%w, sub) + wf[i*w+j][p];
				while(m < f[last]){
					if(s[last]<=m)break;
					m+=2;
				}
				if(f[last]<=m)m = INF;
				min = Math.min(min, m);
			}
		}
		return dp[i][j][S] = min;
	}
	
	@SuppressWarnings("unchecked")
	void run(){
		dp = new int[20][20][1024];
		a = new int[20][20];
		dis = new int[10];
		s = new int[10];
		f = new int[10];
		wf = new int[400][400];
		sum = new int[1024];
		Scanner sc = new Scanner(System.in);
		for(;;){
			w = sc.nextInt(); h = sc.nextInt();
			if((w|h)==0)break;
			si = -1; sj = -1;
			for(int i=0;i<h;i++)for(int j=0;j<w;j++){
				char c = sc.next().charAt(0);
				if(c=='P'){
					si = i; sj = j; c = '.';
				}
				a[i][j] = c=='.'?-1:(c-'0');
			}
			Arrays.fill(dis, 0);
			Arrays.fill(s, 0);
			Arrays.fill(f, 0);
			n = sc.nextInt();
			for(int i=0;i<n;i++){
				int g = sc.nextInt();
				dis[g] = sc.nextInt(); s[g] = sc.nextInt(); f[g] = sc.nextInt();
			}
			set = new Set[10];
			for(int i=0;i<10;i++)set[i]=new HashSet<Integer>();
			for(int i=0;i<h;i++)for(int j=0;j<w;j++){
				if(a[i][j]!=-1)continue;
				for(int k=0;k<4;k++){
					int ni = i+d[k][0], nj = j+d[k][1];
					if(0<=ni&&ni<h&&0<=nj&&nj<w&&a[ni][nj]!=-1)set[a[ni][nj]].add(i*w+j);
				}
			}
			Arrays.fill(sum, 0);
			for(int S=0;S<1024;S++)for(int j=0;j<10;j++)if(((S>>j)&1)>0)sum[S]+=dis[j];
			for(int i=0;i<h;i++)for(int j=0;j<w;j++){
				int b = i*w+j;
				for(int p=0;p<h*w;p++)wf[b][p] = INF;
				Queue<Integer> q = new LinkedList<Integer>();
				wf[b][b] = 0;
				q.add(b);
				while(!q.isEmpty()){
					int V = q.poll();
					for(int k=0;k<4;k++){
						int ni = V/w+d[k][0], nj = V%w+d[k][1];
						if(0<=ni&&ni<h&&0<=nj&&nj<w&&a[ni][nj]==-1&&wf[b][ni*w+nj]==INF){
							wf[b][ni*w+nj] = wf[b][V]+1;
							q.add(ni*w+nj);
						}
					}
				}
			}
			for(int i=0;i<h;i++)for(int j=0;j<w;j++)for(int S=0;S<1024;S++)dp[i][j][S]=-1;
			dp[si][sj][0] = 0;
			int res = 0;
			for(int i=0;i<h;i++)for(int j=0;j<w;j++){
				if(a[i][j]!=-1)continue;
				for(int S=1023;S>0;S--){
					if(sum[S]<=res)continue;
					if(get(i, j, S)<INF)res = sum[S];
				}
			}
			System.out.println(res);
		}
	}
	
	public static void main(String[] args) {
		new AOJ0245().run();
	}
}
