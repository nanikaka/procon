package volume11;

import java.util.Scanner;

//Polygonal Line Search
public class AOJ1136 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			int m = sc.nextInt();
			int[][] p = new int[m][2];
			int[][] r = new int[m][2];
			for(int i=0;i<m;i++){
				int x = sc.nextInt();
				int y = sc.nextInt();
				p[i][0] = r[m-i-1][0] = x;
				p[i][1] = r[m-i-1][1] = y;
			}
			int[] d = new int[m-1];
			int[] rd = new int[m-1];
			for(int i=1;i<m;i++){
				d[i-1] = Math.abs(p[i][0]-p[i-1][0]) + Math.abs(p[i][1]-p[i-1][1]);
				rd[i-1] = Math.abs(r[i][0]-r[i-1][0]) + Math.abs(r[i][1]-r[i-1][1]);
			}
			int dir[] = new int[m-2];
			int k;
			if(p[1][0]==p[0][0])k = p[1][1] > p[0][1] ? 0 : 2;
			else k = p[0][0] < p[1][0] ? 1 : 3;
			for(int i=2;i<m;i++){
				int nk;
				if(p[i][0]==p[i-1][0])nk = p[i][1] > p[i-1][1] ? 0 : 2;
				else nk = p[i-1][0] < p[i][0] ? 1 : 3;
				dir[i-2] = (nk - k + 4)%4;
				k = nk;
			}
			int rdir[] = new int[m-2];
			for(int i=0;i<m-2;i++)rdir[i] = (dir[m-3-i]+2)%4;	
			for(int i=1;i<=n;i++){
				int t = sc.nextInt();
				int[] dt = new int[t-1];
				int[] dirt = new int[t-2];
				int x = sc.nextInt();
				int y = sc.nextInt();
				int kt = -1;
				for(int j=1;j<t;j++){
					int nx = sc.nextInt();
					int ny = sc.nextInt();
					dt[j-1] = Math.abs(x-nx)+Math.abs(y-ny);
					int nk;
					if(x==nx)nk = y < ny ? 0 : 2;
					else nk = x < nx ? 1 : 3;
					if(j>=2)dirt[j-2] = (nk-kt+4)%4;
					kt = nk;
					x = nx;
					y = ny;
				}
				if(m!=t)continue;
				boolean f = true;
				boolean f2 = true;
				for(int j=0;j<t-1;j++){
					if(dt[j]!=d[j])f = false;
					if(dt[j]!=rd[j])f2 = false;
				}
				for(int j=0;j<t-2;j++){
					if(dirt[j]!=dir[j])f = false;
					if(dirt[j]!=rdir[j])f2 = false;
				}
				if(f||f2)System.out.println(i);
			}
			System.out.println("+++++");
		}
	}
}
