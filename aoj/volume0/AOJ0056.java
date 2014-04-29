package volume0;

import java.util.Arrays;
import java.util.Scanner;

//Goldbach's Conjecture
public class AOJ0056 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[] p = new boolean[50001];
		Arrays.fill(p, true);
		p[0] = p[1] = false;
		for(int i=2;i<50001;i++)if(p[i])for(int j=i*2;j<50001;j+=i)p[j]=false;
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			int c = 0;
			for(int i=2;i<=n/2;i++)if(p[i]&&p[n-i])c++;
			System.out.println(c);
		}
	}
}
