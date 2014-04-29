package volume22;

import java.util.Scanner;

//Starting Line
public class AOJ2298 {

	void run(){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), K = sc.nextInt(), T = sc.nextInt(), U = sc.nextInt(), V = sc.nextInt(), L = sc.nextInt();
		int[] D = new int[n+1];
		for(int i=0;i<n;i++)D[i]=sc.nextInt();
		D[n] = L;
		double res = 0;
		int pos = 0, k = 0, f = 0;
		while(pos<L){
			if(pos<D[f]){
				if(0<k){
					k--;
					int nx = Math.min(L, pos+T*V);
					res+=(nx-pos+0.)/V;
					pos = nx;
				}
				else{
					res+=(D[f]-pos+0.)/U;
					pos = D[f];
				}
			}
			else{
				if(k==0){
					if(D[f]==pos){
						int nx = Math.min(L, pos+T*V);
						res+=(nx-pos+0.)/V;
						pos = nx;
						f++;
					}
					else{
						k++; f++;
					}
				}
				else if(k==K){
					int nx = Math.min(L, D[f++]+T*V);
					res+=(nx-pos+0.)/V;
					pos = nx;
				}
				else {
					f++;
					k++;
				}
			}
		}
		System.out.printf("%.8f\n", res);
	}
	
	public static void main(String[] args) {
		new AOJ2298().run();
	}
}
