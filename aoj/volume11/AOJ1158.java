package volume11;

import java.util.Arrays;
import java.util.Scanner;

//ICPC: Intelligent Congruent Partition of Chocolate
public class AOJ1158 {

	int w, h, si, sj, ti, tj, N, c;
	int[][] a;
	int[] sum;
	boolean[][] u;
	int[][] d = {{-1,0},{0,1},{1,0},{0,-1}};

	boolean cancel(int t){
		if(t<0)return false;
		int i = t/w, j = t%w;
		if(a[i][j]!=-1)return false;
		int cnt = 0;
		for(int k=0;k<4;k++){
			int ni = i+d[k][0], nj = j+d[k][1];
			if(0<=ni&&ni<h&&0<=nj&&nj<w&&a[ni][nj]==-1)cnt++;
		}
		return cnt==0;
	}
	
	boolean dfs(int i, int j, int rot, int rev, int num){
		if(num==(N>>1)){
			for(boolean[]v:u)Arrays.fill(v, false);
			c = 0;
			check(si, sj, -1);
			if(c!=(N>>1))return false;
			c = 0;
			check(ti, tj, -2);
			return c==(N>>1);
		}
		if(i==h || (N>>1)-num > sum[i*w+j] || cancel(i*w+j-w-1))return false;
		if(j==w)return dfs(i+1, 0, rot, rev, num);
		if(a[i][j]==1){
			a[i][j] = -1;
			int di = i-si, dj = j-sj;
			int ni, nj;
			if(rot==0){
				ni = di; nj = dj;
			}
			else if(rot==1){
				ni = dj; nj = -di;
			}
			else if(rot==2){
				ni = -di; nj = -dj;
			}
			else{
				ni = -dj; nj = di;
			}
			if(rev==1)nj*=-1;
			int ki = ti+ni, kj = tj+nj;
			if(0<=ki&&ki<h&&0<=kj&&kj<w&&a[ki][kj]==1){
				a[ki][kj] = -2;
				if(dfs(i, j+1, rot, rev, num+1))return true;
				a[ki][kj] = 1;
			}
			a[i][j] = 1;
		}
		return dfs(i, j+1, rot, rev, num);
	}
	
	void check(int i, int j, int x){
		if(u[i][j])return;
		u[i][j] = true;
		c++;
		for(int k=0;k<4;k++){
			int ni = i+d[k][0], nj = j+d[k][1];
			if(ni < 0 || h <= ni || nj < 0 || w <= nj || a[ni][nj]!=x)continue;
			check(ni, nj, x);
		}
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			w = sc.nextInt(); h = sc.nextInt();
			if((w|h)==0)break;
			N = 0;
			a = new int[h][w];
			u = new boolean[h][w];
			sum = new int[h*w+1];
			si = sj = -1;
			for(int i=0;i<h;i++)for(int j=0;j<w;j++){
				a[i][j] = sc.nextInt();
				if(a[i][j]==1){
					N++;
					if(si==-1){
						si = i; sj = j;
					}
				}
			}
			if((N&1)==1){
				System.out.println("NO"); continue;
			}
			for(int i=h-1;i>=0;i--)for(int j=w-1;j>=0;j--)sum[i*w+j] = sum[i*w+j+1]+a[i][j];
			boolean res = false;
			a[si][sj] = -1;
			for(int i=0;i<h;i++)for(int j=0;j<w;j++)if(a[i][j]==1){
				ti = i; tj = j;
				a[i][j] = -2;
				for(int rot=0;rot<4;rot++)for(int rev=0;rev<2;rev++){
					if(dfs(0, 0, rot, rev, 1)){
						res = true;
					}
					if(res)break;
				}
				a[i][j] = 1;
			}
			System.out.println(res?"YES":"NO");
		}
	}
	
	public static void main(String[] args) {
		new AOJ1158().run();
	}
}
