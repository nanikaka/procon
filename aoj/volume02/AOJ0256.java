package volume02;

import java.util.Arrays;
import java.util.Scanner;

//Points for a Perfect Scorer
public class AOJ0256 {

	void run(){
		Scanner sc = new Scanner(System.in);
		int res = 0;
		for(int i=0;i<10;i++)res+=sc.nextInt();
		System.out.println(res);
	}
	
	void debug(Object...o){
		System.out.println(Arrays.deepToString(o));
	}
	
	public static void main(String[] args) {
		new AOJ0256().run();
	}
}
