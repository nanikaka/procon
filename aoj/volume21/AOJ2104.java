package volume21;

import java.util.Arrays;
import java.util.Scanner;

//Country Road
public class AOJ2104 {

	void run(){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T--!=0){
			int n = sc.nextInt(), k = sc.nextInt();
			int[] a = new int[n], len = new int[n-1];
			for(int i=0;i<n;i++)a[i] = sc.nextInt();
			for(int i=0;i<n-1;i++)len[i]=a[i+1]-a[i];
			Arrays.sort(len);
			int res = a[n-1]-a[0];
			int j = n-2;
			while(j>=0&&--k!=0)res-=len[j--];
			System.out.println(res);
		}
	}
	
	public static void main(String[] args) {
		new AOJ2104().run();
	}
}
