package volume10;

import java.util.Arrays;
import java.util.Scanner;

//Pair of Primes
public class AOJ1004 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[] p = new boolean[10002];
		Arrays.fill(p, true);
		p[0] = p[1] = false;
		for(int i=2;i<=10001;i++){
			if(p[i]){
				for(int j=i*2;j<=10001;j+=i)p[j]=false;
			}
		}
		while(sc.hasNext()){
			int n = sc.nextInt();
			int c = 0;
			for(int i=1;i<=n;i++)if(p[i]&&p[n+1-i])c++;
			System.out.println(c);
		}
	}
}
