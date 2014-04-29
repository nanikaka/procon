package volume0;

import java.util.Scanner;

//Square Searching
public class AOJ0092 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			int[][] a = new int[n][n];
			int[][] sum = new int[n+1][n+1];
			for(int i=0;i<n;i++){
				char[] s = sc.next().toCharArray();
				for(int j=0;j<n;j++)a[i][j]=s[j]=='.'?1:0;
			}
			sum[1][1] = a[0][0];
			for(int i=2;i<=n;i++){
				sum[1][i] = a[0][i-1]+sum[1][i-1];
				sum[i][1] = a[i-1][0]+sum[i-1][1];
			}
			for(int i=2;i<=n;i++){
				for(int j=2;j<=n;j++){
					sum[i][j] = a[i-1][j-1] + sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1];
				}
			}
			int max = 0;
			for(int k=1;k<=n;k++){
				boolean f = false;
				for(int i=k;i<=n;i++){
					for(int j=k;j<=n;j++){
						if(sum[i][j]-sum[i-k][j]-sum[i][j-k]+sum[i-k][j-k]==k*k){
							f = true;
							break;
						}
					}
					if(f)break;
				}

				if(f){
					max = k;
				}
				else break;
			}
			System.out.println(max);
		}
	}
}
