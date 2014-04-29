package volume02;

import java.util.Scanner;

//A New Plan of Aizu Ski Resort
public class AOJ0203 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] move = {{1,-1},{1,0},{1,1}};
		while(true){
			int w = sc.nextInt();
			int h = sc.nextInt();
			if((w|h)==0)break;
			int[][] map = new int[h+1][w];
			int[][] dp = new int[h][w];
			for(int i=0;i<h;i++)for(int j=0;j<w;j++)map[i][j]=sc.nextInt();
			for(int j=0;j<w;j++)if(map[h-1][j]!=1)dp[h-1][j]=1;
			for(int i=h-2;i>=0;i--){
				for(int j=0;j<w;j++){
					if(map[i][j]==1){
						dp[i][j] = 0;
						continue;
					}
					if(map[i][j]==2){
						if(i+2==h)dp[i][j]=1;
						else dp[i][j]=dp[i+2][j];
					}
					else{
						int s = 0;
						for(int k=0;k<3;k++){
							int ni = i+move[k][0];
							int nj = j+move[k][1];
							if(0<=nj&&nj<w){
								if(k!=1 && map[ni][nj]==2)continue;
								s+=dp[ni][nj];
							}
						}
						dp[i][j]=s;
					}
				}
			}
			int s=0;
			for(int j=0;j<w;j++)s+=dp[0][j];
			System.out.println(s);
		}
	}
}
