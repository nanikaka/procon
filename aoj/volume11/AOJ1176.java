package volume11;

import java.util.Scanner;

//Planning Rolling Blackouts
public class AOJ1176 {

	int h, w, s, S;
	int[][] a, sum;
	int[][][][] group, rest;

	int get(int i, int j, int k, int l){
		return sum[k][l]-sum[i-1][l]-sum[k][j-1]+sum[i-1][j-1];
	}

	void dfs(int i, int j, int k, int l){
		if(group[i][j][k][l]!=-1)return;
		if(s<S-get(i, j, k, l))return;
		group[i][j][k][l] = 1;
		rest[i][j][k][l] = s-S+get(i, j, k, l);
		for(int ni=i;ni<k;ni++){
			dfs(i, j, ni, l); dfs(ni+1, j, k, l);
			if(group[i][j][ni][l]==-1||group[ni+1][j][k][l]==-1)continue;
			if(group[i][j][k][l]<group[i][j][ni][l]+group[ni+1][j][k][l]){
				group[i][j][k][l] = group[i][j][ni][l]+group[ni+1][j][k][l];
				rest[i][j][k][l] = Math.min(rest[i][j][ni][l], rest[ni+1][j][k][l]);
			}
			else if(group[i][j][k][l]==group[i][j][ni][l]+group[ni+1][j][k][l])
				rest[i][j][k][l]=Math.max(rest[i][j][k][l], Math.min(rest[i][j][ni][l], rest[ni+1][j][k][l]));
		}
		for(int nj=j;nj<l;nj++){
			dfs(i, j, k, nj); dfs(i, nj+1, k, l);
			if(group[i][j][k][nj]==-1||group[i][nj+1][k][l]==-1)continue;
			if(group[i][j][k][l]<group[i][j][k][nj]+group[i][nj+1][k][l]){
				group[i][j][k][l] = group[i][j][k][nj]+group[i][nj+1][k][l];
				rest[i][j][k][l] = Math.min(rest[i][j][k][nj], rest[i][nj+1][k][l]);
			}
			else if(group[i][j][k][l]==group[i][j][k][nj]+group[i][nj+1][k][l])
				rest[i][j][k][l]=Math.max(rest[i][j][k][l], Math.min(rest[i][j][k][nj], rest[i][nj+1][k][l]));
		}
	}

	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			h = sc.nextInt(); w = sc.nextInt(); s = sc.nextInt();
			if((h|w|s)==0)break;
			a = new int[h+1][w+1]; sum = new int[h+1][w+1];
			for(int i=1;i<=h;i++)for(int j=1;j<=w;j++){
				a[i][j] = sc.nextInt();
				sum[i][j] = sum[i-1][j] + sum[i][j-1] + a[i][j] - sum[i-1][j-1];
			}
			group = new int[h+1][w+1][h+1][w+1]; rest = new int[h+1][w+1][h+1][w+1];
			for(int i=0;i<=h;i++)for(int j=0;j<=w;j++)for(int k=0;k<=h;k++)for(int l=0;l<=w;l++)group[i][j][k][l]=rest[i][j][k][l]=-1;
			S = get(1, 1, h, w);
			dfs(1,1,h,w);
			System.out.println(group[1][1][h][w]+" "+rest[1][1][h][w]);
		}
	}

	public static void main(String[] args) {
		new AOJ1176().run();
	}
}
