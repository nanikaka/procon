package volume05;

import java.util.Scanner;

//Tile
public class AOJ0556 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		while(k--!=0){
			int i = sc.nextInt()-1;
			int j = sc.nextInt()-1;
			if(n/2<=i)i=n-i-1;
			if(n/2<=j)j=n-j-1;
			System.out.println(Math.min(i, j)%3+1);
		}

	}
}
