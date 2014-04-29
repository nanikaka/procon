package volume20;

import java.util.Scanner;

//Space Coconut Grab
public class AOJ2012 {

	void run(){
		Scanner sc = new Scanner(System.in);
		boolean[] Z = new boolean[1000001];
		int[] z = new int[1000001];
		for(int i=0;i<=100;i++){
			Z[i*i*i] = true;
			z[i*i*i] = i;
		}
		for(;;){
			int e = sc.nextInt();
			if(e==0)break;
			int res = 1<<29;
			for(int x=0;x<=1000000;x++){
				if(res<=x)break;
				for(int y=0;y<=1000000;y++){
					if(res<=x+y||e<x+y*y)break;
					if(!Z[e-x-y*y])continue;
					res = Math.min(res, x+y+z[e-x-y*y]);
				}
			}
			System.out.println(res);
		}
	}
	
	public static void main(String[] args) {
		new AOJ2012().run();
	}
}
