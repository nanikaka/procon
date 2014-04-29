package volume01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Property Distribution
public class AOJ0118 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] move = {{0,1},{0,-1},{1,0},{-1,0}};
		while(true){
			int h = sc.nextInt();
			int w = sc.nextInt();
			if((h|w)==0)break;
			char[][] m = new char[h][w];
			for(int i=0;i<h;i++)m[i]=sc.next().toCharArray();
			int x = 0;
			for(int i=0;i<h;i++){
				for(int j=0;j<w;j++){
					if(m[i][j]!='.'){
						x++;
						List<int[]> l = new ArrayList<int[]>();
						char c = m[i][j];
						m[i][j] = '.';
						l.add(new int[]{i,j});
						while(!l.isEmpty()){
							List<int[]> next = new ArrayList<int[]>();
							for(int[] a:l){
								int u = a[0];
								int v = a[1];
								for(int k=0;k<4;k++){
									int ni = u+move[k][0];
									int nj = v+move[k][1];
									if(0<=ni&&ni<h&&0<=nj&&nj<w&&m[ni][nj]==c){
										m[ni][nj] = '.';
										next.add(new int[]{ni,nj});
									}
								}
							}
							l = next;
						}
					}
				}
			}
			System.out.println(x);
		}
	}
}
