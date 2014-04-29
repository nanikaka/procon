package volume05;

import java.util.Arrays;
import java.util.Scanner;

//Walking Santa
public class AOJ0563 {

	long res, rx, ry;
	int n;
	int[] x, y;
	int[][] p;
	
	void f(int px, int py){
		long max = 0, sum = 0;
		for(int i=0;i<n;i++){
			long len = Math.abs(px-p[i][0])+Math.abs(py-p[i][1]);
			sum+=2*len;
			max = Math.max(max, len);
		}
		if(sum-max < res){
			res = sum-max;
			rx = px; ry = py;
		}
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		sc.nextInt(); sc.nextInt();
		n = sc.nextInt();
		x = new int[n]; y = new int[n];
		p = new int[n][2];
		for(int i=0;i<n;i++){
			x[i] = p[i][0] = sc.nextInt(); y[i] = p[i][1] = sc.nextInt();
		}
		Arrays.sort(x);
		Arrays.sort(y);
		res = 1L<<60;
		f(x[(n-1)/2], y[(n-1)/2]);
		f(x[(n-1)/2], y[n/2]);
		f(x[n/2], y[(n-1)/2]);
		f(x[n/2], y[n/2]);
		System.out.println(res);
		System.out.println(rx+" "+ry);
	}
	
	public static void main(String[] args) {
		new AOJ0563().run();
	}
}
