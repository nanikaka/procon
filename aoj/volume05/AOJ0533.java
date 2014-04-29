package volume05;

import java.util.Arrays;
import java.util.Scanner;

//Contest
public class AOJ0533 {

	void run(){
		Scanner sc = new Scanner(System.in);
		int[]w = new int[10];
		int[]k = new int[10];
		for(int i=0;i<10;i++)w[i]=sc.nextInt();
		for(int i=0;i<10;i++)k[i]=sc.nextInt();
		Arrays.sort(w);
		Arrays.sort(k);
		System.out.println((w[7]+w[8]+w[9])+" "+(k[7]+k[8]+k[9]));
	}
	
	public static void main(String[] args) {
		new AOJ0533().run();
	}
}
