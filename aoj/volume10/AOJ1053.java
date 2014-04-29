package volume10;

import java.util.Scanner;

//Accelerated Railgun
public class AOJ1053 {

	void run(){
		Scanner sc = new Scanner(System.in);
		while(true){
			double d = sc.nextDouble();
			if(d==0)break;
			double px = sc.nextDouble();
			double py = sc.nextDouble();
			double vx = sc.nextDouble();
			double vy = sc.nextDouble();
			double x1 = -px;
			double y1 = -py;
			double x2 = vx;
			double y2 = vy;
			if(Math.abs(x1*y2-x2*y1)>1e-8){
				System.out.println("impossible");continue;
			}
			double k = x2!=0?x1/x2:y1/y2;
			double D = 0;
			if(k>0)D = Math.hypot(px, py);
			else D = 2-Math.hypot(px, py);
			System.out.println(D<=d?D:"impossible");
		}
	}
	
	public static void main(String[] args) {
		new AOJ1053().run();
	}
}
