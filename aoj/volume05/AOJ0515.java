package volume05;

import java.util.Scanner;

//School Road
public class AOJ0515 {

	void run(){
		Scanner sc = new Scanner(System.in);
		while(true){
			int w = sc.nextInt();
			int h = sc.nextInt();
			if((w|h)==0)break;
			boolean[][] u = new boolean[h][w];
			int n = sc.nextInt();
			while(n--!=0){
				int a = sc.nextInt()-1;
				int b = sc.nextInt()-1;
				u[b][a] = true;
			}
			long[][] dp = new long[h][w];
			dp[0][0] = 1;
			for(int i=0;i<h;i++){
				for(int j=0;j<w;j++){
					if(u[i][j])continue;
					if(i>0)dp[i][j]+=dp[i-1][j];
					if(j>0)dp[i][j]+=dp[i][j-1];
				}
			}
			System.out.println(dp[h-1][w-1]);
		}
	}

	public static void main(String[] args) {
		new AOJ0515().run();
	}
}
