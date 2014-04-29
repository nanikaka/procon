package volume02;

import java.util.Arrays;
import java.util.Scanner;

//Prime Quadruplet
public class AOJ0222 {

	public static void main(String[] args) {
		int N = 10000000;
		boolean[] p = new boolean[N];
		Arrays.fill(p, true);
		p[0]=p[1]=false;
		for(int i=2;i<N;i++)if(p[i])for(int j=i*2;j<N;j+=i)p[j]=false;
		int[] q = new int[900];
		int id = 0;
		for(int i=13;i<N;i+=2){
			if(p[i-8]&&p[i-6]&&p[i-2]&&p[i]){
				q[id++]=i;
			}
		}
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			int k = 0;
			while(k<id){
				if(q[k]>n)break;
				k++;
			}
			System.out.println(q[k-1]);
		}
	}
}
