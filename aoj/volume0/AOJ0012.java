package volume0;

import java.util.Scanner;

//A Point in a Triangle
public class AOJ0012 {

	public static double ex(double ox, double oy, double x1, double y1, double x2, double y2){
		double vx1 = x1-ox;
		double vy1 = y1-oy;
		double vx2 = x2-ox;
		double vy2 = y2-oy;
		return vx1*vy2-vx2*vy1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			double[][] p = new double[3][2];
			for(int i=0;i<3;i++){
				p[i][0] = sc.nextDouble();
				p[i][1] = sc.nextDouble();
			}
			double px = sc.nextDouble();
			double py = sc.nextDouble();

			boolean f = true;
			boolean g = true;
			for(int i=0;i<3;i++){
				double ex = ex(p[i][0], p[i][1], p[(i+1)%3][0], p[(i+1)%3][1], px, py);
				if(ex >= 0){
					f = false;
				}
				if(ex <= 0){
					g = false;
				}
			}
			System.out.println(f||g?"YES":"NO");
		}
	}
}
