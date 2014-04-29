package volume05;

import java.util.Scanner;

//Receipt
public class AOJ0543 {

	void run(){
		Scanner sc = new Scanner(System.in);
		while(true){
			int t = sc.nextInt();
			if(t==0)break;
			int s = 0;
			for(int i=0;i<9;i++)s+=sc.nextInt();
			System.out.println(t-s);
		}
	}
	
	public static void main(String[] args) {
		new AOJ0543().run();
	}
}
