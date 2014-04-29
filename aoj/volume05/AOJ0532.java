package volume05;

import java.util.Scanner;

//Time Card
public class AOJ0532 {

	void run(){
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<3;i++){
			int h = sc.nextInt();
			int m = sc.nextInt();
			int s = sc.nextInt();
			int e = h*3600+m*60+s;
			h = sc.nextInt();
			m = sc.nextInt();
			s = sc.nextInt();
			int t = h*3600+m*60+s-e;
			System.out.println(t/3600+" "+t%3600/60+" "+t%60);
		}
	}

	public static void main(String[] args) {
		new AOJ0532().run();
	}
}
