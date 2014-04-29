package volume01;

import java.util.Scanner;

//Middle-Square Method
public class AOJ0137 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Case = 1;
		int t = sc.nextInt();
		while(t--!=0){
			System.out.println("Case " + Case++ + ":");
			int x = sc.nextInt();
			x*=x;
			for(int i=0;i<10;i++){
				String s = x+"";
				while(s.length()<8)s="0"+s;
				x = Integer.parseInt(s.substring(2,6));
				System.out.println(x);
				x*=x;
			}
		}
	}
}
