package volume01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Summer of Phyonkichi
public class AOJ0122 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] move = {{-2,-1},{-2,0},{-2,1},{-1,-2},{-1,2},{0,-2},{0,2},{1,-2},{1,2},{2,-1},{2,0},{2,1}};
		while(true){
			int sj = sc.nextInt();
			int si = sc.nextInt();
			if((sj|si)==0)break;
			int n = sc.nextInt();
			int[][] p = new int[n][2];
			for(int i=0;i<n;i++)for(int j=1;j>=0;j--)p[i][j]=sc.nextInt();
			boolean[][][] visited = new boolean[10][10][10];
			List<int[]> l = new ArrayList<int[]>();
			l.add(new int[]{si,sj});
			int step = 0;
			while(!l.isEmpty()&&step<n){
				List<int[]> next = new ArrayList<int[]>();
				for(int[]a:l){
					for(int k=0;k<12;k++){
						int i = a[0]+move[k][0];
						int j = a[1]+move[k][1];
						if(0<=i&&i<10&&0<=j&&j<10&&!visited[i][j][step]){
							boolean f = false;
							for(int c=-1;c<=1;c++){
								for(int b=-1;b<=1;b++){
									int ci = p[step][0]+c;
									int cj = p[step][1]+b;
									if(ci==i&&cj==j){
										f = true;
										break;
									}
								}
							}
							if(f){
								visited[i][j][step] = true;
								next.add(new int[]{i,j});
							}
						}
					}
				}
				step++;
				l = next;
			}
			System.out.println(step==n&&!l.isEmpty()?"OK":"NA");
		}
	}
}
