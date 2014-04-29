package volume24;

import java.util.Scanner;

//Problem B War II
public class AOJ2418 {

	void run(){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), T = sc.nextInt(), H = sc.nextInt(), L = sc.nextInt();
		int[] t = new int[N], h = new int[N];
		for(int i=0;i<N;i++){
			t[i] = sc.nextInt(); h[i] = sc.nextInt();
		}
		int id = 0, res = -1, Z = 0;
		for(;;){
			if(t[id]==0 && h[id]==0){
				res = id; break;
			}
			if(0 < t[id]){
				Z+=10; t[id]--; T++;
			}
			else{
				Z+=100; h[id]--; H++;
			}
			if(L<T){
				res = id; break;
			}
			if(90 <= Z){
				int r = Z-90;
				Z = 0;
				int U = -1;
				for(int u=0;u<=H;u++){
					if(r<100*u){
						break;
					}
					if((r-100*u)/10 <= T){
						U = u;
						break;
					}
				}
				if(U==-1){
					res = id; break;
				}
				h[id] += U;
				t[id] += (r-U*100)/10;
				H-=U;
				T-=(r-U*100)/10;
			}
			id = (id+1)%N;
		}
		System.out.println(res+1);
	}
	
	public static void main(String[] args) {
		new AOJ2418().run();
	}
}
