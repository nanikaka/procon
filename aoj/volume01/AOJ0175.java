package volume01;

import java.math.BigInteger;
import java.util.Scanner;

//A King in Hawaii
public class AOJ0175 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			BigInteger b = sc.nextBigInteger();
			if(b.intValue()==-1)break;
			System.out.println(b.toString(4));
		}
	}
}
