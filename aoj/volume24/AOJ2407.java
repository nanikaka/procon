package volume24;

import java.util.Scanner;

//Simple Othello
public class AOJ2407 {

	void run(){
		Scanner sc = new Scanner(System.in);
		char[] s = sc.next().toCharArray();
		int n = s.length;
		System.out.println(s[0]==s[n-1]&&s[0]=='x'?'x':'o');
	}
	
	public static void main(String[] args) {
		new AOJ2407().run();
	}
}
