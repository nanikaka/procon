package volume0;

import java.util.Arrays;
import java.util.Scanner;

//Differential 2
public class AOJ0051 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t--!=0){
			char[] a = sc.next().toCharArray();
			Arrays.sort(a);
			int m = Integer.parseInt(new String(a));
			char[] b = new char[8];
			for(int i=0;i<8;i++)b[i]=a[7-i];
			System.out.println(Integer.parseInt(new String(b))-m);
		}
	}
}
