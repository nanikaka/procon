package volume0;

import java.util.Scanner;

//Palindrome
public class AOJ0063 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c = 0;
		while(sc.hasNext()){
			String s = sc.next();
			if(s.equals((new StringBuffer(s)).reverse().toString()))c++;
		}
		System.out.println(c);
	}
}
