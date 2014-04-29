package volume0;

import java.util.Scanner;

//Orthogonal
public class AOJ0058 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			double[][] p = new double[4][2];
			for(int i=0;i<4;i++){
				p[i][0] = sc.nextDouble();
				p[i][1] = sc.nextDouble();
			}
			double vx1 = p[1][0]-p[0][0];
			double vy1 = p[1][1]-p[0][1];
			double vx2 = p[3][0]-p[2][0];
			double vy2 = p[3][1]-p[2][1];
			System.out.println((vx1*vx2+vy1*vy2)==0?"YES":"NO");
		}
	}
}
