package volume22;

import java.util.Scanner;

//Dungeon Quest II
public class AOJ2244 {

	void run(){
		Scanner sc = new Scanner(System.in);
		int[][] move = {{-1,0},{0,1},{1,0},{0,-1}};
		while(true){
			int hp = sc.nextInt();
			int hpmax = sc.nextInt();
			if((hp|hpmax)==0)break;
			int r = sc.nextInt();
			int c = sc.nextInt();
			char[][] map = new char[r][c];
			for(int i=0;i<r;i++)map[i]=sc.next().toCharArray();
			int[] d = new int[26];
			int T = sc.nextInt();
			for(int i=0;i<T;i++){
				char ch = sc.next().charAt(0);
				d[ch-'A'] = sc.nextInt();
			}
			int S = sc.nextInt();
			int[] s = new int[1000];
			int len = 0;
			for(int i=0;i<S;i++){
				char ch = sc.next().charAt(0);
				int k = ch=='U'?0:ch=='R'?1:ch=='D'?2:3;
				int x = sc.nextInt();
				for(int j=0;j<x;j++)s[len++]=k;
			}
			int P = sc.nextInt();
			int[] p = new int[P];
			for(int i=0;i<P;i++)p[i]=sc.nextInt();
			int[][] dp = new int[len+1][1<<P];
			dp[0][(1<<P)-1] = hp;
			int ni = 0;
			int nj = 0;
			for(int i=0;i<len;i++){
				ni += move[s[i]][0];
				nj += move[s[i]][1];
				int damage = d[map[ni][nj]-'A'];
				for(int j=0;j<1<<P;j++){
					if(dp[i][j]<=0)continue;
					if(damage==0){
						dp[i+1][j]=dp[i][j];
						continue;
					}
					for(int k=j;k>=0;k--){
						if((j|k)!=j)continue;
						int v = 0;
						for(int l=0;l<P;l++){
							if((k&(1<<l))==0)v+=p[l];
						}
//						System.out.println("PRE:" + j + " NEXT:" + k + " POTION:" + v);
						dp[i+1][k] = Math.max(dp[i+1][k], Math.min(dp[i][j]+v, hpmax)-damage);
						System.out.println("I:" + i + " K:" + k + " HP:" + dp[i+1][k]);
					}
				}
			}
			boolean f = false;
			for(int i=0;i<1<<P;i++){
				if(dp[len][i]>0){
					f=true;
					break;
				}
			}
			System.out.println(f?"YES":"NO");
		}
	}

	public static void main(String[] args) {
		new AOJ2244().run();
	}
}
