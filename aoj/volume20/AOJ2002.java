package volume20;

import java.util.Scanner;

//X-Ray Screening System
public class AOJ2002 {

	int h, w, n;
	char[][] map;
	int[][] r;//0: top 1:bottom 2:left 3:right
	int[] order;
	boolean[] u;
	boolean[] used;
	
	boolean check(){
		boolean[] checked = new boolean[26];
		for(int k=0;k<n;k++){
			int x = order[k];
			checked[x] = true;
			for(int i=r[x][0];i<=r[x][1];i++){
				for(int j=r[x][2];j<=r[x][3];j++){
					if(map[i][j]=='.')return false;
					int c = map[i][j] - 'A';
					if(!checked[c])return false;
				}
			}
		}
		return true;
	}
	
	boolean dfs(int k){
		if(k==n){
			return check();
		}
		for(int i=0;i<26;i++){
			if(u[i]&&!used[i]){
				used[i] = true;
				order[k] = i;
				if(dfs(k+1))return true;
				used[i] = false;
			}
		}
		return false;
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t--!=0){
			h = sc.nextInt();
			w = sc.nextInt();
			map = new char[h][w];
			u = new boolean[26];
			r = new int[26][4];
			n = 0;
			for(int i=0;i<h;i++){
				char[] ch = sc.next().toCharArray();
				for(int j=0;j<w;j++){
					map[i][j] = ch[j];
					if(map[i][j]=='.')continue;
					int x = map[i][j]-'A';
					if(!u[x]){
						n++;
						u[x] = true;
						r[x][0] = r[x][1] = i;
						r[x][2] = r[x][3] = j;
					}
					else{
						r[x][0] = Math.min(r[x][0], i);
						r[x][1] = Math.max(r[x][1], i);
						r[x][2] = Math.min(r[x][2], j);
						r[x][3] = Math.max(r[x][3], j);
					}
				}
			}
			order = new int[n];
			used = new boolean[26];
			System.out.println(dfs(0)?"SAFE":"SUSPICIOUS");
		}
	}
	
	public static void main(String[] args) {
		new AOJ2002().run();
	}
}
