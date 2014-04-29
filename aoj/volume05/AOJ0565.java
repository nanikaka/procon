package volume05;

import java.util.Scanner;

//Lunch
public class AOJ0565 {

	void run(){
		Scanner sc = new Scanner(System.in);
		System.out.println((Math.min(sc.nextInt(), Math.min(sc.nextInt(), sc.nextInt())))+Math.min(sc.nextInt(), sc.nextInt())-50);
	}
	
	public static void main(String[] args) {
		new AOJ0565().run();
	}
}
