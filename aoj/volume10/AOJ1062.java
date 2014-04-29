package volume10;

import java.util.Scanner;

//It's our delight!!
public class AOJ1062 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			int lN = 0;
			int dN = 0;
			int mN = 0;
			int lok = 0;
			int dok = 0;
			int mok = 0;
			while(n--!=0){
				String[] s = sc.next().split(":");
				int h = Integer.parseInt(s[0]);
				int m = Integer.parseInt(s[1]);
				int k = sc.nextInt();
				int d = 0;
				if(m<=k)d=k-m;
				else d=60-m+k;
				if(11<=h&&h<=14){
					lN++;
					if(d<=8)lok++;
				}
				else if(18<=h&&h<=20){
					dN++;
					if(d<=8)dok++;
				}
				else if(h<=1||21<=h){
					mN++;
					if(d<=8)mok++;
				}
			}
			System.out.println("lunch " + (lN==0?"no guest":lok*100/lN));
			System.out.println("dinner " + (dN==0?"no guest":dok*100/dN));
			System.out.println("midnight " + (mN==0?"no guest":mok*100/mN));
		}
	}
}
