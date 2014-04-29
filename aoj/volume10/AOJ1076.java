package volume10;

import java.util.Scanner;

//Time Manipulation
public class AOJ1076 {

	long gcd(long a, long b){
		if(a < b){
			long tmp = a;
			a = b;
			b = tmp;
		}
		while(b!=0){
			long r = a%b;
			a = b;
			b = r;
		}
		return a;
	}
	
	long sum(long a, long k){
		return (k*(a+a*k))/2;
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		while(true){
			long n = sc.nextLong();
			int m = sc.nextInt();
			if((n|m)==0)break;
			long[] a = new long[m];
			long[] subsum = new long[m];
			for(int i=0;i<m;i++){
				a[i] = sc.nextLong();
				subsum[i] = sum(a[i], n/a[i]);
			}
			long sum = n*(n+1)/2;
			long res = 0;
			for(int i=1;i<(1<<m);i++){
				int num = 0;
				for(int j=0;j<m;j++)if(((i>>j)&1)>0)num++;
				long LCM = 1;
				for(int j=0;j<m;j++){
					if(((i>>j)&1)>0){
						LCM = LCM/gcd(LCM, a[j])*a[j];
						if(LCM>n)break;
					}
				}
				if(num%2==0)sum += sum(LCM, n/LCM);
				else sum -= sum(LCM, n/LCM);
				if(num%2==0)res -= n/LCM;
				else res += n/LCM;
			}
			long N = n-res;
			System.out.printf("%.6f\n", N==0?0.0:(1.0*sum/N));
		}
	}
	
	public static void main(String[] args) {
		new AOJ1076().run();
	}
}
