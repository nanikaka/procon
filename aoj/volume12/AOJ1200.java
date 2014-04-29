package volume12;

import java.util.Arrays;
import java.util.Scanner;

//Goldbach's Conjecture
public class AOJ1200 {

	void run(){
		Scanner sc = new Scanner(System.in);
		boolean[] p = new boolean[1<<15];
		Arrays.fill(p, true);
		p[0]=p[1]=false;
		for(int i=2;i<1<<15;i++)if(p[i])for(int j=i+i;j<1<<15;j+=i)p[j]=false;
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			int c = 0;
			for(int i=2;i<=n/2;i++)if(p[i]&&p[n-i])c++;
			System.out.println(c);
		}
	}
	
	public static void main(String[] args) {
		new AOJ1200().run();
	}
}
