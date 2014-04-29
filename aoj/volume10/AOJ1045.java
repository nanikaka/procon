package volume10;

import java.util.Scanner;

//Split Up!
public class AOJ1045 {

	void run(){
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			int s = 0;
			int[] a = new int[n];
			for(int i=0;i<n;i++){
				a[i] = sc.nextInt();
				s+=a[i];
			}
			int m = s;
			for(int i=0;i<(1<<n);i++){
				int r = 0;
				for(int j=0;j<n;j++){
					if((i&(1<<j))==0)continue;
					r += a[j];
				}
				m = Math.min(m, Math.abs(s-r*2));
			}
			System.out.println(m);
		}
	}

	public static void main(String[] args) {
		new AOJ1045().run();
	}
}
