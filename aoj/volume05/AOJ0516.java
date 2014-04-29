package volume05;

import java.util.Scanner;

//Maximum Sum
public class AOJ0516 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			int k = sc.nextInt();
			if(n==0&&k==0)break;
			int a[] = new int[n];
			for(int i=0;i<n;i++)a[i]=sc.nextInt();
			int s = 0;
			int t = 0;
			int tmp = 0;
			while(t < k){
				tmp += a[t];
				t++;
			}
			int max = tmp;
			while(t < n){
				tmp -= a[s++];
				tmp += a[t++];
				max = Math.max(max, tmp);
			}
			System.out.println(max);
		}
	}
}
