package volume22;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//Shiritori
public class AOJ2273 {

	Set<String> words;

	String make(char s, char t){
		String x = s+""+t;
		if(!words.contains(x))return x;
		for(int i=0;i<26;i++){
			String r = s + ""+((char)(i+'a')) + t + "";
			if(!words.contains(r))return r;
		}
		return s+"a"+t;
	}

	void run(){
		Scanner sc = new Scanner(System.in);
		words = new HashSet<String>();
		System.out.println("?a");
		System.out.flush();
		words.add("a");
		while(true){
			String res = sc.next();
			if(res.length()==1 || res.charAt(0)!='a' || words.contains(res)){
				System.out.println("!OUT");
				System.out.flush();
				break;
			}
			words.add(res);
			char h = res.charAt(1);
			String n = make(h, 'a');
			words.add(n);
			System.out.println("?"+n);
			System.out.flush();
		}
	}

	public static void main(String[] args) {
		new AOJ2273().run();
	}
}
