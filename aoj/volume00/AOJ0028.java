package volume0;

import java.util.Scanner;

//Mode Value
public class AOJ0028 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] c = new int[101];
		int m = 0;
		while(sc.hasNext())	m = Math.max(m, ++c[sc.nextInt()]);
		for(int i=1;i<=100;i++)if(m==c[i])System.out.println(i);
	}
}
