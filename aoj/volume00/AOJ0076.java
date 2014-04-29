package volume0;

import java.util.Scanner;

//Treasure Hunt II
public class AOJ0076 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==-1)break;
			double x = 1;
			double y = 0;
			for(int i=2;i<=n;i++){
				double d = Math.sqrt(x*x+y*y);
				double dx = -y/d;
				double dy = x/d;
				x+=dx;
				y+=dy;
			}
			System.out.printf("%.2f\n%.2f\n", x, y);
		}
	}
}
