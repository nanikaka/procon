package volume01;

import java.util.Scanner;

//Bubble Sort
public class AOJ0167 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			int[] a = new int[n];
			for(int i=0;i<n;i++)a[i]=sc.nextInt();
			int s = 0;
			for(int j=n-1;j>=1;j--){
				for(int i=0;i<j;i++){
					if(a[i+1]<a[i]){
						int t = a[i];
						a[i]=a[i+1];
						a[i+1]=t;
						s++;
					}
				}
			}
			System.out.println(s);
		}
	}
}
