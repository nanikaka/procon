package volume20;

import java.util.Arrays;
import java.util.Scanner;

//Space Coconut Crab II
public class AOJ2039 {

	int t, c;
	boolean[] prime;
	int[] p;
	int[] a = new int[3];

	void f(int k, int sum, int x){
		if(t<=sum)return;
		if(k==2){
			if(prime[t-sum]&&p[x]<=t-sum && a[0]+a[1]>t-sum){
				c++;
			}
			return;
		}
		for(int i=x;i<3245;i++){
			a[k] = p[i];
			f(k+1, sum+p[i], i);
		}
	}

	void run(){
		prime = new boolean[30001];
		Arrays.fill(prime, true);
		prime[0] = prime[1] = false;
		for(int i=2;i<30001;i++)if(prime[i])for(int j=i*2;j<30001;j+=i)prime[j]=false;
		p = new int[3245];
		int id = 0;
		for(int i=2;i<30001;i++)if(prime[i])p[id++] = i;
		Scanner sc = new Scanner(System.in);
		while(true){
			t = sc.nextInt();
			if(t==0)break;
			c = 0;
			f(0,0,0);
			System.out.println(c);
		}
	}

	public static void main(String[] args) {
		new AOJ2039().run();
	}
}
