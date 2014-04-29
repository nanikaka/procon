package volume01;

import java.util.Scanner;
import static java.lang.Math.*;

//Distance Between Two Cities
public class AOJ0177 {

	double R = 6378.1;
	
	double[] get(double n, double e){
		n = n*PI/180; e = e*PI/180;
		return new double[]{R*Math.sqrt((1-sin(n)*sin(n)))*sin(e), -R*Math.sqrt((1-sin(n)*sin(n)))*cos(e), R*sin(n)};
	}

	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			double n1 = sc.nextDouble(), e1 = sc.nextDouble(), n2 = sc.nextDouble(), e2 = sc.nextDouble();
			if(n1==-1&&e1==-1&&n2==-1&&e2==-1)break;
			double[] a = get(n1, e1), b = get(n2, e2);
			double x = acos((a[0]*b[0]+a[1]*b[1]+a[2]*b[2])/(Math.sqrt(a[0]*a[0]+a[1]*a[1]+a[2]*a[2])*Math.sqrt(b[0]*b[0]+b[1]*b[1]+b[2]*b[2])));
			System.out.printf("%.0f\n", R*x);
		}
	}
	
	public static void main(String[] args) {
		new AOJ0177().run();
	}
}
