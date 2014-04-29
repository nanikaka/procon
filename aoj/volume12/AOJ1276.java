package volume12;

import java.util.Arrays;
import java.util.Scanner;

//Prime Gap
public class AOJ1276 {

	void run(){
		int N = 1299709;
		boolean[] p = new boolean[N+1];
		Arrays.fill(p, true);
		p[0]=p[1]=true;
		for(int i=2;i<=N;i++)if(p[i])for(int j=i+i;j<=N;j+=i)p[j]=false;
		Scanner sc = new Scanner(System.in);
		for(;;){
			int k = sc.nextInt();
			if(k==0)break;
			int l = k, r = k;
			while(!p[l])l--;
			while(!p[r])r++;
			System.out.println(r-l);
		}
	}
	
	public static void main(String[] args) {
		new AOJ1276().run();
	}
}
