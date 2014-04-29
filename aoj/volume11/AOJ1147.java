package volume11;

import java.util.Scanner;

//ICPC Score Totalizer Software
public class AOJ1147 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			int s = 0;
			int max = 0;
			int min = 1000;
			for(int i=0;i<n;i++){
				int a = sc.nextInt();
				s += a;
				max = Math.max(max, a);
				min = Math.min(min, a);
			}
			System.out.println((s-max-min)/(n-2));
		}
	}
}
