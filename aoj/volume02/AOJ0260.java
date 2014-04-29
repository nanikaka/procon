package volume02;

import java.util.Arrays;
import java.util.Scanner;

//Salary for a Plumber
public class AOJ0260 {

	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			int n = sc.nextInt();
			if(n==0)break;
			int[] q = new int[n-1];
			long sum = 0;
			for(int i=0;i<n;i++)sum+=sc.nextInt();
			for(int i=0;i<n-1;i++)q[i]=sc.nextInt();
			Arrays.sort(q);
			long res = sum*n;
			for(int i=n-2;i>=0;i--){
				sum+=q[i];
				res = Math.max(res, sum*(i+1));
			}
			System.out.println(res);
		}
	}
	
	void debug(Object...o){
		System.out.println(Arrays.deepToString(o));
	}
	
	public static void main(String[] args) {
		new AOJ0260().run();
	}
}
