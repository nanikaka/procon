package volume11;

import java.util.Scanner;

//Millennium
public class AOJ1179 {

	void run(){
		Scanner sc = new Scanner(System.in);
		int[] d = {0, 20, 19, 20, 19, 20, 19, 20, 19, 20, 19};
		int T = sc.nextInt();
		while(T--!=0){
			int Y = sc.nextInt(), M = sc.nextInt(), D = sc.nextInt();
			int res = 0;
			while(!(Y==1000&&M==1&&D==1)){
				if(Y%3==0&&D==20 || Y%3!=0&&D==d[M]){
					M++; D=1;
				}
				else D++;
				if(M==11){
					Y++; M=1;
				}
				res++;
			}
			System.out.println(res);
		}
	}
	
	public static void main(String[] args) {
		new AOJ1179().run();
	}
}
