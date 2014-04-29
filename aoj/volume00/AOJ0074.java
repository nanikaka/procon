package volume0;

import java.util.Scanner;

//Videotape
public class AOJ0074 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int h = sc.nextInt();
			int m = sc.nextInt();
			int s = sc.nextInt();
			if(h==-1)break;
			int x = h*3600+m*60+s;
			int r = 7200 - x;
			int r3 = 7200*3-x*3;
			System.out.printf("%02d:%02d:%02d\n", r/3600, r%3600/60, r%60);
			System.out.printf("%02d:%02d:%02d\n", r3/3600, r3%3600/60, r3%60);
		}
	}
}
