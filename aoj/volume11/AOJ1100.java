package volume11;

import java.util.Scanner;

//Area of Polygons
public class AOJ1100 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Case = 1;
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			double a[][] = new double[n][2];
			for(int i=0;i<n;i++){
				a[i][0] = sc.nextDouble();
				a[i][1] = sc.nextDouble();
			}
			double area = 0;
			for(int i=0;i<n-1;i++)area+=(a[i][0]*a[i+1][1]-a[i][1]*a[i+1][0])/2;
			area+=(a[n-1][0]*a[0][1]-a[n-1][1]*a[0][0])/2;
			System.out.printf("%d %.1f\n", Case++, -area);
		}
	}
}
