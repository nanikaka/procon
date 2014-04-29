package volume02;

import java.util.Scanner;

//Big Hit !
public class AOJ0229 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int b = sc.nextInt();
			int r = sc.nextInt();
			int g = sc.nextInt();
			int c = sc.nextInt();
			int s = sc.nextInt();
			int t = sc.nextInt();
			if((b|r|g|c|s|t)==0)break;
			System.out.println(100 + b*15 + r*15 + (b*5+r*3)*15 + g*7 + c*2 - (b*5+r*3)*2 - (t-b*5-r*3-s)*3);
		}
	}
}
