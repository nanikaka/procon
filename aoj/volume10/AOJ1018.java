package volume10;

import java.util.Arrays;
import java.util.Scanner;

//Cheating on ICPC
public class AOJ1018 {

	void run(){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			int[] a = new int[n];
			for(int i=0;i<n;i++)a[i]=sc.nextInt();
			Arrays.sort(a);
			int p = 0;
			int s = 0;
			for(int i=0;i<n;i++){
				s+=a[i];
				p+=s;
			}
			System.out.println(p);
		}
	}
	
	public static void main(String[] args) {
		new AOJ1018().run();
	}
}
