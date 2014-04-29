package volume0;

import java.util.Scanner;

//Physical Experiments
public class AOJ0024 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			double t = sc.nextDouble()/9.8;
			double y = 4.9*t*t;
			int f = 1;
			while(true){
				if(5*f-5 >= y){
					System.out.println(f);
					break;
				}
				f++;
			}
		}
	}
}
