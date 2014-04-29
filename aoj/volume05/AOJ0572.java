package volume05;

import java.util.Scanner;

//Card Game is Fun
public class AOJ0572 {

	void run(){
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt(), B = sc.nextInt();
		int[] a = new int[A], b = new int[B];
		for(int i=0;i<A;i++)a[i]=sc.nextInt();
		for(int i=0;i<B;i++)b[i]=sc.nextInt();
		int res = 0;
		for(int i=0;i<B;i++){
			int v = i, p = 0, k = 0;
			while(v<B&&p<A){
				if(b[v]==a[p]){
					res = Math.max(res, ++k);
					v++;
				}
				p++;
			}
		}
		System.out.println(res);
	}
	
	public static void main(String[] args) {
		new AOJ0572().run();
	}
}
