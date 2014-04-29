package volume12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//Color the Map
public class AOJ1254 {

	//国を表す
	class R{
		//国境線のリスト
		List<L> l;
		boolean u;
		int color, id;
		public R(int id) {
			this.id = id;
			l = new ArrayList<L>();
			u = false;
			color = 0;
		}
		//国rと隣接しているか
		boolean adj(R r){
			for(L a:l)for(L b:r.l){
				double x1 = a.t.x-a.s.x, y1 = a.t.y-a.s.y, x2 = b.t.x-b.s.x, y2 = b.t.y-b.s.y;
				//辺が平行でない
				if(x1*y2-x2*y1!=0)continue;
				//傾きが0の時の特別処理
				if(x1==0){
					//x座標が異なれば隣接しない
					if(a.s.x!=b.s.x)continue;
					P[] p = new P[4];
					a.s.id = a.t.id = 0; b.s.id = b.t.id = 1;
					p[0] = a.s; p[1] = a.t;
					p[2] = b.s; p[3] = b.t;
					//座標を辞書順ソート
					Arrays.sort(p);
					//最初2つが同じ国のものなので隣接しない
					if(p[0].id==p[1].id)continue;
					//1つ目と2つ目の点が同じ位置になければ隣接している
					//0--1=2--3 ←これは隣接していない
					if(!p[1].eq(p[2]))return true;
				}
				else{
					//直線の方程式 y = (alpha)*x + (beta)のalpha, betaを求める
					double alpha = y1/x1;
					double beta = a.s.y-alpha*a.s.x;
					double y = b.s.y, x = alpha*b.s.x+beta;
					//もう片方の国の国境線の端点がこの方程式を満たすか
					if(Math.abs(y-x)<1e-7){
						P[] p = new P[4];
						a.s.id = a.t.id = 0; b.s.id = b.t.id = 1;
						p[0] = a.s; p[1] = a.t;
						p[2] = b.s; p[3] = b.t;
						Arrays.sort(p);
						if(p[0].id==p[1].id)continue;
						if(!p[1].eq(p[2]))return true;
					}
				}
			}
			return false;
		}
	}
	//点を表す
	class P implements Comparable<P>{
		int id;
		double x, y;
		public P(double x, double y, int d) {
			this.x = x;
			this.y = y;
			id = d;
		}
		public int compareTo(P o) {
			if(x<o.x)return -1;
			if(o.x<x)return 1;
			return (int) Math.signum(y-o.y);
		}
		boolean eq(P p){
			return Math.abs(x-p.x)<1e-7 && Math.abs(y-p.y)<1e-7;
		}
	}
	//線を表す
	class L{
		P s, t;
		public L(P s, P t) {
			this.s = s;
			this.t = t;
			if(t.compareTo(s)<0){
				P tmp = s;
				s = t;
				t = tmp;
			}
		}
		
	}

	R[] c;
	int N, min;
	boolean[][] adj;
	
	//色塗り
	void dfs(int k, int maxcolor){
		boolean[] u = new boolean[11];
		for(int i=0;i<N;i++){
			if(adj[k][i])u[c[i].color] = true;
		}
		if(k==N-1){
			for(int i=1;i<=maxcolor+1;i++){
				if(!u[i]){
					min = Math.min(min, Math.max(i, maxcolor));
					return;
				}
			}
		}
		for(int i=1;i<=maxcolor+1;i++){
			if(!u[i]){
				c[k].color = i;
				dfs(k+1, Math.max(i, maxcolor));
				c[k].color = 0;
			}
		}
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			int n = sc.nextInt();
			if(n==0)break;
			int id = 0;
			Map<String, Integer> ref = new HashMap<String, Integer>();
			c = new R[10];
			while(n--!=0){
				String name = sc.next();
				R r;
				if(ref.containsKey(name))r = c[ref.get(name)];
				else{
					r = new R(id);
					c[id] = r;
					ref.put(name, id++);
				}
				int sx = sc.nextInt(), sy = sc.nextInt();
				int px = sx, py = sy;
				for(;;){
					int x = sc.nextInt();
					if(x==-1){
						r.l.add(new L(new P(px, py, 0), new P(sx, sy, 0)));
						break;
					}
					int y = sc.nextInt();
					r.l.add(new L(new P(px, py, 0), new P(x, y, 0)));
					px = x; py = y;
				}
			}
			adj = new boolean[id][id];
			for(int i=0;i<id;i++)for(int j=i+1;j<id;j++){
				if(adj[i][j])continue;
				if(c[i].adj(c[j])){
					adj[i][j] = true;
					adj[j][i] = true;
				}
			}
			N = id;
			min = 10;
			dfs(0, 0);
			System.out.println(min);
		}
	}

	public static void main(String[] args) {
		new AOJ1254().run();
	}
}
