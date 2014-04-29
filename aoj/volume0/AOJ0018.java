package volume0;

import java.util.Scanner;

//Sorting Five Numbers
public class AOJ0018 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a[] = new int[5];
		for(int i=0;i<5;i++)a[i]=sc.nextInt();
		for(int i=0;i<4;i++){
			int m = i;
			for(int j=i+1;j<5;j++){
				if(a[j]>a[m])m=j;
			}
			int t = a[i];
			a[i]=a[m];
			a[m]=t;
		}
		for(int i=0;i<4;i++)System.out.print(a[i]+" ");
		System.out.println(a[4]);
	}
}
