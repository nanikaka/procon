package volume02;

import java.util.Scanner;

//Scene in a Picture
public class AOJ0209 {

	public static void dump(int[][][] p, int m){
		for(int k=0;k<4;k++){
			for(int i=0;i<m;i++){
				for(int j=0;j<m;j++){
					System.out.print(p[i][j][k] + " ");
				}
				System.out.println();
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			int m = sc.nextInt();
			if(n==0&&m==0)break;
			int[][] map = new int[n][n];
			for(int i=0;i<n;i++)for(int j=0;j<n;j++)map[i][j]=sc.nextInt();
			int[][][] p = new int[m][m][4];
			for(int i=0;i<m;i++)for(int j=0;j<m;j++)p[i][j][0]=sc.nextInt();
			for(int k=1;k<4;k++){
				for(int i=0;i<m;i++)for(int j=0;j<m;j++)p[i][j][k]=p[j][m-1-i][k-1];
			}
			boolean f = false;
			for(int i=0;i<n-m+1;i++){
				if(f)break;
				for(int j=0;j<n-m+1;j++){
					if(f)break;
					for(int k=0;k<4;k++){
						boolean match = true;
						int ti = -1;
						int tj = -1;
						for(int di=0;di<m;di++){
							for(int dj=0;dj<m;dj++){
								if(p[di][dj][k]==-1)continue;
								else if(ti==-1){
									ti = di;
									tj = dj;
								}
								if(p[di][dj][k]!=map[i+di][j+dj]){
									match = false;
									break;
								}
							}
						}
						if(match){
							f = true;
							System.out.println((j+tj+1) + " " + (i+ti+1));
							break;
						}
					}
				}
			}
			if(!f)System.out.println("NA");
		}
	}
}
