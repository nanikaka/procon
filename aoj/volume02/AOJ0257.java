package volume02;

import java.util.Arrays;
import java.util.Scanner;

//Railway Ticket
public class AOJ0257 {

	void run(){
		Scanner sc = new Scanner(System.in);
		int x = 4*sc.nextInt()+2*sc.nextInt()+sc.nextInt();
		System.out.println(x==6||x==1?"Open":"Close");
	}
	
	void debug(Object...o){
		System.out.println(Arrays.deepToString(o));
	}
	
	public static void main(String[] args) {
		new AOJ0257().run();
	}
}
