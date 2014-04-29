package volume05;

import java.util.Scanner;

//Planetary Exploration
public class AOJ0560 {

	void run(){
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt(), w = sc.nextInt(), k = sc.nextInt();
		char[][] m = new char[h][];
		for(int i=0;i<h;i++)m[i]=sc.next().toCharArray();
		int[][] sj = new int[h+1][w+1], so = new int[h+1][w+1], si = new int[h+1][w+1];
		for(int i=0;i<h;i++)for(int j=0;j<w;j++){
			sj[i+1][j+1] = sj[i][j+1]+sj[i+1][j]-sj[i][j]+(m[i][j]=='J'?1:0);
			so[i+1][j+1] = so[i][j+1]+so[i+1][j]-so[i][j]+(m[i][j]=='O'?1:0);
			si[i+1][j+1] = si[i][j+1]+si[i+1][j]-si[i][j]+(m[i][j]=='I'?1:0);
		}
		while(k--!=0){
			int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt(), d = sc.nextInt();
			int rj = sj[c][d]-sj[a-1][d]-sj[c][b-1]+sj[a-1][b-1];
			int ro = so[c][d]-so[a-1][d]-so[c][b-1]+so[a-1][b-1];
			int ri = si[c][d]-si[a-1][d]-si[c][b-1]+si[a-1][b-1];
			System.out.println(rj+" "+ro+" "+ri);
		}
	}
	
	public static void main(String[] args) {
		new AOJ0560().run();
	}
}
