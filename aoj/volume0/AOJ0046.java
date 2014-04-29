package volume0;

import java.util.Scanner;

//Differential
public class AOJ0046 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double min = Integer.MAX_VALUE;
		double max = Integer.MIN_VALUE;
		while(sc.hasNext()){
			double x = sc.nextDouble();
			min = Math.min(min, x);
			max = Math.max(max, x);
		}
		System.out.println(max-min);
	}
}
