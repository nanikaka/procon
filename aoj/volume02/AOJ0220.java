package volume02;

import java.util.Scanner;

//Binary Digit A Doctor Loved
public class AOJ0220 {

	static String f(int x){
		StringBuilder sb = new StringBuilder();
		while(x>0){
			sb.append(x%2);
			x/=2;
		}
		return sb.reverse().toString();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			double x = sc.nextDouble();
			if(x<0)break;
			String d = f((int)x);
			x*=16;
			String s = (x+"").split("\\.")[1];
			if(!s.equals("0"))System.out.println("NA");
			else{
				for(int i=0;i<8-d.length();i++)System.out.print("0");
				System.out.print(d+".");
				String z = f((int)x);
				System.out.println(z.substring(z.length()-4, z.length()));
			}
		}
	}
}
