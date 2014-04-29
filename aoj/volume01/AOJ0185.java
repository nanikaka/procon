package volume01;

import java.util.Arrays;
import java.util.Scanner;

//Goldbach's Conjecture II
public class AOJ0185 {

	public static void main(String[] args) {
		boolean[] p = new boolean[1000001];
		Arrays.fill(p, true);
		p[0]=p[1]=false;
		for(int i=2;i<1000001;i++)if(p[i])for(int j=i*2;j<1000001;j+=i)p[j]=false;
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			int c = 0;
			for(int i=2;i<=n/2;i++)if(p[i]&&p[n-i])c++;
			System.out.println(c);
		}
	}
}
