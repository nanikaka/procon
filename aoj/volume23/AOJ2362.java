package volume23;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Chicken or the Egg
public class AOJ2362 {

	void run(){
		Scanner sc = new Scanner(System.in);
		String s = sc.next().replace("egg", "E").replace("chicken", "C");
		List<String> l = new ArrayList<String>();
		int p = 0;
		for(int i=0;i+1<s.length();i++){
			if(s.charAt(i)==s.charAt(i+1)){
				l.add(s.substring(p, i+1));
				p = i+1;
			}
		}
		l.add(s.substring(p, s.length()));
		String res = "";
		int m = 0;
		for(String t:l){
			if(m<t.length()){
				m = t.length(); res = t.charAt(m-1)=='E'?"egg":"chicken";
			}
		}
		System.out.println(res);
	}
	
	public static void main(String[] args) {
		new AOJ2362().run();
	}
}
