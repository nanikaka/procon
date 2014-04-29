package volume02;

import java.util.Scanner;

//Kongo Type
public class AOJ0268 {

	void run(){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while(n--!=0){
			long X = Long.parseLong(sc.next(), 16);
			long a = (X&0x7fffff80)>>7;
			double b = 0, dt = 0.5;
			long f = X&0x7f;
			long pos = 1L<<6;
			while(0 < pos){
				if((f&pos)>0){
					b+=dt;
				}
				pos >>= 1;
				dt/=2;
			}
			String t = (b+"").substring(2);
			System.out.printf("%s%d.%s\n", ((X&0x80000000)>0)?"-":"", a, t);
		}
	}
	
	public static void main(String[] args) {
		new AOJ0268().run();
	}
}
