package volume01;

import java.util.Scanner;

//Ohajiki Game
public class AOJ0164 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			int[] a = new int[n];
			for(int i=0;i<n;i++)a[i]=sc.nextInt();
			int r = 32;
			int k = 0;
			boolean f = true;
			while(r>0){
				if(f)r-=(r-1)%5;
				else {
					r=Math.max(0, r-a[k]);
					k=(k+1)%n;
				}
				System.out.println(r);
				f=!f;
			}
		}
	}
}
