package volume10;

import java.util.Scanner;

//KND is So Sexy
public class AOJ1091 {

	void run(){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int a = sc.nextInt(), l = sc.nextInt(), x = sc.nextInt();
			double t = (2*l+a)/2., s = (2*l+x)/2.;
			System.out.printf("%.8f\n", 2*Math.sqrt(s*(s-l)*(s-(l+x)/2.)*(s-(l+x)/2.)) + Math.sqrt(t*(t-a)*(t-l)*(t-l)));
		}
	}
	
	public static void main(String[] args) {
		new AOJ1091().run();
	}
}
