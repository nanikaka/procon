package volume01;

import java.util.Scanner;

//Period
public class AOJ0113 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int p = sc.nextInt();
			int q = sc.nextInt();
			int[] a = new int[q];
			StringBuilder sb = new StringBuilder();
			int k = 1;
			int r = p%q;
			int s = -1;
			int t = -1;
			a[r] = k++;
			r*=10;
			sb.append(r/q);
			r%=q;
			while(true){
				if(r==0)break;
				if(a[r]>0){
					s = a[r];
					t = k;
					break;
				}
				a[r] = k++;
				r *= 10;
				sb.append(r/q);
				r %= q;
			}
			System.out.println(sb);
			if(s!=-1){
				for(int i=0;i<t-1;i++){
					if(s-1<=i)System.out.print("^");
					else System.out.print(" ");
				}
				System.out.println();
			}
		}
	}
}
