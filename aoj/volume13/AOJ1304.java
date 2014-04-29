package volume13;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

//Infected Land
public class AOJ1304 {

	class R{
		String s;
		int pos, c;
		public R(String s, int pos, int c) {
			this.s = s;
			this.pos = pos;
			this.c = c;
		}
	}

	void run(){
		Scanner sc = new Scanner(System.in);
		int[][] d = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
		for(;;){
			int n = sc.nextInt();
			if(n==0)break;
			char[] m = new char[n*n];
			int pos = 0, c = 0;;
			for(int i=0;i<n;i++){
				char[] t = sc.next().toCharArray();
				for(int j=0;j<n;j++){
					if(t[j]=='@')pos=i*n+j;
					if(t[j]=='#')c++;
					m[i*n+j]=t[j];
				}
			}
			Set<String> v = new HashSet<String>();
			List<R> l = new ArrayList<R>();
			l.add(new R(new String(m), pos, c));
			v.add(l.get(0).s);
			int res = -1, step = 0;
			while(!l.isEmpty()){
				List<R> next = new ArrayList<R>();
				for(R r:l){
					if(r.c==0){
						res = step; next.clear(); break;
					}
					int pi = r.pos/n, pj = r.pos%n;
					for(int k=0;k<8;k++){
						int ni = pi+d[k][0], nj = pj+d[k][1];
						char[] map = r.s.toCharArray();
						if(0<=ni&&ni<n&&0<=nj&&nj<n&&map[ni*n+nj]=='.'){
							map[ni*n+nj] = '@'; map[r.pos] = '.';
							int nc = 0;
							char[] nm = new char[n*n];
							for(int i=0;i<n;i++)for(int j=0;j<n;j++){
								if(map[i*n+j]=='@'){
									nm[i*n+j] = '@';
									continue;
								}
								int adj = 0;
								for(int x=0;x<8;x++){
									int xi = i+d[x][0], xj = j+d[x][1];
									if(0<=xi&&xi<n&&0<=xj&&xj<n&&map[xi*n+xj]!='.')adj++;
								}
								if(map[i*n+j]=='#'&&(adj==2||adj==3)){
									nm[i*n+j] = '#';
									nc++;
								}
								else if(map[i*n+j]=='.'&&adj==3){
									nm[i*n+j] = '#';
									nc++;
								}
								else nm[i*n+j] = '.';
							}
							R nr = new R(new String(nm), ni*n+nj, nc);
							if(!v.contains(nr.s)){
								v.add(nr.s); next.add(nr);
							}
						}
					}
				}
				step++;
				l = next;
			}
			System.out.println(res);
		}
	}

	public static void main(String[] args) {
		new AOJ1304().run();
	}
}
