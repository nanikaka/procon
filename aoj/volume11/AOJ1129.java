package volume11;

import java.util.Scanner;

//Hanafuda Shuffle
public class AOJ1129 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			int r = sc.nextInt();
			if((n|r)==0)break;
			int[] a = new int[n];
			for(int i=1;i<=n;i++)a[n-i]=i;
			while(r--!=0){
				int p = sc.nextInt()-1;
				int c = sc.nextInt();
				int[] t = new int[p];
				for(int i=0;i<p;i++)t[i]=a[i];
				for(int i=0;i<c;i++)a[i]=a[i+p];
				for(int i=0;i<p;i++)a[i+c]=t[i];
			}
			System.out.println(a[0]);
		}
	}
}
