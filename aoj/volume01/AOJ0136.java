package volume01;

import java.util.Scanner;

//Frequency Distribution of Height
public class AOJ0136 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] s = new int[6];
		int n = sc.nextInt();
		while(n--!=0){
			double x = sc.nextDouble();
			for(int i=0;i<6;i++)if(x<165+5*i||i==5){s[i]++;break;}
		}
		for(int i=0;i<6;i++){
			System.out.print((i+1)+":");
			while(s[i]--!=0)System.out.print('*');
			System.out.println();
		}
	}
}
