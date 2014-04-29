package volume10;

import java.util.Scanner;

//ICPC: Ideal Coin Payment and Change
public class AOJ1028 {
	
	int[] p = {1,5,10,50,100,500};
	int[] c;
	
	int pay(int x){
		int r = 0;
		for(int k=5;k>=0;k--){
			int a = Math.min(x/p[k], c[k]);
			r+=a;
			x-=p[k]*a;
		}
		return r;
	}
	
	int get(int x){
		int r = 0;
		for(int k=5;k>=0;k--){
			int c = x/p[k];
			r+=c;
			x-=p[k]*c;
		}
		return r;
	}
	
	void run(){
		int[] r = new int[666001];
		for(int i=0;i<666001;i++)r[i]=get(i);
		Scanner sc = new Scanner(System.in);
		while(true){
			int P = sc.nextInt();
			if(P==0)break;
			c = new int[6];
			int sum = 0;
			for(int i=0;i<6;i++){
				c[i]=sc.nextInt();
				sum+=p[i]*c[i];
			}
			int min = 1<<28;
			for(int i=P;i<=sum;i++){
				min = Math.min(min, pay(i)+r[i-P]);
			}
			System.out.println(min);
		}
	}
	
	public static void main(String[] args) {
		new AOJ1028().run();
	}
}
