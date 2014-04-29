package volume11;

import java.util.Scanner;

//Pablo Squarson's Headache
public class AOJ1165 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] dt = {{-1,0},{0,-1},{1,0},{0,1}};
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			int[][] p = new int[n][2];
			p[0][0] = 0;
			p[0][1] = 0;
			int minx = 0;
			int miny = 0;
			int maxx = 0;
			int maxy = 0;
			for(int i=1;i<n;i++){
				int id = sc.nextInt();
				int d = sc.nextInt();
				int nx = p[id][0] + dt[d][0];
				int ny = p[id][1] + dt[d][1];
				minx = Math.min(minx, nx);
				maxx = Math.max(maxx, nx);
				miny = Math.min(miny, ny);
				maxy = Math.max(maxy, ny);
				p[i][0] = nx;
				p[i][1] = ny;
			}
			System.out.println((maxx-minx+1) + " " + (maxy-miny+1));
		}
	}
}
