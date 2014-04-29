package volume0;

import java.util.Scanner;

//What is the Bottommost?
public class AOJ0062 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int[] a = new int[10];
			char[] s = sc.next().toCharArray();
			for(int i=0;i<10;i++)a[i]=s[i]-'0';
			for(int j=9;j>0;j--){
				int[] b = new int[j];
				for(int i=0;i<j;i++){
					b[i]=(a[i]+a[i+1])%10;
				}
				a = b;
			}
			System.out.println(a[0]);
		}
	}
}
