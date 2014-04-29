package volume02;

import java.util.Arrays;
import java.util.Scanner;

//All Numbers Lead to 6174
public class AOJ0259 {

	int next(int n){
		String r = n+"";
		while(r.length()<4)r+="0";
		char[] s = r.toCharArray(), l = new char[4];
		Arrays.sort(s);
		for(int i=0;i<4;i++)l[i]=s[3-i];
		return Integer.parseInt(new String(l))-Integer.parseInt(new String(s));
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			int n = sc.nextInt();
			if(n==0)break;
			if(n%1111==0){
				System.out.println("NA"); continue;
			}
			int res = 0;
			while(n!=6174){
				n = next(n); res++;
			}
			System.out.println(res);
		}
	}
	
	void debug(Object...o){
		System.out.println(Arrays.deepToString(o));
	}
	
	public static void main(String[] args) {
		new AOJ0259().run();
	}
}
