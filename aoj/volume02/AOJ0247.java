package volume02;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//Ice Maze
public class AOJ0247 {

	int w, h, si, sj, gi, gj, INF = 1<<29, res;
	int[][] d = {{-1,0},{0,1},{1,0},{0,-1}};
	int[] ice, hit;
	int[][] id, dist;
	char[][] m;
	boolean[][] v;
	
	void mark(int i, int j, int x){
		id[i][j] = x;
		ice[x]++;
		for(int k=0;k<4;k++){
			int ni = i+d[k][0], nj = j+d[k][1];
			if(m[ni][nj]=='X'&&id[ni][nj]==0)mark(ni, nj, x);
		}
	}
	
	boolean f(int i, int j, int depth, int pi, int pj){
		if(res < depth+dist[i][j])return false;
		if(gi==i && gj==j){
			return true;
		}
		for(int k=0;k<4;k++){
			int ni = i+d[k][0], nj = j+d[k][1];
			if(ni!=pi&&nj!=pj&&v[ni][nj])return false;
		}
		for(int k=0;k<4;k++){
			int ni = i+d[k][0], nj = j+d[k][1];
			if(!v[ni][nj]&&m[ni][nj]!='#'){
				if(ice[id[ni][nj]]>>1 >= hit[id[ni][nj]]+1){
					hit[id[ni][nj]]++;
					v[ni][nj] = true;
					if(f(ni, nj, depth+1, i, j))return true;
					v[ni][nj] = false;
					hit[id[ni][nj]]--;
				}
			}
		}
		return false;
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		ice = new int[144];
		hit = new int[144];
		dist = new int[14][14];
		m = new char[14][14];
		v = new boolean[14][14];
		for(;;){
			w = sc.nextInt(); h = sc.nextInt();
			if((w|h)==0)break;
			for(int i=0;i<h+2;i++)for(int j=0;j<w+2;j++){
				dist[i][j] = INF;
				v[i][j] = false;
				m[i][j] = '#';
			}
			for(int i=1;i<=h;i++){
				char[] c = sc.next().toCharArray();
				for(int j=1;j<=w;j++){
					m[i][j] = c[j-1];
					if(m[i][j]=='S'){
						m[i][j] = '.'; si = i; sj = j;
					}
					if(m[i][j]=='G'){
						m[i][j] = '.'; gi = i; gj = j;
					}
				}
			}
			Arrays.fill(ice, 0);
			ice[0] = INF;
			id = new int[h+2][w+2];
			int ID = 1;
			for(int i=1;i<=h;i++)for(int j=1;j<=w;j++){
				if(m[i][j]!='X'||id[i][j]>0)continue;
				mark(i, j, ID);
				if(ice[ID]==1){
					m[i][j] = '#';
				}
				ID++;
			}
			dist[gi][gj] = 0;
			Queue<int[]> que = new LinkedList<int[]>();
			que.add(new int[]{gi, gj});
			while(!que.isEmpty()){
				int V[] = que.poll();
				int pi = V[0], pj = V[1];
				for(int k=0;k<4;k++){
					int ni = pi+d[k][0], nj = pj+d[k][1];
					if(m[ni][nj]!='#'&&dist[ni][nj]==INF){
						dist[ni][nj] = dist[pi][pj]+1;
						que.add(new int[]{ni, nj});
					}
				}
			}
			res = 0;
			Arrays.fill(hit, 0);
			v[si][sj] = true;
			while(!f(si, sj, 0, -1, -1)){
				Arrays.fill(hit, 0);
				for(int i=0;i<h+2;i++)for(int j=0;j<w+2;j++)v[i][j]=false;
				v[si][sj] = true;
				res++;
			}
			System.out.println(res);
		}
	}
	
	public static void main(String[] args) {
		new AOJ0247().run();
	}
}
