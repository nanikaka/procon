package volume12;

import java.util.Scanner;

//The Balance
public class AOJ1248 {

	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			int a = sc.nextInt(), b = sc.nextInt(), d = sc.nextInt();
			if((a|b|d)==0)break;
			int ax = -1, ay = -1;
			int x = 0, t = d;
			while(t%b!=0){
				t+=a; x++;
			}
			int y = t/b;
			ax = x; ay = y;
			y = 0; t = d;
			while(t%a!=0){
				t+=b; y++;
			}
			x = t/a;
			if(x+y<ax+ay||x+y==ax+ay&&a*x+b*y<a*ax+b*ay){
				ax = x; ay = y;
			}
			t = 0; x = 0;
			for(;t<=d;){
				if((d-t)%b==0){
					y = (d-t)/b;
					if(x+y<ax+ay||x+y==ax+ay&&a*x+b*y<a*ax+b*ay){
						ax = x; ay = y;
					}
				}
				x++; t+=a;
			}
			System.out.println(ax+" "+ay);
		}
	}
	
	public static void main(String[] args) {
		new AOJ1248().run();
	}
}
