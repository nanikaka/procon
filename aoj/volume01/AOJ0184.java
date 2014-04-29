package volume01;

import java.util.Scanner;

//Tsuruga Castle
public class AOJ0184 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			int[] c = new int[7];
			while(n--!=0){
				int x = sc.nextInt();
				int k = 0;
				while(k<6&&x>=(k+1)*10)k++;
				c[k]++;
			}
			for(int a:c)System.out.println(a);
		}
	}
}
