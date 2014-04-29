package volume0;

import java.util.Scanner;

//Sum and Average
public class AOJ0045 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = 0;
		int n = 0;
		int k = 0;
		while(sc.hasNext()){
			String[] s = sc.next().split(",");
			k++;
			int m = Integer.parseInt(s[1]);
			n+=m;
			v+=Integer.parseInt(s[0])*m;
		}
		System.out.printf("%.0f\n%.0f\n", v*1.0, n*1.0/k);
	}
}
