package volume0;

import java.util.Scanner;

//Capitalize
public class AOJ0020 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] s = sc.nextLine().toCharArray();
		for(int i=0;i<s.length;i++)
			s[i] = Character.toUpperCase(s[i]);
		System.out.println(s);
	}
}
