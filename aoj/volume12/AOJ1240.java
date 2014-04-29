package volume12;

import java.util.Scanner;

//Unreliable Message
public class AOJ1240 {

	String J(String s){
		return s.charAt(s.length()-1)+s.substring(0, s.length()-1);
	}
	String C(String s){
		return s.substring(1)+s.charAt(0);
	}
	String E(String s){
		return s.length()%2==0?s.substring(s.length()/2, s.length())+s.substring(0, s.length()/2):
			s.substring(s.length()/2+1, s.length())+s.charAt(s.length()/2)+s.substring(0, s.length()/2);
	}
	String A(String s){
		return new StringBuilder(s).reverse().toString();
	}
	String P(String s){
		String res = "";
		for(char c:s.toCharArray()){
			if(!Character.isDigit(c))res+=c;
			else res += (char)((c-'0'+9)%10+'0');
		}
		return res;
	}
	String M(String s){
		String res = "";
		for(char c:s.toCharArray()){
			if(!Character.isDigit(c))res+=c;
			else res += (char)((c-'0'+1)%10+'0');
		}
		return res;
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t--!=0){
			char[] c = sc.next().toCharArray();
			String s = sc.next();
			for(int i=c.length-1;i>=0;i--)s=c[i]=='J'?J(s):c[i]=='C'?C(s):c[i]=='E'?E(s):c[i]=='A'?A(s):c[i]=='P'?P(s):M(s);
			System.out.println(s);
		}
	}

	public static void main(String[] args) {
		new AOJ1240().run();
	}
}
