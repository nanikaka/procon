package volume21;

import java.util.Scanner;

//Strange String Manipulation
public class AOJ2165 {

	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			int n = sc.nextInt();
			if(n==0)break;
			double min = 1<<29;
			int S = 0, A = 0, C = 0;
			int[] I = new int[n];
			for(int i=0;i<n;i++)I[i]=sc.nextInt();
			for(int s=0;s<16;s++)for(int a=0;a<16;a++)for(int c=0;c<16;c++){
				int R = s;
				int[] O = new int[256];
				for(int i=0;i<n;i++){
					R = (a*R+c)%256;
					O[(I[i]+R)%256]++;
				}
				double H = 0;
				for(int i=0;i<256;i++)if(O[i]>0)H-=O[i]*1.0/n*Math.log(O[i]*1.0/n);
				if(H+1e-10<min){
					min = H; S = s; A = a; C = c;
				}
			}
			System.out.println(S+" "+A+" "+C);
		}
	}

	public static void main(String[] args) {
		new AOJ2165().run();
	}
}
