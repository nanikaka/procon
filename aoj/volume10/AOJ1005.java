package volume10;

import java.util.Scanner;

//Advanced Algorithm Class
public class AOJ1005 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			int[][] map = new int [n+1][n+1];
			for(int i=0;i<n;i++){
				map[i][n] = Integer.MAX_VALUE;
			}
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					map[i][j] = sc.nextInt();
					map[i][n] = Math.min(map[i][n], map[i][j]);
					map[n][j] = Math.max(map[n][j], map[i][j]);
				}
			}
			int ans = 0;
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					if(map[i][j]==map[i][n]&&map[i][j]==map[n][j])ans = map[i][j];
				}
			}
			System.out.println(ans);
		}
	}
}
