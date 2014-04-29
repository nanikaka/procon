package volume02;

import java.util.Scanner;

//Hit and Blow
public class AOJ0226 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			char[] r = sc.next().toCharArray();
			char[] a = sc.next().toCharArray();
			if(r.length==1)break;
			int h = 0;
			int b = 0;
			int[] c1 = new int[10];
			int[] c2 = new int[10];
			for(int i=0;i<4;i++){
				if(r[i]==a[i]){
					h++;
					continue;
				}
				c1[r[i]-'0']++;
				c2[a[i]-'0']++;
			}
			for(int i=0;i<10;i++)b+=Math.min(c1[i], c2[i]);
			System.out.println(h+" "+b);
		}
	}
}
