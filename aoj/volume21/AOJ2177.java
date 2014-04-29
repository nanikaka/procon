package volume21;

import java.util.Scanner;

//Champernowne Constant
public class AOJ2177 {

	void run(){
		int S = 125000;
		int[] a = new int[S];
		int s = 0;
		for(int i=0;i<S;i++){
			a[i] = s;
			int L = 1000*i, R = L+999;
			if((L+"").length()==(R+"").length())s+=1000*(L+"").length();
			else{
				for(int k=L;k<=R;k++)s+=(k+"").length();
			}
		}
		Scanner sc = new Scanner(System.in);
		for(;;){
			int N = sc.nextInt(), K = sc.nextInt();
			if((N|K)==0)break;
			int id = 0;
			for(int i=0;i+1<S;i++){
				if(a[i]<=N&&N<a[i+1]){
					id = i; break;
				}
			}
			N-=a[id];
			StringBuilder sb = new StringBuilder();
			for(int k=1000*id;sb.length()<=N+K;k++)sb.append(k);
			System.out.println(sb.substring(N, N+K));
		}
	}
	
	public static void main(String[] args) {
		new AOJ2177().run();
	}
}
