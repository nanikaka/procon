package volume0;

import java.util.Scanner;

//Sequence
public class AOJ0055 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			double a = sc.nextDouble();
			int k = 1;
			double s = a;
			while(++k<=10){
				if(k%2==0)a*=2;
				else a/=3;
				s+=a;
			}
			System.out.println(s);
		}
	}
}
