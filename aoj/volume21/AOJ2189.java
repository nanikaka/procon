package volume21;

import java.util.Scanner;

//Addition Game
public class AOJ2189 {

	void run(){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T--!=0){
			String s = sc.next();
			int t = 0;
			while(1<s.length()){
				int x = (s.charAt(0)-'0')+(s.charAt(1)-'0');
				s = x+s.substring(2);
				t = 1-t;
			}
			System.out.println(t==0?"Audrey wins.":"Fabre wins.");
		}
	}
	
	public static void main(String[] args) {
		new AOJ2189().run();
	}
}
