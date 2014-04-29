package volume01;

import java.util.Scanner;

//Alphametic
public class AOJ0110 {

	static char[] s;
	static int id;
	
	static boolean exp(){
		int a = fact();
		if(a==-1)return false;
		while(true){
			char c = s[id++];
			if(c=='=')break;
			int x = fact();
			if(x==-1)return false;
			a+=x;
		}
		int b = fact();
		if(b==-1)return false;
		return a==b;
	}
	
	static int fact(){
		int x = s[id++]-'0';
		if(x==0&&Character.isDigit(s[id]))return -1;
		while(Character.isDigit(s[id])){
			x *= 10;
			x += s[id++]-'0';
		}
		return x;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String r = sc.next();
			String ans = "NA";
			for(int i=0;i<10;i++){
				s = (r.replace("X", (char)(i+'0')+"")+"$").toCharArray();
				id = 0;
				if(exp()){
					ans = i+"";
					break;
				}
			}
			System.out.println(ans);
		}
	}
}
