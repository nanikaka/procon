package volume0;

import java.util.Scanner;

//Integral
public class AOJ0014 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int d = sc.nextInt();
			int s = 0;
			int x = d;
			while(x<600){
				s += d*x*x;
				x+=d;
			}
			System.out.println(s);
		}
	}
}
