package volume05;

import java.util.Scanner;

//Osenbei
public class AOJ0525 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int r = sc.nextInt();
			int c = sc.nextInt();
			if(r==0&&c==0)break;
			int[][] a = new int[r][c];
			for(int i=0;i<r;i++)for(int j=0;j<c;j++)a[i][j]=sc.nextInt();
			int[] p = new int[c];
			for(int j=0;j<c;j++){
				int e = 0;
				for(int i=0;i<r;i++)e+=a[i][j]<<i;
				p[j] = e;
			}
			int n = 1<<r;
			int max = 0;
			for(int i=0;i<n;i++){
				int t = 0;
				for(int j=0;j<c;j++){
					int e = p[j]^i;
					int bit = 0;
					for(int k=0;k<r;k++)bit+=(e&1<<k)>0?1:0;
					t += Math.max(bit, r-bit);
				}
				max = Math.max(max, t);
			}
			System.out.println(max);
		}
	}
}
