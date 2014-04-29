package volume05;

import java.util.Scanner;

//Shuffle The Cards
public class AOJ0513 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] c = new int[2*n];
		for(int i=0;i<2*n;i++)c[i]=i+1;
		int m = sc.nextInt();
		while(m--!=0){
			int k = sc.nextInt();
			if(k==0){
				int[] a = new int[n];
				int[] b = new int[n];
				for(int i=0;i<2*n;i++){
					if(i<n) a[i]=c[i];
					else b[i-n]=c[i];
				}
				for(int i=0;i<n;i++){
					c[2*i] = a[i];
					c[2*i+1] = b[i];
				}
			}
			else{
				int[] a = new int[k];
				for(int i=0;i<k;i++)a[i]=c[i];
				for(int i=k;i<2*n;i++)c[i-k]=c[i];
				for(int i=0;i<k;i++)c[i+2*n-k]=a[i];
			}
		}
		for(int a:c)System.out.println(a);
	}
}
