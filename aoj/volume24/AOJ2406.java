package volume24;

import java.util.Scanner;

//Al dente
public class AOJ2406 {

	void run(){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), T = sc.nextInt(), E = sc.nextInt();
		int[] a = new int[n+1];
		for(int i=1;i<=n;i++)a[i]=sc.nextInt();
		int res = -1;
		for(int i=1;i<=n&&res==-1;i++){
			int k = (T-E-1)/a[i]+1;
			if(T-E<=a[i]*k&&a[i]*k<=T+E)res=i;
		}
		System.out.println(res);
	}
	
	public static void main(String[] args) {
		new AOJ2406().run();
	}
}
