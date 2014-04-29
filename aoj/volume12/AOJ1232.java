package volume12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//Calling Extraterrestrial Intelligence Again
public class AOJ1232 {

	void run(){
		Scanner sc = new Scanner(System.in);
		int N = 100000;
		boolean[] f = new boolean[N+1];
		Arrays.fill(f, true);
		List<Integer> sieve = new ArrayList<Integer>();
		f[0]=f[1]=false;
		for(int i=2;i<=N;i++)if(f[i]){
			sieve.add(i);
			for(int j=i+i;j<=N;j+=i)f[j]=false;
		}
		int n = sieve.size();
		for(;;){
			int m = sc.nextInt(), a = sc.nextInt(), b = sc.nextInt();
			if((m|a|b)==0)break;
			boolean con = true;
			for(int x=m;x>0;x--){
				if(!con)break;
				for(int ip=0;ip<n;ip++){
					int p = sieve.get(ip);
					if(p*p>x)break;
					int q = x/p;
					if(x%p!=0||p*b<q*a)continue;
					if(f[q]){
						con = false;
						System.out.println(p+" "+q);
						break;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new AOJ1232().run();
	}
}
