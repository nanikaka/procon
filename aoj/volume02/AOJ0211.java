package volume02;

import java.util.Arrays;
import java.util.Scanner;

//Jogging
public class AOJ0211 {

	static long gcd(long a, long b){
		if(a < b){
			long tmp = a;
			a = b;
			b = tmp;
		}
		while(b!=0){
			long r = a%b;
			a = b;
			b = r;
		}
		return a;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			int[] d = new int[n];
			int[] v = new int[n];
			for(int i=0;i<n;i++){
				d[i]=sc.nextInt();
				v[i]=sc.nextInt();
			}
			int[] a = new int[n];
			Arrays.fill(a, 1);
			for(int i=0;i<n;i++){
				for(int j=i+1;j<n;j++){
					int k1 = d[i]*v[j];
					int k2 = d[j]*v[i];
					int g = (int)gcd(k1,k2);
					k1/=g;
					k2/=g;
					int g1 = (int)gcd(a[i],k2);
					int g2 = (int)gcd(a[j],k1);
					a[i]*=k2/g1;
					a[j]*=k1/g2;
				}
			}
			for(int i=0;i<n;i++)System.out.println(a[i]);
		}
	}
}
