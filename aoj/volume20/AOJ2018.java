package volume20;

import java.util.Scanner;

//Princess's Gamble
public class AOJ2018 {

	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			int n = sc.nextInt(), m = sc.nextInt(), p = sc.nextInt();
			if((n|m|p)==0)break;
			int s = 0, h = 0;
			for(int i=1;i<=n;i++){
				int x = sc.nextInt();
				s+=100*x;
				if(i==m)h=x;
			}
			System.out.println(h==0?0:(int)(s*(100.0-p)/100/h));
		}
	}

	public static void main(String[] args) {
		new AOJ2018().run();
	}
}
