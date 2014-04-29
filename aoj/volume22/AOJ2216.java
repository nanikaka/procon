package volume22;

import java.util.Scanner;

//Summer of KMC
public class AOJ2216 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(a==0&&b==0)break;
			int x = b-a;
			int t = x/1000;
			x %= 1000;
			int g = x/500;
			x %= 500;
			System.out.println(x/100+" "+g+" "+t);
		}
	}
}
