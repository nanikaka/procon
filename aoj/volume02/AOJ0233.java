package volume02;

import java.util.Scanner;

//Book Arrangement
public class AOJ0233 {

	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			long x = sc.nextLong();
			if(x==0)break;
			boolean sign = x>0;
			String res = "";
			x = Math.abs(x);
			boolean k = true;
			while(x>0){
				int t = (int) (x%10);
				if(sign==k)res =t + res;
				else{
					res = (10-t)%10+res;
					if(t!=0)x+=10;
				}
				k=!k;
				x/=10;
			}
			System.out.println(res);
		}
	}

	public static void main(String[] args) {
		new AOJ0233().run();
	}
}
