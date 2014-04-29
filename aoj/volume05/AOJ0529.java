package volume05;

import java.util.Arrays;
import java.util.Scanner;

//Darts
public class AOJ0529 {

	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			int n = sc.nextInt(), m = sc.nextInt();
			if((n|m)==0)break;
			int[] p = new int[n+1];
			for(int i=0;i<n;i++)p[i]=sc.nextInt();
			int[] a = new int[(n+1)*(n+2)/2];
			int N = 0;
			for(int i=0;i<=n;i++)for(int j=i;j<=n;j++)if(p[i]+p[j]<=m)a[N++]=p[i]+p[j];
			Arrays.sort(a);
			int max = 0;
			int s = 0;
			int t = a.length-1;
			while(s<=t){
				if(max==m)break;
				if(a[s]+a[t]<=m){
					max=Math.max(max, a[s]+a[t]);
					s++;
				}
				else t--;
			}
			System.out.println(max);
		}
	}
	public static void main(String[] args) {
		new AOJ0529().run();
	}
}
