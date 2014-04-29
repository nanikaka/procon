package volume10;

import java.util.Scanner;

//A Piece of Cake
public class AOJ1027 {

	void run(){
		Scanner sc = new Scanner(System.in);
		while(true){
			int k = sc.nextInt();
			if(k==0)break;
			int s = 0;
			for(int i=0;i<k*(k-1)/2;i++)s+=sc.nextInt();
			System.out.println(s/(k-1));
		}
	}
	
	public static void main(String[] args) {
		new AOJ1027().run();
	}
}
