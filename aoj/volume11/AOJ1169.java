package volume11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//The Most Powerful Spell
public class AOJ1169 {

	static class E{
		public int s;
		public int t;
		public String spell;
		public E(int s, int t, String spell) {
			super();
			this.s = s;
			this.t = t;
			this.spell = spell;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final int LEN = 6*39*2;
		while(true){
			int n = sc.nextInt();
			int a = sc.nextInt();
			int s = sc.nextInt();
			int g = sc.nextInt();
			if((n|a|s|g)==0)break;
			List<E> edge = new ArrayList<E>();
			for(int i=0;i<a;i++){
				edge.add(new E(sc.nextInt(), sc.nextInt(), sc.next()));
			}
			String[][] dp = new String[n][LEN+1];
			boolean[][] flag = new boolean[n][LEN+1];
			String[] ans = new String[n];
			Arrays.fill(ans, "");
			for(int i=0;i<n;i++)for(int j=0;j<=LEN;j++)dp[i][j]=null;
			dp[s][0] = "";
			flag[s][0] = true;
			for(int j=0;j<=LEN;j++){
				for(int i=0;i<n;i++){
					if(flag[i][j]){
						flag[i][j] = false;
						for(E e:edge){
							if(e.s == i){
								String next = dp[i][j] + e.spell;
								if(next.length() <= LEN && (dp[e.t][next.length()]==null || next.compareTo(dp[e.t][next.length()])<0)){
									flag[e.t][next.length()] = true;
									dp[e.t][next.length()] = next;
									if(ans[e.t].equals("") || next.compareTo(ans[e.t]) < 0){
										ans[e.t] = next;
									}
								}
							}
						}
					}
				}
			}
			System.out.println(ans[g].equals("")||ans[g].length()>=(n-1)*6?"NO":ans[g]);
		}
	}
}
