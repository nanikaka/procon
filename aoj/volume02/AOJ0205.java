package volume02;

import java.util.Scanner;

//Rock, Paper, Scissors
public class AOJ0205 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int k = sc.nextInt();
			if(k==0)break;
			int[] h = new int[5];
			h[0] = k;
			boolean[] u = new boolean[4];
			u[k] = true;
			for(int i=1;i<5;i++){
				k = sc.nextInt();
				h[i] = k;
				u[k] = true;
			}
			int c = 0;
			for(int i=1;i<=3;i++)if(u[i])c++;
			if(c==1||c==3){
				for(int i=0;i<5;i++)System.out.println(3);
			}
			else if(!u[1]){
				for(int i=0;i<5;i++)System.out.println(h[i]==2?1:2);
			}
			else if(!u[2]){
				for(int i=0;i<5;i++)System.out.println(h[i]==3?1:2);
			}
			else{
				for(int i=0;i<5;i++)System.out.println(h[i]==1?1:2);
			}
		}
	}
}
