package volume24;

import java.util.Arrays;
import java.util.Scanner;

//Kakezan
public class AOJ2424 {

	void run(){
		int[] f = new int[1000001];
		for(int x=0;x<=1000000;x++){
			int max = 0;
			for(int d=10;d<=1000000;d*=10){
				max = Math.max(max, (x/d)*(x%d));
			}
			f[x] = max;
		}
		Scanner sc = new Scanner(System.in);
		boolean[] u = new boolean[1000001];
		int Q = sc.nextInt();
		while(Q--!=0){
			Arrays.fill(u, false);
			int x = sc.nextInt(), res = 0;
			u[x] = true;
			while(10<=x){
				x = f[x];
				if(u[x]){
					res = -1; break;
				}
				res++;
				u[x] = true;
			}
			System.out.println(res);
		}
	}
	
	public static void main(String[] args) {
		new AOJ2424().run();
	}
}
