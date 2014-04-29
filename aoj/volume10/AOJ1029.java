package volume10;

import java.util.Arrays;
import java.util.Scanner;

//Traffic Analysis
public class AOJ1029 {

	void run(){
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			int m = sc.nextInt();
			if((n|m)==0)break;
			int[] a = new int[n+m+1];
			for(int i=1;i<=n+m;i++)a[i]=sc.nextInt();
			Arrays.sort(a);
			int max = 0;
			for(int i=1;i<=n+m;i++)max = Math.max(max, a[i]-a[i-1]);
			System.out.println(max);
		}
	}
	
	public static void main(String[] args) {
		new AOJ1029().run();
	}
}
