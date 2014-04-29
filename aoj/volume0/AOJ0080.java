package volume0;

import java.util.Scanner;

//Third Root
public class AOJ0080 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			double q = sc.nextDouble();
			if(q==-1)break;
			double x = Math.abs(q/2);
			while(Math.abs(x*x*x-q)>=0.000001*q)x = x-(x*x*x-q)/(3*x*x);
			System.out.printf("%.6f\n", x);
		}
	}
}
