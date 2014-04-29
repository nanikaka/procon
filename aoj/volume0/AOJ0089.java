package volume0;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//The Shortest Path on A Rhombic Path
public class AOJ0089 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> l = new ArrayList<String>();
		while(sc.hasNext())l.add(sc.next());
		int n = l.size();
		int[][] a = new int[n][];
		for(int i=0;i<n;i++){
			String[] s = l.get(i).split(",");
			int k = s.length;
			a[i] = new int[k];
			for(int j=0;j<k;j++)a[i][j]=Integer.parseInt(s[j]);
		}
		int[] dp = {a[0][0]};
		for(int i=1;i<n;i++){
			int[] tmp = new int[a[i].length];
			for(int j=0;j<tmp.length;j++){
				if(i<=n/2){
					if(j==0)tmp[j]=dp[j]+a[i][j];
					else if(j==tmp.length-1)tmp[j]=dp[j-1]+a[i][j];
					else tmp[j]=Math.max(dp[j-1]+a[i][j], dp[j]+a[i][j]);
				}
				else{
					tmp[j] = Math.max(dp[j]+a[i][j], dp[j+1]+a[i][j]);
				}
			}
			dp = tmp;
		}
		System.out.println(dp[0]);
	}
}
