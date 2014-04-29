package volume0;

import java.util.Scanner;

//Plastic Board
public class AOJ0032 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c1 = 0;
		int c2 = 0;
		while(sc.hasNext()){
			String[] s = sc.next().split(",");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			int c = Integer.parseInt(s[2]);
			c1 += c*c==a*a+b*b?1:0;
			c2 += a==b?1:0;
		}
		System.out.println(c1+"\n"+c2);
	}
}
