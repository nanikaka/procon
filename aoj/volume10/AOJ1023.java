package volume10;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Amazing Graze
public class AOJ1023 {

	class R{
		int x, y;
		public R(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	class Scanner {
		int nextInt() {
			try {
				int c = System.in.read();
				while (c != '-' && (c < '0' || '9' < c))
					c = System.in.read();
				if (c == '-') return -nextInt();
				int res = 0;
				do {
					res *= 10;
					res += c - '0';
					c = System.in.read();
				} while ('0' <= c && c <= '9');
				return res;
			} catch (Exception e) {
				return -1;
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	void run(){
		Scanner sc = new Scanner();
		int N = 250, M = 45;
		List<R>[][] l = new List[N][N];
		for(int i=0;i<N;i++)for(int j=0;j<N;j++)l[i][j]=new ArrayList<R>();
		int[][] d = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,0},{0,1},{1,-1},{1,0},{1,1}};
		for(;;){
			int AN = sc.nextInt(), BN = sc.nextInt(), R = sc.nextInt();
			if((AN|BN)==0)break;
			for(int i=0;i<N;i++)for(int j=0;j<N;j++)l[i][j].clear();
			for(int i=0;i<AN;i++){
				int x = sc.nextInt(), y = sc.nextInt();
				l[x/M][y/M].add(new R(x, y));
			}
			int res = 0;
			while(BN--!=0){
				int x = sc.nextInt(), y = sc.nextInt();
				Set<Integer> u = new HashSet<Integer>();
				for(int k=0;k<9;k++){
					int nx = x+d[k][0]*4*R, ny = y+d[k][1]*4*R;
					if(0<=nx&&nx<10000&&0<=ny&&ny<10000)u.add((nx/M)*N+ny/M);
				}
				for(int v:u)for(R r:l[v/N][v%N])res+=(r.x-x)*(r.x-x)+(r.y-y)*(r.y-y)<=16*R*R?1:0;
			}
			System.out.println(res);
		}
	}
	
	public static void main(String[] args) {
		new AOJ1023().run();
	}
}
