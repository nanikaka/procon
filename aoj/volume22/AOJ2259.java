package volume22;

import java.util.Scanner;

//Programming Contest
public class AOJ2259 {

	void run(){
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int r = 0;
		for(int i=0;i<m;i++){
			int c = 0;
			for(int j=0;j<n;j++)c+=sc.nextInt()==1?1:0;
			r = Math.max(r, c);
		}
		System.out.println(r);
	}
	
	public static void main(String[] args) {
		new AOJ2259().run();
	}
}
