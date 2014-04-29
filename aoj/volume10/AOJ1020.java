package volume10;

import java.util.Scanner;

//Cleaning Robot
public class AOJ1020 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] move = {{0,1},{0,-1},{1,0},{-1,0}};
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			int x = sc.next().charAt(0)-'A';
			int si = x/3;
			int sj = x%3;
			x = sc.next().charAt(0)-'A';
			int gi = x/3;
			int gj = x%3;
			x = sc.next().charAt(0)-'A';
			int pi = x/3;
			int pj = x%3;
			double[][][] ex = new double[3][3][n+1];
			ex[si][sj][0] = 1;
			for(int k=1;k<=n;k++){
				for(int i=0;i<3;i++){
					for(int j=0;j<3;j++){
						for(int d=0;d<4;d++){
							int ni = i+move[d][0];
							int nj = j+move[d][1];
							if(0<=ni&&ni<3&&0<=nj&&nj<3&&!(ni==pi&&nj==pj)){
								ex[ni][nj][k] += 0.25*ex[i][j][k-1];
							}
							else{
								ex[i][j][k] += 0.25*ex[i][j][k-1];
							}
						}
					}
				}
			}
			System.out.printf("%.8f\n", ex[gi][gj][n]);
		}
	}
}
