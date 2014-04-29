package volume02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Stray Twins
public class AOJ0223 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] move = {{-1,0},{0,1},{1,0},{0,-1}};
		while(true){
			int w = sc.nextInt();
			int h = sc.nextInt();
			if((w|h)==0)break;
			int sj = sc.nextInt()-1;
			int si = sc.nextInt()-1;
			int tj = sc.nextInt()-1;
			int ti = sc.nextInt()-1;
			int[][] m = new int[h][w];
			for(int i=0;i<h;i++)for(int j=0;j<w;j++)m[i][j]=sc.nextInt();
			boolean[][] u = new boolean[w*h][w*h];
			u[si*w+sj][ti*w+tj] = true;
			List<int[]> l = new ArrayList<int[]>();
			l.add(new int[]{si*w+sj, ti*w+tj});
			int step = 0;
			boolean f = false;
			while(step<=99&&!l.isEmpty()&&!f){
				List<int[]> next = new ArrayList<int[]>();
				for(int[] v:l){
					si = v[0]/w;
					sj = v[0]%w;
					ti = v[1]/w;
					tj = v[1]%w;
					if(si==ti&&sj==tj){
						f = true;
						next.clear();
						break;
					}
					for(int k=0;k<4;k++){
						int nsi = si+move[k][0];
						int nsj = sj+move[k][1];
						int nti = ti+move[(k+2)%4][0];
						int ntj = tj+move[(k+2)%4][1];
						if(!(0<=nsi&&nsi<h&&0<=nsj&&nsj<w&&m[nsi][nsj]==0)){
							nsi = si;
							nsj = sj;
						}
						if(!(0<=nti&&nti<h&&0<=ntj&&ntj<w&&m[nti][ntj]==0)){
							nti = ti;
							ntj = tj;
						}
						if(!u[nsi*w+nsj][nti*w+ntj]){
							u[nsi*w+nsj][nti*w+ntj] = true;
							next.add(new int[]{nsi*w+nsj, nti*w+ntj});
						}
					}
				}
				step++;
				l = next;
			}
			System.out.println(f?step-1:"NA");
		}
	}
}
