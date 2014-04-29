package volume02;

import java.util.Scanner;

//Quaternion Multiplication
public class AOJ0241 {

	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			int n = sc.nextInt();
			if(n==0)break;
			for(int i=0;i<n;i++){
				int x1 = sc.nextInt(), y1 = sc.nextInt(), z1 = sc.nextInt(), w1 = sc.nextInt();
				int x2 = sc.nextInt(), y2 = sc.nextInt(), z2 = sc.nextInt(), w2 = sc.nextInt();
				int x = x1*x2 - y1*y2 - z1*z2 - w1*w2;
				int y = x1*y2 + y1*x2 + z1*w2 - w1*z2;
				int z = x1*z2 - y1*w2 + z1*x2 + w1*y2;
				int w = x1*w2 + y1*z2 - z1*y2 + w1*x2;
				System.out.println(x+" "+y+" "+z+" "+w);
			}
		}
	}
	
	public static void main(String[] args) {
		new AOJ0241().run();
	}
}
