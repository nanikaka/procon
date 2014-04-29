package volume02;

import java.util.Scanner;

//Next Trip
public class AOJ0206 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			int s = 0;
			int ans = 0;
			for(int i=1;i<=12;i++){
				s += sc.nextInt()-sc.nextInt();
				if(ans==0&&s>=n)ans=i;
			}
			System.out.println(ans==0?"NA":ans);
		}
	}
}
