package volume21;

import java.util.Scanner;

//Champernowne Constant
public class AOJ2177_2 {

	long DIGIT_LIMIT = 1000000000000000000L;
	long MAX_NUMBER = 59477124183006535L;
	long[] endK;
	long[] ten;
	
	void init(){
		endK = new long[20];
		endK[0] = 0;
		long num = 9;
		for(int k=1;k<=17;k++,num*=10){
			endK[k] = endK[k-1]+k*num;
		}
		endK[18] = DIGIT_LIMIT;
		endK[0] = -1;
		ten = new long[20];
		ten[0] = 0;
		ten[1] = 10;
		for(int k=2;k<=17;k++)ten[k]=ten[k-1]*10;
	}
	
	int at(long x){
		long L=0, R=0;
		int k;
		for(k=17;k>=0;k--)if(endK[k] < x){
			L = ten[k];
			R = k==17?MAX_NUMBER:ten[k+1];
			break;
		}
		for(;;){
			long m = (R+L)/2;
			long p = endK[k]+1+(k+1)*(m-ten[k]);
			if(p<=x&&x<p+k+1){
				String s = m+"";
				for(int i=0;i<s.length();i++)if(p+i==x)return s.charAt(i)-'0';
			}
			else if(x < p)R=m;
			else L=m;
		}
	}
	
	void run(){
		init();
		Scanner sc = new Scanner(System.in);
		for(;;){
			int N = sc.nextInt(), K = sc.nextInt();
			if((N|K)==0)break;
			for(int i=0;i<K;i++)System.out.print(at(N+i));
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		new AOJ2177_2().run();
	}
}
