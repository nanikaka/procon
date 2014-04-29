package volume05;

import java.util.Scanner;

//Caesar Cipher
public class AOJ0512 {

	void run(){
		Scanner sc = new Scanner(System.in);
		char[]s = sc.next().toCharArray();
		for(int i=0;i<s.length;i++)s[i]=(char)((s[i]-'A'+23)%26+'A');
		System.out.println(s);
	}

	public static void main(String[] args) {
		new AOJ0512().run();
	}
}
