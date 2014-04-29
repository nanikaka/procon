package volume02;

import java.util.Scanner;

//Triangle of Blocks
public class AOJ0267 {

	void run(){
		Scanner sc = new Scanner(System.in);
		boolean[] tri = new boolean[1000001];
		for(int i=1;i*(i+1)>>1<=1000000;i++){
			tri[i*(i+1)>>1] = true;
		}
		int[] a = new int[1000001];
		for(;;){
			int n = sc.nextInt();
			if(n==0)break;
			int sum = 0;
			for(int i=1;i<=n;i++){
				a[i] = sc.nextInt();
				sum+=a[i];
			}
			if(tri[sum]){
				int res = 0;
				int R = n;
				boolean f = false;
				while(res <= 10000){
					f = true;
					for(int i=1;i<=R&&f;i++)f&=i==a[i];
					if(f)break;
					int L = 1;
					for(int i=1;i<=R;i++){
						if(a[i]==1)continue;
						a[L++] = a[i]-1;
					}
					a[L] = R;
					R = L;
					res++;
				}
				if(f){
					System.out.println(res); continue;
				}
			}
			System.out.println(-1);
		}
	}
	
	public static void main(String[] args) {
		new AOJ0267().run();
	}
}
