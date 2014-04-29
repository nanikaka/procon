package volume0;

import java.util.Scanner;

//Blood Groups
public class AOJ0049 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] c = new int[4];
		while(sc.hasNext()){
			String b = sc.next().split(",")[1];
			if(b.equals("A"))c[0]++;
			else if(b.equals("B"))c[1]++;
			else if(b.equals("AB"))c[2]++;
			else c[3]++;
		}
		for(int i=0;i<4;i++)System.out.println(c[i]);
	}
}
