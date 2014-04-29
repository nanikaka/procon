package volume02;

import java.util.Arrays;
import java.util.Scanner;

//Thanksgiving
public class AOJ0227 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			int m = sc.nextInt();
			if((n|m)==0)break;
			int[] a = new int[n];
			int s = 0;
			for(int i=0;i<n;i++){
				a[i] = sc.nextInt();
				s+=a[i];
			}
			Arrays.sort(a);
			int k = 0;
			for(int i=n-1;i>=0;i--){
				k++;
				if(k%m==0)s-=a[i];
			}
			System.out.println(s);
		}
	}
}
