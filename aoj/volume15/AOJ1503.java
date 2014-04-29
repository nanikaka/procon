package volume15;

import java.math.BigInteger;
import java.util.Scanner;

//Numbers
public class AOJ1503 {

	void run(){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		BigInteger b = BigInteger.ONE;
		for(int i=2;i<=n+1;i++)b = b.multiply(BigInteger.valueOf(i));
		System.out.println(b.add(BigInteger.valueOf(2)));
		for(int i=2;i<=n+1;i++)System.out.println(i);
	}
	
	public static void main(String[] args) {
		new AOJ1503().run();
	}
}
