package volume0;

import java.util.Scanner;

//Digit Number
public class AOJ0002 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int a=sc.nextInt()+sc.nextInt();
			System.out.println((a+"").length());
		}
	}
}
