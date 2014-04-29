package volume21;

import java.util.Scanner;

//Saizo
public class AOJ2100 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t--!=0){
			int n = sc.nextInt();
			int h = sc.nextInt();
			int down = 0;
			int up = 0;
			for(int i=1;i<n;i++){
				int x = sc.nextInt();
				if(h>x){
					down = Math.max(down, h-x);
				}
				else{
					up = Math.max(up, x-h);
				}
				h = x;
			}
			System.out.println(up+" "+down);
		}
	}
}
