package volume0;

import java.util.Scanner;

//Apple and Peach
public class AOJ0050 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] s = sc.nextLine().toCharArray();
		for(int i=0;i<s.length-4;i++){
			if(s[i]=='a'&&s[i+1]=='p'&&s[i+2]=='p'&&s[i+3]=='l'&&s[i+4]=='e'){
				s[i] = 'p';
				s[i+1] = 'e';
				s[i+2] = 'a';
				s[i+3] = 'c';
				s[i+4] = 'h';
			}
			else if(s[i]=='p'&&s[i+1]=='e'&&s[i+2]=='a'&&s[i+3]=='c'&&s[i+4]=='h'){
				s[i] = 'a';
				s[i+1] = 'p';
				s[i+2] = 'p';
				s[i+3] = 'l';
				s[i+4] = 'e';
			}
		}
		System.out.println(s);
	}
}
