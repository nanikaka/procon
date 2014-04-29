package volume22;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//Let's JUMPSTYLE
public class AOJ2217 {

	void run(){
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			int[][][] m = new int[n][n][2];
			for(int i=0;i<n;i++)for(int j=0;j<n;j++)for(int k=0;k<2;k++)m[i][j][k]=sc.nextInt();
			boolean[][] u = new boolean[n][n];
			int c = 0;
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					if(u[i][j])continue;
					u[i][j] = true;
					Set<Integer> set = new HashSet<Integer>();
					set.add(i*n+j);
					int nj = m[i][j][0];
					int ni = m[i][j][1];
					while(true){
						if(u[ni][nj]){
							if(set.contains(ni*n+nj))c++;
							break;
						}
						u[ni][nj] = true;
						set.add(ni*n+nj);
						int ti = ni;
						int tj = nj;
						nj = m[ti][tj][0];
						ni = m[ti][tj][1];
					}
				}
			}
			System.out.println(c);
		}
	}

	public static void main(String[] args) {
		new AOJ2217().run();
	}
}
