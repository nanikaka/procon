package volume05;

import java.util.Arrays;
import java.util.Scanner;

//Quality Checking
public class AOJ0514 {

	void run(){
		Scanner sc = new Scanner(System.in);
		while(true){
			int k = sc.nextInt()+sc.nextInt()+sc.nextInt();
			if(k==0)break;
			int n = sc.nextInt();
			int[] a = new int[k+1];
			Arrays.fill(a, 2);
			int[][] b = new int[n][4];
			for(int i=0;i<n;i++){
				for(int j=0;j<4;j++){
					b[i][j] = sc.nextInt();
				}
				if(b[i][3]==1){
					for(int j=0;j<3;j++)a[b[i][j]] = 1;
				}
			}
			for(int i=0;i<n;i++){
				if(b[i][3]==1)continue;
				int c = 0;
				for(int j=0;j<3;j++)c+=a[b[i][j]]==1?1:0;
				if(c==2){
					for(int j=0;j<3;j++)if(a[b[i][j]]!=1)a[b[i][j]]=0;
				}
			}
			for(int i=1;i<=k;i++)System.out.println(a[i]);
		}
	}

	public static void main(String[] args) {
		new AOJ0514().run();
	}
}
