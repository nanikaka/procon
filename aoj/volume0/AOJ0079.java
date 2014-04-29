package volume0;

import java.util.Scanner;

//Area of Polygon
public class AOJ0079 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double[][] p = new double[20][2];
		int n = 0;
		while(sc.hasNext()){
			String s[] = sc.next().split(",");
			p[n][0]=Double.parseDouble(s[0]);
			p[n][1]=Double.parseDouble(s[1]);
			n++;
		}
		double a = 0;
		for(int i=0;i<n;i++){
			double x1 = p[i][0];
			double y1 = p[i][1];
			double x2 = p[(i+1)%n][0];
			double y2 = p[(i+1)%n][1];
			a += x1*y2-x2*y1;
		}
		System.out.println(Math.abs(a/2));
	}
}
