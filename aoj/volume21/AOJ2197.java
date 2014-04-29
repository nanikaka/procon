package volume21;

import java.util.Scanner;

//Sum of Consecutive Integers
public class AOJ2197 {

	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			int n = sc.nextInt();
			if(n==0)break;
			int res = 0;
			for(int i=1;i+1<=n;i++){
				int s = 2*i+1, k = i+2;
				while(s<n){
					s+=k; k++;
				}
				if(s==n)res++;
			}
			System.out.println(res);
		}
	}
	
	public static void main(String[] args) {
		new AOJ2197().run();
	}
}
