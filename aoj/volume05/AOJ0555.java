package volume05;

import java.util.Scanner;

//Ring
public class AOJ0555 {

	void run(){
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int n = sc.nextInt();
		int c = 0;
		while(n--!=0){
			String t = sc.next();
			t = t+t;
			if(t.contains(s))c++;
		}
		System.out.println(c);
	}
	
	public static void main(String[] args) {
		new AOJ0555().run();
	}
}
