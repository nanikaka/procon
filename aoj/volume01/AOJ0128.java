package volume01;

import java.util.Scanner;

//Abacus
public class AOJ0128 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean f = true;
		while(sc.hasNext()){
			if(!f)System.out.println();
			f = false;
			int x = sc.nextInt();
			int[] a = new int[5];
			for(int i=0;i<5;i++){
				a[i] = x%10;
				x/=10;
			}
			for(int i=4;i>=0;i--)System.out.print(a[i]>=5?" ":"*");
			System.out.println();
			for(int i=4;i>=0;i--)System.out.print(a[i]>=5?"*":" ");
			System.out.println("\n=====");
			for(int i=0;i<5;i++){
				for(int j=4;j>=0;j--){
					System.out.print(a[j]%5==i?" ":"*");
				}
				System.out.println();
			}
		}
	}
}
