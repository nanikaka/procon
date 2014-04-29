package volume02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Block
public class AOJ0207 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] move = {{0,1},{0,-1},{1,0},{-1,0}};
		while(true){
			int w = sc.nextInt();
			int h = sc.nextInt();
			if((w|h)==0)break;
			int[][] m = new int[h][w];
			int sj = sc.nextInt()-1;
			int si = sc.nextInt()-1;
			int gj = sc.nextInt()-1;
			int gi = sc.nextInt()-1;
			int n = sc.nextInt();
			while(n--!=0){
				int c = sc.nextInt();
				int d = sc.nextInt();
				int tj = sc.nextInt()-1;
				int ti = sc.nextInt()-1;
				if(d==0)for(int i=0;i<2;i++)for(int j=0;j<4;j++)m[ti+i][tj+j]=c;
				else for(int i=0;i<4;i++)for(int j=0;j<2;j++)m[ti+i][tj+j]=c;
			}
			if(m[si][sj]==0||m[gi][gj]==0||m[si][sj]!=m[gi][gj]){
				System.out.println("NG");
				continue;
			}
			int x = m[si][sj];
			boolean f = false;
			boolean[][] v = new boolean[h][w];
			v[si][sj] = true;
			List<int[]> l = new ArrayList<int[]>();
			l.add(new int[]{si,sj});
			while(!l.isEmpty()){
				List<int[]> next = new ArrayList<int[]>();
				for(int a[] : l){
					int i = a[0];
					int j = a[1];
					if(i==gi&&j==gj){
						f = true;
						next.clear();
						break;
					}
					for(int k=0;k<4;k++){
						int ni = i+move[k][0];
						int nj = j+move[k][1];
						if(0<=ni&&ni<h&&0<=nj&&nj<w&&!v[ni][nj]&&m[ni][nj]==x){
							v[ni][nj] = true;
							next.add(new int[]{ni,nj});
						}
					}
				}
				l = next;
			}
			System.out.println(f?"OK":"NG");
		}
	}
}
