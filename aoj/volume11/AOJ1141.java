package volume11;

import java.util.Arrays;
import java.util.Scanner;

//Dirichlet's Theorem on Arithmetic Progressions
public class AOJ1141 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[] f = new boolean[1000000];
		Arrays.fill(f, true);
		f[0] = f[1] = false;
		for(int i=2;i<1000000;i++){
			if(f[i])for(int j=i*2;j<1000000;j+=i)f[j]=false;
		}
		while(true){
			int a = sc.nextInt();
			int d = sc.nextInt();
			int n = sc.nextInt();
			if((a|d|n)==0)break;
			int x = a;
			while(true){
				if(f[x])n--;
				if(n==0)break;
				x += d;
			}
			System.out.println(x);
		}
	}
}
