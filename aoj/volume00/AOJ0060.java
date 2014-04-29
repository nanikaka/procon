package volume0;

import java.util.Scanner;

//Card Game
public class AOJ0060 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			boolean[] u = new boolean[11];
			int c1 = sc.nextInt();
			int c2 = sc.nextInt();
			int c3 = sc.nextInt();
			u[c1]=u[c2]=u[c3]=true;
			int x = c1+c2;
			int c = 0;
			for(int i=1;i<=10;i++){
				if(!u[i]&&x+i<=20)c++;
			}
			System.out.println(c*100/7>=50?"YES":"NO");
		}
	}
}
