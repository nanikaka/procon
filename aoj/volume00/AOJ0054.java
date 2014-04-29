package volume0;

import java.util.Scanner;

//Sum of Nth decimal places
public class AOJ0054 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int a = sc.nextInt();
			int b = sc.nextInt();
			int n = sc.nextInt();
			int k = 1;
			int s = 0;
			int r = a%b;
			while(k<=n&&r>0){
				s += r*10/b;
				r = r*10%b;
				k++;
			}
			System.out.println(s);
		}
	}
}
