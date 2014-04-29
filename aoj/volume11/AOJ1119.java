package volume11;

import java.util.Scanner;

//Exploring Caves
public class AOJ1119 {

	void run(){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t--!=0){
			int max = 0;
			int tx = 0, ty = 0;
			int x = 0, y = 0;
			for(;;){
				int dx = sc.nextInt();
				int dy = sc.nextInt();
				if(dx==0&&dy==0)break;
				x+=dx; y+=dy;
				int d = x*x+y*y;
				if(max<d){
					max = d;
					tx = x; ty = y;
				}
				else if(max==d&&tx<x){
					tx = x; ty = y;
				}
			}
			System.out.println(tx+" "+ty);
		}
	}
	
	public static void main(String[] args) {
		new AOJ1119().run();
	}
}
