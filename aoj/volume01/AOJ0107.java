package volume01;

import java.util.Scanner;

//Carry a Cheeze
public class AOJ0107 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			if(a==0&&b==0&&c==0)break;
			double da = Math.sqrt(a*a+b*b);
			double db = Math.sqrt(b*b+c*c);
			double dc = Math.sqrt(a*a+c*c);
			double min = da;
			if(db < min)min = db;
			if(dc < min)min = dc;
			int t = sc.nextInt();
			while(t--!=0){
				int r = sc.nextInt()*2;
				System.out.println(min<r?"OK":"NA");
			}
		}
	}
}
