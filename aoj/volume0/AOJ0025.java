package volume0;

import java.util.Scanner;

//Hit and Blow
public class AOJ0025 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int[] a = new int[10];
			for(int i=1;i<=4;i++)a[sc.nextInt()]=i;
			int h = 0;
			int b = 0;
			for(int i=1;i<=4;i++){
				int x = sc.nextInt();
				if(i==a[x])h++;
				else if(a[x]>0)b++;
			}
			System.out.println(h+" "+b);
		}
	}
}
