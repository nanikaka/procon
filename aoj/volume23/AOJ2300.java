package volume23;

import java.util.Scanner;

//Calender Colors
public class AOJ2300 {

	void run(){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		double[][] a = new double[n][3];
		for(int i=0;i<n;i++)for(int j=0;j<3;j++)a[i][j]=sc.nextDouble();
		double max = 0;
		for(int i=0;i<1<<n;i++){
			int c = 0;
			for(int j=0;j<n;j++)if((i>>j&1)>0)c++;
			if(c!=m)continue;
			double s = 0;
			for(int j=0;j<n;j++){
				if((i>>j&1)==0)continue;
				for(int k=j+1;k<n;k++){
					if((i>>k&1)==0)continue;
					double x = 0;
					for(int l=0;l<3;l++)x+=Math.pow(a[j][l]-a[k][l], 2);
					s+=x;
				}
			}
			max = Math.max(max, s);
		}
		System.out.printf("%.6f\n", max);
	}
	
	public static void main(String[] args) {
		new AOJ2300().run();
	}
}
