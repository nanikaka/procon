package volume22;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//Farey Sequence
public class AOJ2286 {

	int N = 1000000;
	boolean[] p;
	
	long gcd(long a, long b){
		return b==0?a:gcd(b, a%b);
	}

	long get(int x){
		int n = x;
		Set<Integer> set = new HashSet<Integer>();
		int div = 2;
		while(x>1){
			if(p[x]){
				set.add(x); break;
			}
			if(x%div==0){
				set.add(div);
				x/=div;
			}
			else div++;
		}
		int m = set.size();
		int[] a = new int[m];
		int id = 0;
		for(int i:set)a[id++]=i;
		long res = 0;
		for(int i=1;i<1<<m;i++){
			int num = 0;
			for(int j=i;j!=0;j>>=1)num+=j&1;
			long lcm = 1;
			for(int j=0;j<m;j++){
				if((i>>j&1)>0){
					lcm = lcm/gcd(lcm, a[j])*a[j];
					if(lcm>n)break;
				}
			}
			if(num%2==0)res-=n/lcm;
			else res+=n/lcm;
		}
		return res;
	}
	
	void run(){
		p = new boolean[N+1];
		Arrays.fill(p, true);
		p[0]=p[1]=false;
		for(int i=2;i<=N;i++)if(p[i])for(int j=i+i;j<=N;j+=i)p[j]=false;
		long[] res = new long[N+1];
		res[1] = 2;
		for(int i=2;i<=N;i++){
			res[i] = res[i-1];
			res[i]+=i-get(i);
		}
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T--!=0)System.out.println(res[sc.nextInt()]);
	}
	
	public static void main(String[] args) {
		new AOJ2286().run();
	}
}
