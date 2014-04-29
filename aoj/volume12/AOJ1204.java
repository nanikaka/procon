package volume12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Pipeline Scheduling
public class AOJ1204 {

	List<Integer>[] e;
	boolean[][] t;
	int res, n;
	
	void dfs(int k, int h, int max){
		if(k==10){
			res = Math.min(res, max); return;
		}
		if(res<=max||res<=h+n)return;
		for(int i=h;i<=max;i++){
			boolean ok = true;
			for(int y=0;y<5;y++){
				if(!ok)break;
				for(int x:e[y]){
					if(t[y][i+x]){
						ok = false; break;
					}
				}
			}
			if(ok){
				int m = 0;
				for(int y=0;y<5;y++){
					for(int x:e[y]){
						t[y][i+x] = true;
						m = Math.max(m, i+x);
					}
				}
				dfs(k+1, i+1, m);
				for(int y=0;y<5;y++){
					for(int x:e[y]){
						t[y][i+x] = false;
					}
				}
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			n = sc.nextInt();
			if(n==0)break;
			e = new List[5];
			for(int i=0;i<5;i++)e[i]=new ArrayList<Integer>();
			t = new boolean[5][210];
			for(int i=0;i<5;i++){
				char[] s = sc.next().toCharArray();
				for(int j=0;j<n;j++)if(s[j]=='X'){
					t[i][j] = true; e[i].add(j);
				}
			}
			res = 1<<29;
			dfs(1, 0, n);
			System.out.println(res+1);
		}
	}
	
	public static void main(String[] args) {
		new AOJ1204().run();
	}
}
