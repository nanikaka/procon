package volume01;

import java.util.Scanner;

//Operation of Frequency of Appearance
public class AOJ0108 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			int[] a = new int[n];
			for(int i=0;i<n;i++)a[i]=sc.nextInt();
			int k = 0;
			while(true){
				int[] next = new int[n];
				int[] c = new int[101];
				for(int i:a)c[i]++;
				boolean f = true;
				for(int i=0;i<n;i++){
					next[i]=c[a[i]];
					if(next[i]!=a[i])f = false;
				}
				if(f){
					System.out.print(k+"\n"+a[0]);
					for(int i=1;i<n;i++)System.out.print(" " + a[i]);
					System.out.println();
					break;
				}
				k++;
				a = next;
			}
		}
	}
}
