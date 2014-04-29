package volume21;

import java.util.Scanner;

//Perfect Number
public class AOJ2101 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			if(n==1){
				System.out.println("deficient number");
				continue;
			}
			int s = 1;
			for(int i=2;i*i<=n;i++){
				if(n%i==0){
					if(i*i==n)s+=i;
					else s+=i+n/i;
				}
			}
			System.out.println(n==s?"perfect number":n>s?"deficient number":"abundant number");
		}
	}
}
