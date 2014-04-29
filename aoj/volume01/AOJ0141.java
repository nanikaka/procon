package volume01;

import java.util.Arrays;
import java.util.Scanner;

//Spiral Pattern
public class AOJ0141 {

	static char[][] s;
	static int n;
	static int[][] move = {{-1,0},{0,1},{1,0},{0,-1}};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		boolean f = true;
		while(t--!=0){
			if(!f)System.out.println();
			f = false;
			n = sc.nextInt();
			s = new char[n][n];
			for(int i=0;i<n;i++)Arrays.fill(s[i], ' ');
			int i = n;
			int j = 0;
			int k = 0;
			while(true){
				int ni = i+move[k][0];
				int nj = j+move[k][1];
				if(0<=ni&&ni<n&&0<=nj&&nj<n&&c(ni,nj)){
					s[ni][nj] = '#';
					i = ni;
					j = nj;
				}
				else{
					k = (k+1)%4;
					ni = i+move[k][0];
					nj = j+move[k][1];
					if(0<=ni&&ni<n&&0<=nj&&nj<n&&c(ni,nj)){
						s[ni][nj] = '#';
						i = ni;
						j = nj;
					}
					else break;
				}
			}
			for(int x=0;x<n;x++)System.out.println(new String(s[x]));
		}
	}
	
	static boolean c(int i, int j){
		int c = 0;
		for(int k=0;k<4;k++){
			int ni = i+move[k][0];
			int nj = j+move[k][1];
			if(0<=ni&&ni<n&&0<=nj&&nj<n&&s[ni][nj]=='#')c++;
		}
		return c<=1;
	}
}
