package volume11;

import java.util.Scanner;

//The Balance of the World
public class AOJ1173 {

	static char[] s;
	static int k;

	static boolean f(char ch){
		while(k<s.length){
			char c = s[k++];
			if((c=='('||c=='[')&&!f(c))return false;
			else if(ch=='('&&c==']')return false;
			else if(ch=='['&&c==')')return false;
			else if(ch=='('&&c==')')return true;
			else if(ch=='['&&c==']')return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			s = sc.nextLine().toCharArray();
			if(s.length==1)break;
			k = 0;
			boolean f = true;
			while(k<s.length){
				char c = s[k++];
				if(c=='('||c=='[')f&=f(c);
				else if(c==')'||c==']')f=false;
			}
			System.out.println(f?"yes":"no");
		}
	}
}
