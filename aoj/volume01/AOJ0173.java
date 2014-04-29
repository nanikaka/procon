package volume01;

import java.util.Scanner;

//Haunted House
public class AOJ0173 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<9;i++){
			String s = sc.next();
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println(s+" "+(a+b)+" "+(200*a+300*b));
		}
	}
}
