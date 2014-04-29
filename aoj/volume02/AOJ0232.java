package volume02;

import java.util.Scanner;

//Life Game
public class AOJ0232 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int x = sc.nextInt();
			int n = sc.nextInt();
			int e = sc.nextInt();
			if((x|n|e)==0)break;
			int[] v = new int[x];
			for(int i=0;i<x;i++)v[i]=sc.nextInt();
			int[][] ev = new int[n+1][2];
			while(e--!=0){
				int p = sc.nextInt();
				int k = sc.nextInt();
				int val = sc.nextInt();
				ev[p][0] = k;
				ev[p][1] = val;
			}
			double[][] p = new double[5001][n+1];

			p[0][0] = 1;
			for(int i=0;i<n;i++){
				for(int j=0;j<5001;j++){
					if(p[j][i]==0)continue;
					for(int k=0;k<x;k++){
						int np = Math.min(n, i+v[k]);
						int nm = j;
						if(ev[np][0]==1){
							np = Math.min(n, np+ev[np][1]);
						}
						else if(ev[np][0]==2){
							nm += ev[np][1];
						}
						else if(ev[np][0]==3){
							nm = Math.max(0, nm-ev[np][1]);
						}
						p[nm][np] += p[j][i]/x;
					}
				}
			}
			double exp = 0;
			for(int i=0;i<5001;i++)exp+=i*p[i][n];
			System.out.println((int)exp);
		}
	}
}
