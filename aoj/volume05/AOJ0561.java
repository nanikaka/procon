package volume05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//Books
public class AOJ0561 {

	List<Integer>[] b;
	int[][] sell, dp;
	int n, k, NOT = -2;
	
	int get(int g, int rest){
		if(rest<0)return -1;
		if(g==11)return rest==0?0:-1;
		if(dp[g][rest]!=NOT)return dp[g][rest];
		int res = -1;
		for(int v=0;v<=Math.min(rest, b[g].size());v++){
			int x = get(g+1, rest-v);
			if(x==-1)continue;
			res = Math.max(res, x+sell[g][v]);
		}
		return dp[g][rest] = res;
	}
	
	@SuppressWarnings("unchecked")
	void run(){
		b = new List[11];
		for(int i=1;i<11;i++)b[i]=new ArrayList<Integer>();
		sell = new int[11][2001];
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); k = sc.nextInt();
		while(n--!=0){
			int c = sc.nextInt(), g = sc.nextInt();
			b[g].add(c);
		}
		for(int i=1;i<11;i++){
			Collections.sort(b[i]);
			int s = 0;
			for(int j=1;j<=b[i].size();j++){
				s += b[i].get(b[i].size()-j);
				sell[i][j] = s + (j-1)*j;
			}
		}
		dp = new int[11][k+1];
		for(int[]a:dp)Arrays.fill(a, NOT);
		System.out.println(get(1, k));
	}
	
	public static void main(String[] args) {
		new AOJ0561().run();
	}
}
