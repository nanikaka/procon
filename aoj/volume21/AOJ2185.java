package volume21;

import java.util.Scanner;

//Petting Cats
public class AOJ2185 {

	void run(){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T--!=0){
			int x1 = sc.nextInt(), y1 = sc.nextInt(), x2 = x1+sc.nextInt(), y2 = y1+sc.nextInt(), n = sc.nextInt(), res = 0;
			while(n--!=0){
				int x = sc.nextInt(),  y = sc.nextInt();
				if(x1<=x&&x<=x2&&y1<=y&&y<=y2)res++;
			}
			System.out.println(res);
		}
	}
	
	public static void main(String[] args) {
		new AOJ2185().run();
	}
}
