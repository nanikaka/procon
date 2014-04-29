package volume12;

import java.util.Arrays;
import java.util.Scanner;

//Sum of Consecutive prime Numbers
public class AOJ1257 {

	void run(){
		int N = 10000;
		boolean[] p = new boolean[N+1];
		Arrays.fill(p, true);
		p[0]=p[1]=false;
		int[] s = new int[1229];
		int x = 0;
		for(int i=2;i<=N;i++)if(p[i]){
			s[x++] = i;
			for(int j=i+i;j<=N;j+=i)p[j]=false;
		}
		Scanner sc = new Scanner(System.in);
		for(;;){
			int n = sc.nextInt();
			if(n==0)break;
			int res = 0;
			for(int i=0;i<1229;i++){
				int sum = s[i];
				int j = i+1;
				while(sum<n&&j<1229){
					sum+=s[j++];
				}
				if(sum==n)res++;
			}
			System.out.println(res);
		}
	}
	
	public static void main(String[] args) {
		new AOJ1257().run();
	}
}
