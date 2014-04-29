package volume01;

import java.util.Scanner;

//Baseball Simulation
public class AOJ0103 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t--!=0){
			int run = 0;
			int p = 0;
			int out = 0;
			while(out < 3){
				String c = sc.next();
				if(c.equals("HIT")){
					if(run<3)run++;
					else p++;
				}
				else if(c.equals("HOMERUN")){
					p += run+1;
					run = 0;
				}
				else{
					out++;
				}
			}
			System.out.println(p);
		}
	}
}
