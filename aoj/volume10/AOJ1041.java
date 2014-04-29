package volume10;

import java.util.Scanner;

//Kyudo: A Japanese Art of Archery
public class AOJ1041 {

	void run(){
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			int s = 0;
			for(int i=0;i<n/4;i++)s+=sc.nextInt();
			System.out.println(s);
		}
	}
	
	public static void main(String[] args) {
		new AOJ1041().run();
	}
}
