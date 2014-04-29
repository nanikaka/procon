package volume10;

import java.util.Scanner;

//The Great Summer Contest
public class AOJ1077 {

	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt(), d = sc.nextInt(), e = sc.nextInt(), f = sc.nextInt();
			if((a|b|c|d|e|f)==0)break;
			int A = a+d, B = b+e, C = c+f, res = 0;
			for(int i=0;i<3;i++)if(A>=i&&B>=i&&C>=i)res=Math.max(res, i+(A-i)/3+(B-i)/3+(C-i)/3);
			System.out.println(res);
		}
	}
	
	public static void main(String[] args) {
		new AOJ1077().run();
	}
}
