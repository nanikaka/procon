package volume22;

import java.util.Scanner;

//Compile
public class AOJ2206 {

	public static char[][] map;
	public static boolean[][] mark;
	public static int count;
	public static int[][] move = {{1,0}, {0,1}, {-1,0}, {0, -1}};

	public static void dfs(int i, int j, char ch){
		mark[i][j] = true;
		count++;
		for(int k=0;k<4;k++){
			int i2 = i + move[k][0];
			int j2 = j + move[k][1];
			if(0<=i2&&i2<12&&0<=j2&&j2<6&&!mark[i2][j2]&&map[i2][j2]==ch){
				dfs(i2, j2, ch);
			}
		}
	}

	public static boolean delete(int i, int j, char ch){
		if(ch=='O')return false;
		mark = new boolean[12][6];
		count = 0;
		dfs(i,j,ch);
		if(count<4)return false;
		for(int m=0;m<12;m++){
			for(int n=0;n<6;n++){
				if(mark[m][n]){
					map[m][n] = '.';
					for(int k=0;k<4;k++){
						int m2 = m + move[k][0];
						int n2 = n + move[k][1];
						if(0<=m2&&m2<12&&0<=n2&&n2<6&&map[m2][n2]=='O')
							map[m2][n2] = '.';
					}
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t--!=0){
			map = new char[12][6];
			for(int i=0;i<12;i++)map[i]=sc.next().toCharArray();
			int chain = 0;
			while(true){
				boolean f = false;
				for(int i=0;i<12;i++){
					for(int j=0;j<6;j++){
						if(map[i][j]!='.')
							f |= delete(i,j,map[i][j]);
					}
				}
				if(!f)break;
				chain++;
				for(int j=0;j<6;j++){
					for(int i=11;i>=1;i--){
						if(map[i][j]=='.'){
							int k = i-1;
							while(k>=0&&map[k][j]=='.')k--;
							if(k<0)break;
							for(int m=k;m<i;m++){
								map[m+1][j] = map[m][j];
								map[m][j] = '.';
							}
						}
					}
				}
			}
			System.out.println(chain);
		}
	}
}
