package volume05;

import java.util.Scanner;

//Score
public class AOJ0510 {

	void run(){
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt()+sc.nextInt()+sc.nextInt()+sc.nextInt();
		int t = sc.nextInt()+sc.nextInt()+sc.nextInt()+sc.nextInt();
		System.out.println(Math.max(s, t));
	}

	public static void main(String[] args) {
		new AOJ0510().run();
	}
}
