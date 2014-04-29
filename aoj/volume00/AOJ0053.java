package volume0;

import java.util.Arrays;
import java.util.Scanner;

//Sum of Prime Numbers
public class AOJ0053 {

	public static void main(String[] args) {
		boolean[] p = new boolean[104730];
		int[] s = new int[10001];
		int k=0;
		s[k++]=0;
		Arrays.fill(p, true);
		for(int i=2;i<104730;i++){
			if(p[i]){
				s[k]=s[k-1]+i;
				k++;
				for(int j=i*2;j<104730;j+=i)p[j]=false;
			}
		}
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			System.out.println(s[n]);
		}
	}
}
