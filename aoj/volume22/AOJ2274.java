package volume22;

import java.util.Random;
import java.util.Scanner;

//Sequence Configuration
public class AOJ2274 {

	void run(){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), k = sc.nextInt();
		int[][] c = new int[k][n/2];
		for(int i=0;i<k;i++)for(int j=0;j<n/2;j++)c[i][j]=sc.nextInt();
		Random rand = new Random();
		for(;;){
			int[] a = new int[n+1];
			for(int i=1;i<=n;i++)a[i]=rand.nextInt(2);
			boolean ok = true;
			for(int i=0;i<k;i++){
				if(!ok)break;
				int s = 0;
				for(int j=0;j<n/2;j++){
					if(a[c[i][j]]==1)s++;
					if(3*n/8<s)break;
				}
				if(!(n/8<=s&&s<=3*n/8))ok = false;
			}
			if(ok){
				for(int i=1;i<=n;i++)System.out.print(a[i]+(i==n?"\n":""));
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		new AOJ2274().run();
	}
}
