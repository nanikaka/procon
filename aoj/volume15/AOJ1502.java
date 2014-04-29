package volume15;

import java.util.Scanner;

//War
public class AOJ1502 {

	void run(){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] h = new int[n];
		long res = 0;
		for(int i=0;i<n;i++)res+=h[i]=sc.nextInt();
		for(int d=1;d<125;d++){
			int c = 0;
			for(int x:h)c+=x>=d?1:0;
			res-=Math.max(0, c-d*4);
		}
		System.out.println(res+1);
	}
	
	public static void main(String[] args) {
		new AOJ1502().run();
	}
}
