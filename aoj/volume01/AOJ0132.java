package volume01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//Jigsaw Puzzle
public class AOJ0132 {

	int h, w, n;
	int[] puzzle;
	List<R>[] piece;
	boolean[] res;
	
	class R{
		int H, W;
		int[] p;
		String str;
		public R(int h, int w, char[][] m) {
			H = h;
			W = w;
			p = new int[H];
			str = "";
			for(int i=0;i<H;i++)for(int j=0;j<W;j++){
				p[i] = (p[i]<<1) + (m[i][j]=='#'?1:0);
				str+=m[i][j];
			}
		}
		boolean eq(R r){
			if(H!=r.H || W!=r.W)return false;
			return str.equals(r.str);
		}
	}
	
	char[][] rot(char[][] a){
		int H = a.length, W = a[0].length;
		char[][] res = new char[W][H];
		for(int i=0;i<H;i++)for(int j=0;j<W;j++)res[W-j-1][i] = a[i][j];
		return res;
	}
	
	void dfs(int i, int j, int U, int idx){
		if(j==w){
			dfs(i+1, 0, U, 0); return;
		}
		if(i==h){
			res[U] = true; return;
		}
		for(int u=idx;u<n;u++)if(((U>>u)&1)==0){
			for(R r:piece[u]){
				if(h < i+r.H || w < j+r.W)continue;
				boolean ok = true;
				for(int y=0;y<r.H;y++)if( (puzzle[i+y] & (r.p[y]<<(w-r.W-j))) != (r.p[y]<<(w-r.W-j))){
					ok = false; break;
				}
				if(!ok)continue;
				for(int y=0;y<r.H;y++){
					puzzle[i+y] ^= (r.p[y]<<(w-r.W-j));
				}
				if(((puzzle[i]>>(w-j-1))&1)==0){
					dfs(i, j, U | (1<<u), u+1);
				}
				for(int y=0;y<r.H;y++){
					puzzle[i+y] |= (r.p[y]<<(w-r.W-j));
				}
				
			}
		}
		if(((puzzle[i]>>(w-j-1))&1)==0)
			dfs(i, j+1, U, 0);
	}
	
	@SuppressWarnings("unchecked")
	void run(){
		Scanner sc = new Scanner(System.in);
		piece = new List[10];
		res = new boolean[1024];
		for(;;){
			h = sc.nextInt(); w = sc.nextInt();
			if((h|w)==0)break;
			puzzle = new int[h];
			for(int i=0;i<h;i++){
				char[] s = sc.next().toCharArray();
				for(char c:s)puzzle[i] = (puzzle[i]<<1) + (c=='#'?0:1);
			}
			n = sc.nextInt();
			for(int i=0;i<n;i++){
				piece[i] = new ArrayList<R>();
				int H = sc.nextInt(), W = sc.nextInt();
				char[][] m = new char[H][];
				for(int j=0;j<H;j++)m[j]=sc.next().toCharArray();
				piece[i].add(new R(H, W, m));
				for(int k=0;k<3;k++){
					m = rot(m);
					int t = H;
					H = W; W = t;
					piece[i].add(new R(H, W, m));
				}
				for(int j=0;j<piece[i].size();j++)for(int k=j+1;k<piece[i].size();k++)if(piece[i].get(j).eq(piece[i].get(k))){
					piece[i].remove(k--);
				}
			}
			Arrays.fill(res, false);
			dfs(0, 0, 0, 0);
			int Q = sc.nextInt();
			while(Q--!=0){
				int k = sc.nextInt(), S = 0;
				while(k--!=0)S|=(1<<(sc.nextInt()-1));
				System.out.println(res[S]?"YES":"NO");
			}
		}
	}
	
	public static void main(String[] args) {
		new AOJ0132().run();
	}
}
