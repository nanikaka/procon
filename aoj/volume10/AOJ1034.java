package volume10;

import java.util.Scanner;

//Line Puzzle
public class AOJ1034 {

	public static int n;
	public static int[][] map;
	public static boolean[][] used;
	public static int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};
	public static int num;// number of circle
	public static int[][] p;// circle address

	public static boolean dfs(int i, int j, int k, int sum){
		if(k==num){
			for(int a=0;a<n;a++){
				for(int b=0;b<n;b++){
					if(!used[a][b])return false;
				}
			}
			return true;
		}
		if(sum > 0)return false;
		if(sum == 0){
			i = p[k+1][0];
			j = p[k+1][1];
			return dfs(i, j, k+1, map[i][j]);
		}

		for(int m=0;m<4;m++){
			int i2 = i + move[m][0];
			int j2 = j + move[m][1];
			if(0<=i2&&i2<n&&0<=j2&&j2<n&&!used[i2][j2]){
				used[i2][j2] = true;
				if(dfs(i2, j2, k, sum+map[i2][j2]))return true;
				used[i2][j2] = false;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			n = sc.nextInt();
			if(n==0)break;
			map = new int[n][n];
			used = new boolean[n][n];
			p = new int[n*n][2];
			num = 0;
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					map[i][j] = sc.nextInt();
					if(map[i][j]<0){
						p[num][0] = i;
						p[num][1] = j;
						num++;
						used[i][j] = true;
					}
				}
			}
			System.out.println(dfs(p[0][0],p[0][1],0,map[p[0][0]][p[0][1]])?"YES":"NO");
		}
	}
}
