package volume0;

import java.util.Scanner;

//Parallelism
public class AOJ0021 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while(n--!=0){
			double[] a = new double[8];
			for(int i=0;i<8;i++)a[i]=sc.nextDouble();
			double e = (a[2]-a[0])*(a[7]-a[5])-(a[3]-a[1])*(a[6]-a[4]);
			System.out.println(e==0?"YES":"NO");
		}
	}
}
