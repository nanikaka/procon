package volume20;

import java.util.Scanner;

//Square Route
public class AOJ2015 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			int m = sc.nextInt();
			if((n|m)==0)break;
			int[] h = new int[n];
			for(int i=0;i<n;i++)h[i]=sc.nextInt();
			int[] w = new int[m];
			for(int i=0;i<m;i++)w[i]=sc.nextInt();
			int[] wh = new int[1500001];
			int[] ww = new int[1500001];
			for(int i=0;i<n;i++){
				int s = 0;
				for(int j=i;j<n;j++){
					s+=h[j];
					wh[s]++;
				}
			}
			for(int i=0;i<m;i++){
				int s = 0;
				for(int j=i;j<m;j++){
					s+=w[j];
					ww[s]++;
				}
			}
			int c = 0;
			for(int i=0;i<1500001;i++)c+=wh[i]*ww[i];
			System.out.println(c);
		}
	}
}
