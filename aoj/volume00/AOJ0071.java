package volume0;

import java.util.Scanner;

//Bombs Chain
public class AOJ0071 {
	
	static char[][] m;
	static int[][] move = {{0,1},{0,-1},{1,0},{-1,0}};
	
	static void f(int i, int j){
		m[i][j] = '0';
		for(int k=0;k<4;k++){
			for(int l=1;l<=3;l++){
				int ni = i+l*move[k][0];
				int nj = j+l*move[k][1];
				if(0<=ni&&ni<8&&0<=nj&&nj<8&&m[ni][nj]=='1'){
					f(ni,nj);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Case = 1;
		int t = sc.nextInt();
		while(t--!=0){
			m = new char[8][8];
			for(int i=0;i<8;i++)m[i]=sc.next().toCharArray();
			int j=sc.nextInt()-1;
			int i=sc.nextInt()-1;
			f(i,j);
			System.out.println("Data " + Case++ + ":");
			for(int k=0;k<8;k++)System.out.println(new String(m[k]));
		}
	}
}
