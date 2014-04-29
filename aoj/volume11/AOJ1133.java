package volume11;

import java.util.Arrays;
import java.util.Scanner;

//Water Tank
public class AOJ1133 {

	int W = 100, H = 50, D = 30;
	double EPS = 1e-8;

	R head;

	//区間クラス
	class R{
		int xl, xr, hl, hr;
		double h;
		R left, right;
		public R(int xl, int xr, int hl, int hr) {
			this.xl = xl;
			this.xr = xr;
			this.hl = hl;
			this.hr = hr;
			left = right = null;
			h = 0;
		}
		//isleft方向へ水が流れるとき、水をためるような場所があるかどうか
		boolean enable(boolean isleft){
			if(h!=Math.min(hl, hr))return true;
			if(isleft){
				if(left==null)return false;
				return left.enable(isleft);
			}
			else {
				if(right==null)return false;
				return right.enable(isleft);
			}
		}
		//座標posの水の高さを得る
		double getH(int pos){
			return xl<=pos&&pos<=xr?h:right.getH(pos);
		}
		//座標posを含む区間を見つけて、量vの水を流す
		//返り値は余った水の量
		double f(int pos, double v){
			if(xl<=pos&&pos<=xr)return flow(v);
			else return right.f(pos, v);
		}
		//flowとほぼ同じ。水の流れる方向が固定されている
		double sub(double V, boolean isleft){
			double minh = Math.min(hl, hr);
			double dh = V/D/(xr-xl);
			if(minh<=h+dh){
				double v = V-(minh-h)*D*(xr-xl);
				h = minh;
				if(isleft){
					if(h==hl&&left!=null&&left.enable(true))return left.sub(v, true);
					else return v;
				}
				else{
					if(h==hr&&right!=null&&right.enable(false))return right.sub(v, false);
					else return v;
				}
			}
			h+=dh;
			return 0;
		}
		//この区間に水をV流す。仕切りを飛び越える場合を含めて流せるだけ流す。返り値は余った水の量
		double flow(double V){
			double minh = Math.min(hl, hr);
			double dh = V/D/(xr-xl);
			if(minh<=h+dh){
				double v = V-(minh-h)*D*(xr-xl);
				h = minh;
				if(h==hl){
					if(left!=null&&left.enable(true))return left.sub(v, true);
					else return v;
				}
				if(h==hr){
					if(right!=null&&right.enable(false))return right.sub(v, false);
					else return v;
				}
			}
			h+=dh;
			return 0;
		}
		//満タンになっている区間が隣り合っていた場合結合する
		boolean union(){
			if(left!=null){
				if(Math.abs(hl-h)<EPS&&Math.abs(hl-left.h)<EPS){
					R nr = new R(left.xl, xr, left.hl, hr);
					nr.h = h;
					nr.left = left.left;
					nr.right = right;
					if(nr.left!=null)nr.left.right = nr;
					if(nr.right!=null)nr.right.left = nr;
					if(nr.left==null)head = nr;
					return true;
				}
			}
			if(right!=null){
				if(Math.abs(hr-h)<EPS&&Math.abs(hr-right.h)<EPS){
					R nr = new R(xl, right.xr, hl, right.hr);
					nr.h = h;
					nr.left = left;
					nr.right = right.right;
					if(nr.left!=null)nr.left.right = nr;
					if(nr.right!=null)nr.right.left = nr;
					if(nr.left==null)head = nr;
					return true;
				}
				return right.union();
			}
			return false;
		}
		@Override
		public String toString() {
			return "["+xl+", "+xr+"] H: " + h;
		}
	}

	//出力用の情報クラス
	class L implements Comparable<L>{
		int id, x, t;
		double res;
		public L(int id, int x, int t) {
			this.id = id;
			this.x = x;
			this.t = t;
		}
		public int compareTo(L o) {
			return t-o.t;
		}
	}

	void run(){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T--!=0){
			int n = sc.nextInt();
			R[] r = new R[n+1];
			int px = 0, ph = H;
			for(int i=0;i<n;i++){
				int x = sc.nextInt();
				int h = sc.nextInt();
				r[i] = new R(px, x, ph, h);
				px = x; ph = h;
			}
			r[n] = new R(px, W, ph, H);
			for(int i=0;i<=n;i++){
				if(i>0)r[i].left = r[i-1];
				if(i<n)r[i].right = r[i+1];
			}
			head = r[0];
			int m = sc.nextInt();
			int[] pos = new int[m];
			int[] v = new int[m];
			for(int i=0;i<m;i++){
				pos[i] = sc.nextInt(); v[i] = sc.nextInt();
			}
			int Ln = sc.nextInt();
			L[] log = new L[Ln];
			for(int i=0;i<Ln;i++)log[i] = new L(i, sc.nextInt(), sc.nextInt());
			//時間の昇順にソート
			Arrays.sort(log);
			//実験開始からの経過時間
			int t = 0;
			for(int i=0;i<Ln;i++){
				L f = log[i];
				//何秒間水を流すか
				int time = f.t-t;
				for(int j=0;j<m;j++){
					double V = v[j]*time;
					//水の量が0もしくは水位が50に達したら終了
					while(V>0&&head.h<H){
						boolean con = true;
						//満タンになっている区間がある限り結合し続ける
						while(con){
							con = head.union();
						}
						//水を流せるだけ流す
						V = head.f(pos[j], V);
					}
				}
				t += time;
				//水位を記録
				f.res = head.getH(f.x);
			}
			for(int i=0;i<Ln;i++){
				for(int j=0;j<Ln;j++)if(log[j].id==i)System.out.printf("%.4f\n", log[j].res);
			}
		}
	}
	
	public static void main(String[] args) {
		new AOJ1133().run();
	}
	
}
