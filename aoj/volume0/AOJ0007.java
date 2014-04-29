package volume0;

import java.util.Scanner;

//Debt Hell
public class AOJ0007 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a = 100000;
		while(n--!=0){
			a+=a/20;
			int r=a%1000;
			if(r!=0)a+=1000-r;
		}
		System.out.println(a);
	}
}
