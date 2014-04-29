package volume11;

import java.util.Scanner;

//The Genome Database of All Space Life
public class AOJ1145 {

	static char[] s;
	static int id;
	static int len;

	static String msg(){
		StringBuilder sb = new StringBuilder();
		int x = 1;
		while(true){
			char ch = s[id++];
			if(Character.isDigit(ch)){
				id--;
				x = num();
			}
			else if(ch=='('){
				String t = msg();
				while(sb.length() <= len && x--!=0){
					for(int i=0;i<t.length();i++){
						if(sb.length() > len)break;
						sb.append(t.charAt(i));
					}
				}
				x = 1;
			}
			else if(Character.isUpperCase(ch)){
				while(sb.length() <= len && x--!=0)sb.append(ch);
				x = 1;
			}
			else break;
		}
		return sb.toString();
	}

	static int num(){
		char ch = s[id++];
		int x = ch - '0';
		while(true){
			ch = s[id++];
			if(!Character.isDigit(ch))break;
			x *= 10;
			x += ch - '0';
		}
		id--;
		return x;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			String ss = sc.next();
			len = sc.nextInt();
			if(ss.equals("0") && len == 0)break;
			s = (ss+"#").toCharArray();
			id = 0;
			len++;
			String genom = msg();
			System.out.println(genom.length() >= len ? genom.charAt(len-1) : "0");
		}
	}
}
