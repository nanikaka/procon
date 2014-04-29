package volume01;

import java.util.Scanner;

//Delivery Fee
public class AOJ0160 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] s = {60,80,100,120,140,160};
		int[] w = {2,5,10,15,20,25};
		int[] p = {600,800,1000,1200,1400,1600,0};
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			int t = 0;
			for(int i=0;i<n;i++){
				int size = sc.nextInt()+sc.nextInt()+sc.nextInt();
				int we = sc.nextInt();
				int k = 0;
				while(k<6 && !(size<=s[k]&&we<=w[k]))k++;
				t+=p[k];
			}
			System.out.println(t);
		}
	}
}
