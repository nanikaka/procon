package volume0;

import java.util.Arrays;
import java.util.Scanner;

//Prime Number
public class AOJ0009 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[] f = new boolean[1000000];
		Arrays.fill(f, true);
		for(int i=2;i<1000000;i++)if(f[i])for(int j=i*2;j<1000000;j+=i)f[j]=false;
		while(sc.hasNext()){
			int n = sc.nextInt();
			int c = 0;
			for(int i=2;i<=n;i++)c+=f[i]?1:0;
			System.out.println(c);
		}
	}
}
