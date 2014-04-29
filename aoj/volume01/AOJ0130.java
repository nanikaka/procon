package volume01;

import java.util.Scanner;

//Train
public class AOJ0130 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		while(N--!=0){
			char[] a = new char[3000];
			int p = 1500;
			int s = 1500;
			int t = 1500;
			char[] m = sc.next().toCharArray();
			a[p] = m[0];
			for(int i=1;i<m.length;i++){
				if(m[i]=='-')p++;
				else p--;
				i += 2;
				s = Math.min(s, p);
				t = Math.max(t, p);
				a[p] = m[i];
			}
			for(int i=s;i<=t;i++)System.out.print(a[i]);
			System.out.println();
		}
	}
}
