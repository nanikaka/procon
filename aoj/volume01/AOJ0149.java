package volume01;

import java.util.Scanner;

//Eye Test
public class AOJ0149 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] e = new int[4][2];
		while(sc.hasNext()){
			for(int i=0;i<2;i++){
				double x = sc.nextDouble();
				if(x<0.2)e[3][i]++;
				else if(x<0.6)e[2][i]++;
				else if(x<1.1)e[1][i]++;
				else e[0][i]++;
			}
		}
		for(int i=0;i<4;i++)System.out.println(e[i][0]+" "+e[i][1]);
	}
}
