package volume20;

import java.util.Scanner;

//Amida, the City of Miracle
public class AOJ2001 {

	void run(){
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			int m = sc.nextInt();
			int a = sc.nextInt();
			if((n|m|a)==0)break;
			int[][] r = new int[1002][n+1];
			while(m--!=0){
				int h = sc.nextInt();
				int p = sc.nextInt();
				int q = sc.nextInt();
				r[h][p] = q;
				r[h][q] = p;
			}
			int pos = a;
			for(int h=1000;h>0;h--){
				if(r[h][pos]!=0)pos = r[h][pos];
			}
			System.out.println(pos);
		}
	}
	
	public static void main(String[] args) {
		new AOJ2001().run();
	}
}
