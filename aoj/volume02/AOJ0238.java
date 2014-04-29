package volume02;

import java.util.Scanner;

//Time to Study
public class AOJ0238 {

	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			int t = sc.nextInt();
			if(t==0)break;
			int n = sc.nextInt(), sum = 0;
			for(int i=0;i<n;i++){
				int s = sc.nextInt(), f = sc.nextInt();
				sum+=f-s;
			}
			System.out.println(t<=sum?"OK":t-sum);
		}
	}
	
	public static void main(String[] args) {
		new AOJ0238().run();
	}
}
