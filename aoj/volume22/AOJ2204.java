package volume22;

import java.util.Scanner;

//Final Examination!
public class AOJ2204 {

	void run(){
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			int max = 0;
			int min = 500;
			while(n--!=0){
				int s = 0;
				for(int i=0;i<5;i++)s+=sc.nextInt();
				max = Math.max(max, s);
				min = Math.min(min, s);
			}
			System.out.println(max+" "+min);
		}
	}
	
	public static void main(String[] args) {
		new AOJ2204().run();
	}
}
