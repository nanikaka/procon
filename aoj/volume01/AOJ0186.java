package volume01;

import java.util.Scanner;

//Aizu Chicken
public class AOJ0186 {

	static int q1, b, c1, c2, q2;

	static boolean f(int a){
		return !(b<c1*a || a+(b-c1*a)/c2<q1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			q1 = sc.nextInt();
			if(q1==0)break;
			b = sc.nextInt();
			c1 = sc.nextInt();
			c2 = sc.nextInt();
			q2 = sc.nextInt();
			int l = 0;
			int r = q2;
			while(r-l>1){
				int mid = (l+r)/2;
				if(f(mid))l = mid;
				else r = mid;
			}
			if(r>0&&f(r))System.out.println(r+" "+(b-c1*r)/c2);
			else if(l>0&&f(l))System.out.println(l+" "+(b-c1*l)/c2);
			else System.out.println("NA");
		}
	}
}
