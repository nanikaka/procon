package volume0;

import java.util.Scanner;

//Cup Game
public class AOJ0047 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[] c = new boolean[3];
		c[0] = true;
		while(sc.hasNext()){
			char[] a = sc.next().toCharArray();
			int s = a[0]-'A';
			int t = a[2]-'A';
			boolean b = c[s];
			c[s] = c[t];
			c[t] = b;
		}
		for(int i=0;i<3;i++)if(c[i]){System.out.println((char)(i+'A'));break;}
	}
}
