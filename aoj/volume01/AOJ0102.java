package volume01;

import java.util.Scanner;

//Matrix-like Computation
public class AOJ0102 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			int[][] a = new int[n+1][n+1];
			for(int i=0;i<n;i++)for(int j=0;j<n;j++)a[i][j]=sc.nextInt();
			for(int i=0;i<n;i++)for(int j=0;j<n;j++){a[i][n]+=a[i][j];a[n][i]+=a[j][i];}
			for(int i=0;i<n;i++)a[n][n]+=a[i][n];
			for(int i=0;i<=n;i++){
				for(int j=0;j<=n;j++)System.out.printf("%5d",a[i][j]);
				System.out.println();
			}
		}
	}
}
