package volume02;

import java.util.Scanner;

//Cutting Down Water Bills
public class AOJ0216 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int w = sc.nextInt();
			if(w==-1)break;
			int s = 1150;
			if(w>10)s+=Math.min((w-10)*125, 1250);
			if(w>20)s+=Math.min((w-20)*140, 1400);
			if(w>30)s+=(w-30)*160;
			System.out.println(4280-s);
		}
	}
}
