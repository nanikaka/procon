package volume0;

import java.util.Scanner;

//Number of Island
public class AOJ0067 {

	public static boolean[][] map;

	public static int[][] move = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

	public static void dfs(int i, int j){
		map[i][j] = false;
		for(int k=0;k<4;k++){
			int i2 = i+move[k][0];
			int j2 = j+move[k][1];
			if(0<=i2&&i2<12&&0<=j2&&j2<12&&map[i2][j2])dfs(i2,j2);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			map = new boolean[12][12];
			for(int i=0;i<12;i++){
				char[] s = sc.next().toCharArray();
				for(int j=0;j<12;j++){
					map[i][j] = s[j]=='1';
				}
			}
			int x = 0;
			for(int i=0;i<12;i++){
				for(int j=0;j<12;j++){
					if(map[i][j]){
						dfs(i, j);
						x++;
					}
				}
			}
			System.out.println(x);
		}
	}
}
