package volume11;

import java.util.Scanner;

//Fermat's Last Theorem
public class AOJ1109 {

	void run(){
		long[] p = new long[1111];
		for(int i=0;i<1111;i++)p[i]=(long) Math.pow(i, 3);
		Scanner sc = new Scanner(System.in);
		while(true){
			int z = sc.nextInt();
			if(z==0)break;
			int i=1, j=z;
			long max = 0;
			while(i<=j){
				long val = p[i]+p[j];
				if(val<=p[z]){
					i++;
					max = Math.max(max, val);
				}
				else j--;
			}
			System.out.println(p[z]-max);
		}
	}
	
	public static void main(String[] args) {
		new AOJ1109().run();
	}
}
