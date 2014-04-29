package volume02;

import java.util.Scanner;

//Walking in the Hospital
public class AOJ0217 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			int max = 0;
			int p = 0;
			while(n--!=0){
				int x = sc.nextInt();
				int d = sc.nextInt()+sc.nextInt();
				if(max<d){
					max = d;
					p = x;
				}
			}
			System.out.println(p+" "+max);
		}
	}
}
