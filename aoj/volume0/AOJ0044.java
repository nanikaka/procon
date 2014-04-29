package volume0;

import java.util.Arrays;
import java.util.Scanner;

//Prime Number II
public class AOJ0044 {

	public static void main(String[] args) {
		boolean[] p = new boolean[55000];
		Arrays.fill(p, true);
		p[0]=p[1]=false;
		for(int i=2;i<55000;i++)if(p[i])for(int j=i*2;j<55000;j+=i)p[j]=false;
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			int d = n-1;
			int u = n+1;
			while(!p[d])d--;
			while(!p[u])u++;
			System.out.println(d+" "+u);
		}
	}
}
