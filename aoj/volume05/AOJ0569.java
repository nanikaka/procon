package volume05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Illumination
public class AOJ0569 {

	int[][] d0 = {{-1,0},{-1,1},{0,-1},{0,1},{1,0},{1,1}}, d1 = {{-1,-1},{-1,0},{0,-1},{0,1},{1,-1},{1,0}};
	
	void run(){
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt(), h = sc.nextInt();
		boolean[][] u = new boolean[h+2][w+2], v = new boolean[h+2][w+2];
		for(int i=1;i<=h;i++)for(int j=1;j<=w;j++)u[i][j]=sc.nextInt()==1;
		v[0][0] = true;
		List<int[]> l = new ArrayList<int[]>();
		l.add(new int[]{0, 0});
		while(!l.isEmpty()){
			List<int[]> next = new ArrayList<int[]>();
			for(int[]a:l){
				int pi = a[0], pj = a[1];
				for(int k=0;k<6;k++){
					int ni = pi + (pi%2==1?d0[k][0]:d1[k][0]), nj = pj + (pi%2==1?d0[k][1]:d1[k][1]);
					if(0<=ni&&ni<=h+1&&0<=nj&&nj<=w+1&&!u[ni][nj]&&!v[ni][nj]){
						v[ni][nj] = true; next.add(new int[]{ni, nj});
					}
				}
			}
			l = next;
		}
		int res = 0;
		for(int i=1;i<=h;i++)for(int j=1;j<=w;j++)if(u[i][j]){
			for(int k=0;k<6;k++){
				int ni = i + (i%2==1?d0[k][0]:d1[k][0]), nj = j + (i%2==1?d0[k][1]:d1[k][1]);
				if(v[ni][nj])res++;
			}
		}
		System.out.println(res);
	}
	
	public static void main(String[] args) {
		new AOJ0569().run();
	}
}
