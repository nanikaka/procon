package volume0;

import java.util.Scanner;

//Is it a Right Triangle?
public class AOJ0003 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while(n--!=0){
			int a[] = new int[3];
			for(int i=0;i<3;i++){
				a[i]=(int)Math.pow(sc.nextInt(), 2);
			}
			System.out.println((a[0]+a[1]==a[2]||a[0]+a[2]==a[1]||a[2]+a[1]==a[0])?"YES":"NO");
		}
	}
}
