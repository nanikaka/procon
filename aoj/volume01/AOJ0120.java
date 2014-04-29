package volume01;

import java.util.Scanner;

//Patisserie
public class AOJ0120 {

	static double[][][] dp;
	static int[] r;
	static int n;
	static double[][] cach;
	
	static double get(int left, int s, int right){
		if(dp[left][s][right]!=0)return dp[left][s][right];
		int c = 0;
		for(int i=0;i<n;i++)if((s&(1<<i))>0)c++;
		if(c==1){
			return dp[left][s][right] = 2*r[left];
		}
		if(c==2){
			if(r[left]==r[right])return dp[left][s][right] = 4*r[left];
			else return dp[left][s][right] = r[left]+r[right]+cach[left][right];
		}
		double min = Integer.MAX_VALUE;
		for(int i=0;i<n;i++){
			if((s&(1<<i))==0 || i==left || i==right)continue;
			for(int j=0;j<n;j++){
				if((s&(1<<j))==0 || j==right || j==left)continue;
				if(c>3 && i==j)continue;
				double x = r[left]+r[right]-r[i]-r[j]+get(i, s-(1<<left)-(1<<right),j) + cach[left][i] + cach[right][j];
				min = Math.min(min, x);
			}
		}
		return dp[left][s][right] = min;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String[] s = sc.nextLine().split(" ");
			n = s.length-1;
			int len = Integer.parseInt(s[0]);
			r = new int[n];
			for(int i=0;i<n;i++)r[i]=Integer.parseInt(s[i+1]);
			cach = new double[n][n];
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					if(i==j)cach[i][j]=2*r[i];
					else{
						if(r[i]==r[j])cach[i][j]=2*r[i];
						else cach[i][j] = Math.sqrt(Math.pow(r[i]+r[j], 2)-Math.pow(r[i]-r[j], 2));
					}
				}
			}
			dp = new double[n][1<<n][n];
			double min = Integer.MAX_VALUE;
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					if(n>1 && i==j)continue;
					min = Math.min(min, get(i, (1<<n)-1, j));
					if(min<=len)break;
				}
				if(min<=len)break;
			}
			System.out.println(min<=len?"OK":"NA");
		}
	}
}
