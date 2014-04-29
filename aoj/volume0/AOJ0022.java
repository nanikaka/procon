package volume0;

import java.util.Scanner;

//Maximum Sum Sequence
public class AOJ0022 {

	public static int cs(int[] a){
		int min = 0;
		int x = 0;
		int max = Integer.MIN_VALUE;
		for(int i=0;i<a.length;i++){
			x += a[i];
			max = Math.max(max, x-min);
			min = Math.min(min, x);
		}
		return max;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			int a[] = new int[n];
			for(int i=0;i<n;i++)a[i]=sc.nextInt();
			System.out.println(cs(a));
		}
	}
}
