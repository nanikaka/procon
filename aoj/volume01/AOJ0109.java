package volume01;

import java.util.Scanner;

//Smart Calculator
public class AOJ0109 {

	static char[] s;
	static int id;
	
	static int exp(){
		int r = term();
		while(true){
			char c = s[id++];
			if(c=='+')r+=term();
			else if(c=='-')r-=term();
			else break;
		}
		return r;
	}
	
	static int term(){
		int r = fact();
		while(true){
			char c = s[id++];
			if(c=='*') r*=fact();
			else if(c=='/')r/=fact();
			else break;
		}
		id--;
		return r;
	}
	
	static int fact(){
		char c = s[id++];
		if(c=='(')return exp();
		if(c=='-'){
			return -fact();
		}
		if(c=='+'){
			return fact();
		}
		int x = c-'0';
		while(true){
			c = s[id++];
			if(Character.isDigit(c)){
				x *= 10;
				x += c-'0';
			}
			else break;
		}
		id--;
		return x;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t--!=0){
			s = sc.next().toCharArray();
			id = 0;
			System.out.println(exp());
		}
	}
}
