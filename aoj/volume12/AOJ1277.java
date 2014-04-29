package volume12;

import java.util.Scanner;

//Minimal Backgammon
public class AOJ1277 {

	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			int n = sc.nextInt(), T = sc.nextInt(), l = sc.nextInt(), b = sc.nextInt();
			if((n|T|l|b)==0)break;
			boolean[] lose = new boolean[n+1];
			for(int i=0;i<l;i++)lose[sc.nextInt()] = true;
			boolean[] back = new boolean[n+1];
			for(int i=0;i<b;i++)back[sc.nextInt()] = true;
			double[][] p = new double[T+1][n+1];
			p[0][0] = 1.0;
			for(int t=0;t<T;t++)for(int i=0;i<=n;i++){
				if(i==n){
					p[t+1][n] += p[t][n]; continue;
				}
				for(int j=1;j<=6;j++){
					double dt = p[t][i]/6.0;
					int next = i+j;
					if(n<next){
						int d = next-n;
						next = n-d;
					}
					if(lose[next]){
						if(t+2<=T)p[t+2][next] += dt;
					}
					else if(back[next]){
						p[t+1][0] += dt;
					}
					else p[t+1][next] += dt;
				}
			}
			System.out.printf("%.6f\n", p[T][n]);
		}
	}
	
	public static void main(String[] args) {
		new AOJ1277().run();
	}
}
