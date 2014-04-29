package volume0;

import java.util.GregorianCalendar;
import java.util.Scanner;

//What day is today?
public class AOJ0027 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] s = {"","Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
		while(true){
			int m = sc.nextInt();
			int d = sc.nextInt();
			if(m==0)break;
			GregorianCalendar g = new GregorianCalendar(2004, m-1, d);
			System.out.println(s[g.get(GregorianCalendar.DAY_OF_WEEK)]);
		}
	}
}
