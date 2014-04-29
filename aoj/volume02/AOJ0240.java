package volume02;

import java.util.Scanner;

//Interest Rates
public class AOJ0240 {

	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			int n = sc.nextInt();
			if(n==0)break;
			int y = sc.nextInt(), res = 0;
			double max = -1;
			for(int i=0;i<n;i++){
				int b = sc.nextInt(), r = sc.nextInt(), t = sc.nextInt();
				double x;
				if(t==1)x = 1+y*r/100.;
				else x = Math.pow(1+r/100., y);
				if(max < x){
					max = x; res = b;
				}
			}
			System.out.println(res);
		}
	}
	
	public static void main(String[] args) {
		new AOJ0240().run();
	}
}
