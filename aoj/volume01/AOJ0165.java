package volume01;

import java.util.Arrays;
import java.util.Scanner;

//Lottery
public class AOJ0165 {

	public static void main(String[] args) {
		boolean[] p = new boolean[1000001];
		int[] s = new int[1000001];
		Arrays.fill(p, true);
		p[0]=p[1]=false;
		for(int i=2;i<1000001;i++){
			s[i] = s[i-1];
			if(p[i]){
				s[i]++;
				for(int j=i*2;j<1000001;j+=i)p[j]=false;
			}
		}
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			int prime = 0;
			while(n--!=0){
				int P = sc.nextInt();
				int m = sc.nextInt();
				int l = Math.max(1, P-m);
				int r = Math.min(1000000, P+m);
				int x = s[r]-s[l-1];
				if(x==0)prime--;
				else prime+=x-1;
			}
			System.out.println(prime);
		}
	}
}
