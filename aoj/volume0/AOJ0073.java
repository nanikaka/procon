package volume0;

import java.util.Scanner;

//Surface Area of Quadrangular Pyramid
public class AOJ0073 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			double x = sc.nextDouble();
			double h = sc.nextDouble();
			if(x==0&&h==0)break;
			double r = Math.sqrt(h*h+(x/2)*(x/2));
			System.out.println((x*x+2*r*x));
		}
	}
}
