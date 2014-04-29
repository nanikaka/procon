package volume11;

import java.util.Arrays;
import java.util.Scanner;

//Verbal Arithmetic
public class AOJ1161 {

	static int ans;
	static int[] assign;
	static char[][] s;
	static int n;
	static boolean[] used;
	
	static void dfs(int k, int m, int sum){
		if(k==s[n-1].length){
			if(sum==0){
				boolean f = true;
				for(int i=0;i<n;i++){
					if(assign[s[i][0]-'A']==0&&s[i].length > 1){
						f = false;
						break;
					}
				}
				if(f)ans++;
			}
			return;
		}
		int pos = s[m].length-1-k;
		if(pos < 0){
			dfs(k,m+1,sum);
			return;
		}
		int ch = s[m][pos]-'A';
		if(m==n-1){
			if(assign[ch]!=-1){
				if(assign[ch]==sum%10){
					dfs(k+1, 0, sum/10);
				}
			}
			else{
				int mod = sum%10;
				if(!used[mod]){
					if(mod==0&&pos==0&&s[m].length!=1)return;
					used[mod] = true;
					assign[ch] = mod;
					dfs(k+1, 0, sum/10);
					used[mod] = false;
					assign[ch] = -1;
				}
			}
			return;
		}
		if(assign[ch]!=-1){
			dfs(k, m+1, sum+assign[ch]);
			return;
		}
		for(int i=0;i<10;i++){
			if(!used[i]){
				if(i==0&&pos==0&&s[m].length!=1)continue;
				used[i] = true;
				assign[ch] = i;
				dfs(k, m+1, sum+i);
				used[i] = false;
				assign[ch] = -1;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			n = sc.nextInt();
			if(n==0)break;
			s = new char[n][];
			int upmax = 0;
			for(int i=0;i<n;i++){
				s[i]=sc.next().toCharArray();
				if(i<n-1)
					upmax = Math.max(upmax, s[i].length);
			}
			if(s[n-1].length < upmax){
				System.out.println(0);
				continue;
			}
			ans = 0;
			assign = new int[26];
			Arrays.fill(assign, -1);
			used = new boolean[10];
			dfs(0,0,0);
			System.out.println(ans);
		}
	}
}
