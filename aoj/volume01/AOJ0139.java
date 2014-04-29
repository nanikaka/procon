package volume01;

import java.util.Scanner;

//Snakes
public class AOJ0139 {

	static boolean isA(char[] s){
		if(s.length<6)return false;
		if(!(s[0]=='>'&&s[1]=='\''))return false;
		int con = 0;
		while(2+con<s.length && s[2+con]=='=')con++;
		if(con==0)return false;
		if(2+con==s.length||s[2+con]!='#')return false;
		int b = 3+con;
		int sec = 0;
		while(b+sec<s.length && s[b+sec]=='=')sec++;
		if(sec!=con||b+sec==s.length)return false;
		return s[b+sec]=='~'&&b+sec==s.length-1;
	}
	
	static boolean isB(char[] s){
		if(s.length<6)return false;
		if(!(s[0]=='>'&&s[1]=='^'))return false;
		int i = 2;
		int c = 0;
		while(i+1<s.length && s[i]=='Q' && s[i+1]=='='){
			i+=2;c++;
		}
		if(i+1>=s.length||c==0)return false;
		return i+1==s.length-1 && s[i]=='~' && s[i+1]=='~';
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t--!=0){
			char[] s = sc.next().toCharArray();
			System.out.println(isA(s)?"A":isB(s)?"B":"NA");
		}
	}
}
