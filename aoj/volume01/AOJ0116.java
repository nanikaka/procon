package volume01;

import java.util.Scanner;

//Rectangular Searching
public class AOJ0116 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int h = sc.nextInt();
			int w = sc.nextInt();
			if((h|w)==0)break;
			char[][] m = new char[h][w];
			for(int i=0;i<h;i++)m[i]=sc.next().toCharArray();
			int[][] c = new int[h][w];
			for(int i=0;i<h;i++){
				int x = 1;
				for(int j=w-1;j>=0;j--){
					if(m[i][j]=='.'){
						c[i][j] = x++;
					}
					else{
						c[i][j] = 0;
						x = 1;
					}
				}
			}
			int max = 0;
			for(int i=0;i<h;i++){
				for(int j=0;j<w;j++){
					if(0<i&&c[i][j]==c[i-1][j]||c[i][j]==0)continue;
					int k = 1;
					int min = c[i][j];
					max = Math.max(max, k*min);
					while(i+k<h&&c[i+k][j]>0){
						min = Math.min(min, c[i+k][j]);
						k++;
						max = Math.max(max, k*min);
					}
				}
			}
			System.out.println(max);
		}
	}
}
