package volume01;

import java.util.Scanner;

//Grid
public class AOJ0151 {

	static int[][] d = {{1,1},{1,-1}};
	static int max;
	static char[][] m;
	static int n;
	
	static int dfs(int i,int j, int k){
		if(!(0<=i&&i<n&&0<=j&&j<n)||m[i][j]=='0')return 0;
		int ni = i+d[k][0];
		int nj = j+d[k][1];
		return dfs(ni,nj,k)+1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			n = sc.nextInt();
			if(n==0)break;
			m = new char[n][n];
			for(int i=0;i<n;i++)m[i]=sc.next().toCharArray();
			max = 0;
			for(int i=0;i<n;i++){
				int c = 0;
				for(int j=0;j<n;j++){
					if(m[i][j]=='0')c = 0;
					else{
						c++;
						max = Math.max(max, c);
					}
				}
			}
			for(int j=0;j<n;j++){
				int c = 0;
				for(int i=0;i<n;i++){
					if(m[i][j]=='0')c=0;
					else{
						c++;
						max = Math.max(max, c);
					}
				}
			}
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					if(m[i][j]=='1'){
						max = Math.max(max, dfs(i,j,0));
						max = Math.max(max, dfs(i,j,1));
					}
				}
			}
			System.out.println(max);
		}
	}
}
