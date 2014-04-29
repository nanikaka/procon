package volume12;

import java.util.Scanner;

//Grey Area
public class AOJ1285 {

	void run(){
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			int w = sc.nextInt();
			if((n|w)==0)break;;
			int[] h = new int[12];
			int r = -1;
			int max = 0;
			for(int i=0;i<n;i++){
				int v = sc.nextInt();
				int k = 11;
				while(w*k>v)k--;
				h[k]++;
				r = Math.max(r, k);
				max = Math.max(max, h[k]);
			}
			double a = 0.01;
			for(int i=0;i<=r;i++){
				a += ((r-i)*1.0/r)*h[i]/max;
			}
			System.out.println(a);
		}
	}

	public static void main(String[] args) {
		new AOJ1285().run();
	}
}
