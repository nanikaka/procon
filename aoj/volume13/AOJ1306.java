package volume13;

import java.util.Arrays;
import java.util.Scanner;

//Balloon Collecting
public class AOJ1306 {

	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			int n = sc.nextInt();
			if(n==0)break;
			int[] b = new int[4];
			Arrays.fill(b, 1<<29);
			int p = sc.nextInt(), t = sc.nextInt();
			if(p<=t)b[1] = p;
			int k = p<=t?0:1;
			for(int j=1;j<n;j++){
				int pos = sc.nextInt(), time = sc.nextInt();
				if(k!=0)continue;
				int d = Math.abs(p-pos), dt = Math.abs(time-t);
				int[] nb = new int[4];
				Arrays.fill(nb, 1<<29);
				for(int i=1;i<4;i++){
					if(b[i]==1<<29)continue;
					//put balloon and get
					if(p*(i+1)+pos<=dt){
						nb[1] = Math.min(nb[1], b[i]+p+pos);
					}
					if(i==3)continue;
					if(d*(i+1)<=dt){
						nb[i+1] = Math.min(nb[i+1], b[i]+d);
					}
				}
				b = nb; p = pos; t = time;
				if(b[1]==1<<29&&b[2]==1<<29&&b[3]==1<<29)k = j+1;
			}
			if(k!=0){
				System.out.println("NG "+k); continue;
			}
			int res = 1<<29;
			for(int i=1;i<4;i++)if(b[i]!=-1)res = Math.min(res, b[i]+p);
			System.out.println("OK "+res);
		}
	}
	
	public static void main(String[] args) {
		new AOJ1306().run();
	}
}
