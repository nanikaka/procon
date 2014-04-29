package volume05;

import java.util.Scanner;

//Card Game
public class AOJ0500 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			int p1 = 0;
			int p2 = 0;
			while(n--!=0){
				int a = sc.nextInt();
				int b = sc.nextInt();
				if(a>b)p1+=a+b;
				else if(a<b)p2+=a+b;
				else {
					p1+=a;
					p2+=b;
				}
			}
			System.out.println(p1 + " " + p2);
		}
	}
}
