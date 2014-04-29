package volume0;

import java.util.Scanner;

//Trading
public class AOJ0065 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] t = new int[1001];
		int[] t2 = new int[1001];
		while(true){
			String s = sc.nextLine();
			if(s.equals(""))break;
			t[Integer.parseInt(s.split(",")[0])]++;
		}
		while(sc.hasNext()){
			int x = Integer.parseInt(sc.nextLine().split(",")[0]);
			t2[x]++;
		}
		for(int i=0;i<=1000;i++)if(t[i]>0&&t2[i]>0)System.out.println(i+" "+(t[i]+t2[i]));
	}
}
