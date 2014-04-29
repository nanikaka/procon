package volume20;

import java.util.Scanner;

//Misterious Gems
public class AOJ2000 {

	public static int dir(char c){
		return c=='N'?0:c=='E'?1:c=='S'?2:3;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] move = {{0,1}, {1,0},{0,-1},{-1,0}};
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			int get = 0;
			boolean[][] g = new boolean[21][21];
			for(int i=0;i<n;i++){
				int x = sc.nextInt();
				int y = sc.nextInt();
				g[x][y] = true;
			}
			int m = sc.nextInt();
			int px = 10;
			int py = 10;
			while(m--!=0){
				int k = dir(sc.next().charAt(0));
				int d = sc.nextInt();
				while(d--!=0){
					px += move[k][0];
					py += move[k][1];
					if(g[px][py]){
						g[px][py] = false;
						get++;
					}
				}
			}
			System.out.println(get==n?"Yes":"No");
		}
	}
}
