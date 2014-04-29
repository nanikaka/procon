package volume05;

import java.util.Scanner;

//Change
public class AOJ0521 {

	void run(){
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			n = 1000-n;
			int c = 0;
			while(n>=500){
				n-=500;c++;
			}
			while(n>=100){
				n-=100;c++;
			}
			while(n>=50){
				n-=50;c++;
			}
			while(n>=10){
				n-=10;c++;
			}
			while(n>=5){
				n-=5;c++;
			}
			while(n>=1){
				n-=1;c++;
			}
			System.out.println(c);
		}
	}

	public static void main(String[] args) {
		new AOJ0521().run();
	}
}
