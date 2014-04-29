package volume02;

import java.util.Scanner;

//Aizu Buried Treasure
public class AOJ0234 {

	int INF = 1<<29;
	int w, h, f, m, o;
	int[][] a;
	int[][][] dp, mem;
	
	int get(int H, int S, int p, int rest){
		if(rest<=1||p<0||w<=p)return INF;
		if(mem[S][p][rest]!=INF)return mem[S][p][rest];
		int res = INF;
		if(p-1>=0){
			int np = p-1, ns = S|(1<<np), nr = rest-1, c = 0;
			if(((S>>np)&1)==0){
				if(a[H][np]>0)nr = Math.min(m, nr+a[H][np]);
				else c+=-a[H][np];
			}
			res = Math.min(res, c+get(H, ns, np, nr));
		}
		if(p+1<w){
			int np = p+1, ns = S|(1<<np), nr = rest-1, c = 0;
			if(((S>>np)&1)==0){
				if(a[H][np]>0)nr = Math.min(m, nr+a[H][np]);
				else c+=-a[H][np];
			}
			res = Math.min(res, c+get(H, ns, np, nr));
		}
		int np = p, ns = 1<<p, nr = rest-1, c = 0;
		if(a[H+1][np]>0)nr = Math.min(m, nr+a[H+1][np]);
		else c+=-a[H+1][np];
		res = Math.min(res, c+dp[ns][p][nr]);
		return mem[S][p][rest] = res;
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		int INF = 1<<29;
		for(;;){
			w = sc.nextInt(); h = sc.nextInt();
			if((w|h)==0)break;
			f = sc.nextInt(); m = sc.nextInt(); o = sc.nextInt();
			a = new int[h][w];
			for(int i=0;i<h;i++)for(int j=0;j<w;j++)a[i][j]=sc.nextInt();
			dp = new int[1<<w][w][m+1];
			for(int i=0;i<1<<w;i++)for(int j=0;j<w;j++)for(int k=0;k<=m;k++)dp[i][j][k]=k==0?INF:0;
			for(int H=h-2;H>=0;H--){
				mem = new int[1<<w][w][m+1];
				for(int i=0;i<1<<w;i++)for(int j=0;j<w;j++)for(int k=0;k<=m;k++)mem[i][j][k]=INF;
				for(int j=0;j<w;j++)for(int k=0;k<=m;k++)get(H, 1<<j, j, k);
				dp = mem;
			}
			int res = INF;
			for(int j=0;j<w;j++)if(o-1>0){
				if(a[0][j]>0)res = Math.min(res, dp[1<<j][j][Math.min(m, o-1+a[0][j])]);
				else res = Math.min(res, -a[0][j]+dp[1<<j][j][o-1]);
			}
			System.out.println(f<res?"NA":res);
		}
	}

	public static void main(String[] args) {
		new AOJ0234().run();
	}
}
