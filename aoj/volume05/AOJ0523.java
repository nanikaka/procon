package volume05;

import java.util.Arrays;
import java.util.Scanner;

//Card Game
public class AOJ0523 {

	void run(){
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			boolean[] t = new boolean[2*n+1];
			boolean[] h = new boolean[2*n+1];
			int ct = n;
			int ht = n;
			Arrays.fill(h, true);
			for(int i=0;i<n;i++){
				int c = sc.nextInt();
				t[c] = true;
				h[c] = false;
			}
			int p = 0;
			int turn = 0;
			while(0<ct&&0<ht){
				boolean f = false;
				for(int i=1;i<=2*n;i++){
					if(turn==0){
						if(t[i]&&p<i){
							t[i] = false;
							ct--;
							p = i;
							f = true;
							break;
						}
					}
					else{
						if(h[i]&&p<i){
							h[i] = false;
							ht--;
							p = i;
							f = true;
							break;
						}
					}
				}
				if(!f)p = 0;
				turn = (turn+1)%2;
			}
			int pt = 0;
			int ph = 0;
			for(int i=1;i<=2*n;i++){
				pt+=h[i]?1:0;
				ph+=t[i]?1:0;
			}
			System.out.println(pt+"\n"+ph);
		}
	}

	public static void main(String[] args) {
		new AOJ0523().run();
	}
}
