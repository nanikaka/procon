package volume0;

import java.util.Scanner;

//Calculation of Area
public class AOJ0094 {

	void run(){
		Scanner sc = new Scanner(System.in);
		System.out.printf("%.8f\n", sc.nextInt()*sc.nextInt()/3.305785);
	}
	
	public static void main(String[] args) {
		new AOJ0094().run();
	}
}
