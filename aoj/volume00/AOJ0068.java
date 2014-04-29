package volume0;

import java.util.Scanner;

//Enclose Pins with a Rubber Band
public class AOJ0068 {

	static double ex(double x1, double y1, double x2, double y2, double x3, double y3){
		double dx1 = x2-x1;
		double dy1 = y2-y1;
		double dx2 = x3-x1;
		double dy2 = y3-y1;
		return dx1*dy2-dx2*dy1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			double[][] p = new double[n][2];
			for(int i=0;i<n;i++){
				String[] s = sc.next().split(",");
				p[i][0] = Double.parseDouble(s[0]);
				p[i][1] = Double.parseDouble(s[1]);
			}
			boolean[] used = new boolean[n];
			int left = 0;
			for(int i=1;i<n;i++)if(p[i][0]<p[left][0])left=i;
			used[left]=true;
			int end = left;
			int pre = left;
			while(true){
				int k;
				for(k=0;k<n;k++){
					if(pre==k)continue;
					boolean f = true;
					for(int j=0;j<n;j++){
						if(j==pre||j==k)continue;
						if(ex(p[pre][0], p[pre][1], p[k][0], p[k][1], p[j][0], p[j][1]) <= 0){
							f = false;
							break;
						}
					}
					if(f){
						used[k] = true;
						pre = k;
						break;
					}
				}
				if(pre==end)break;
			}
			int c = 0;
			for(int i=0;i<n;i++)if(!used[i])c++;
			System.out.println(c);
		}
	}
}
