package volume05;

import java.util.Scanner;

//Commute routes
public class AOJ0547 {

	static int[][][] dp;
	static int w;
	static int h;
	
	//k=0: start
	//k=1: right 1
	//k=2: right >= 2
	//k=3: up 1
	//k=4: up >= 2
	static int get(int i, int j, int k){
		if(dp[i][j][k]!=-1)return dp[i][j][k];
		int s = 0;
		if(k==0){
			if(i-1>=0){
				s += get(i-1, j, 4);
			}
			if(j+1<w){
				s += get(i, j+1, 2);
			}
		}
		else if(k==1){
			if(j+1<w){
				s += get(i, j+1, 2);
			}
		}
		else if(k==2){
			if(i-1>=0){
				s += get(i-1, j, 3);
			}
			if(j+1<w){
				s += get(i, j+1, 2);
			}
		}
		else if(k==3){
			if(i-1>=0){
				s += get(i-1, j, 4);
			}
		}
		else if(k==4){
			if(i-1>=0){
				s += get(i-1, j, 4);
			}
			if(j+1<w){
				s += get(i, j+1, 1);
			}
		}
		return dp[i][j][k] = s%100000;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			w = sc.nextInt();
			h = sc.nextInt();
			if((w|h)==0)break;
			dp = new int[h][w][5];
			for(int i=0;i<h;i++)for(int j=0;j<w;j++)for(int k=0;k<5;k++)dp[i][j][k]=-1;
			for(int i=0;i<h;i++){
				dp[i][w-1][2] = dp[i][w-1][3] = dp[i][w-1][4] = 1;
			}
			for(int j=0;j<w;j++)dp[0][j][1] = dp[0][j][2] = dp[0][j][4] = 1;
			System.out.println(get(h-1, 0, 0));
		}
	}
}
