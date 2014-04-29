package volume0;

import java.util.Scanner;

//Circles Intersection
public class AOJ0023 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t--!=0){
			double[][] c = new double[2][3];
			for(int i=0;i<2;i++)for(int j=0;j<3;j++)c[i][j]=sc.nextDouble();
			int ans = 0;
			double d = Math.sqrt((c[0][0]-c[1][0])*(c[0][0]-c[1][0]) + (c[0][1]-c[1][1])*(c[0][1]-c[1][1]));
			if(d > c[0][2]+c[1][2])ans=0;
			else {
				if(d+Math.min(c[0][2], c[1][2]) < Math.max(c[0][2], c[1][2])){
					ans = c[0][2]<c[1][2]?-2:2;
				}
				else ans = 1;
			}
			System.out.println(ans);
		}
	}
}
