package volume12;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//Geometric Map
public class AOJ1279 {

	final double EPS = 1e-9;
	double dot(double[] a, double[] b){
		return a[0]*b[0]+a[1]*b[1];
	}
	double cross(double[] a, double[] b){
		return a[0]*b[1]-a[1]*b[0];
	}
	double norm(double[] a){
		return Math.hypot(a[0], a[1]);
	}
	double norm(double[] a, double[] b){
		return Math.hypot(a[0]-b[0], a[1]-b[1]);
	}
	double[] sub(double[] a, double[] b){
		return new double[]{a[0]-b[0], a[1]-b[1]};
	}
	double ex(double[] a, double[] b, double[] c){
		double[] s1 = sub(b, a), s2 = sub(c, a);
		return cross(s1, s2);
	}
	double dist(double[] a, double[] b, double[] p){
		if(dot(sub(b, a), sub(p, a))<EPS)return norm(a, p);
		if(dot(sub(a, b), sub(p, b))<EPS)return norm(b, p);
		return Math.abs(cross(sub(b, a), sub(p, a)))/norm(a, b);
	}
	boolean crossing(double[] a, double[] b, double[] s, double[] t){
		if(Math.abs(cross(sub(b, a), sub(t, s)))<EPS){
			return Math.min(dist(a, b, s), Math.min(dist(a, b, t), Math.min(dist(s, t, a), dist(s, t, b))))<EPS;
		}
		if(ex(a, b, s)*ex(a, b, t)>0)return false;
		if(ex(b, a, s)*ex(b, a, t)>0)return false;
		if(ex(s, t, a)*ex(s, t, b)>0)return false;
		return ex(t, s, a)*ex(t, s, b)<EPS;
	}
	double angleCos(double[] a, double[] b){
		double na = norm(a), nb = norm(b);
		return Math.acos(dot(a, b)/na/nb);
	}

	//座標(x, y)の交差点につける番号
	int[][] id;
	int ID, INF = 1<<29;
	//e[id1][id2]: 交差点id1からid2への間のコスト、通行不可能ならINF
	double[][] wf, e;
	//道路の線分と標識線分のリスト
	List<double[][]> segs, signs;
	//交差点の番号をキーにしてその座標を得る逆引き表
	Map<Integer, int[]> ref;
	
	//座標sの交差点から座標tの交差点へいけるか？
	void check(double[] s, double[] t){
		int ids = get(s[0], s[1]), idt = get(t[0], t[1]);
		boolean ok =  true;
		//標識を調べる
		for(double[][] p:signs){
			if(!ok)break;
			if(!crossing(s, t, p[0], p[1]))continue;
			int touch = -1;
			if(dist(s, t, p[0])<EPS)touch = 0;
			else touch = 1;
			if(angleCos(sub(t, s), sub(p[touch], p[1-touch]))>Math.PI/2-EPS)ok = false;
		}
		//通行できるならコストを計算
		if(ok){
			e[ids][idt] = wf[ids][idt] = norm(s, t);
		}
	}
	
	//座標(x, y)に番号をつける。登録済みなら何もしない
	void reg(double x, double y){
		if(id[(int)x][(int)y]!=-1)return;
		ref.put(ID, new int[]{(int)x, (int)y});
		id[(int)x][(int)y] = ID++;
	}
	//座標(x, y)の番号を得る。キャストめんどいからこれを用意
	int get(double x, double y){
		return id[(int)x][(int)y];
	}

	void run(){
		Scanner sc = new Scanner(System.in);
		id = new int[1001][1001];
		for(;;){
			int n = sc.nextInt();
			if(n==0)break;
			for(int[]a:id)Arrays.fill(a, -1);
			ID = 0;
			ref = new HashMap<Integer, int[]>();
			reg(sc.nextInt(), sc.nextInt()); reg(sc.nextInt(), sc.nextInt());
			segs = new LinkedList<double[][]>();
			for(int i=0;i<n;i++){
				double[][] ps = new double[2][2];
				for(int j=0;j<2;j++)for(int k=0;k<2;k++)ps[j][k]=sc.nextDouble();
				segs.add(ps);
			}
			signs = new LinkedList<double[][]>();
			//線分リストの中から標識を見つけて除去する
			for(int i=0;i<segs.size();i++){
				double[][] p = segs.get(i);
				boolean f0 = false, f1 = false;
				for(int j=0;j<segs.size();j++){
					if(i==j)continue;
					double[][] q = segs.get(j);
					double norm = norm(q[0], q[1]);
					double d1 = norm(p[0], q[0]), d2 = norm(p[0], q[1]), d3 = norm(p[1], q[0]), d4 = norm(p[1], q[1]);
					if(Math.abs(d1+d2-norm)<EPS)f0 = true;
					if(Math.abs(d3+d4-norm)<EPS)f1 = true;
				}
				//線分iの端点のうち、どの線分にも交差していないものがあったらこれは標識
				if(!(f0&&f1)){
					signs.add(p); segs.remove(i--);
				}
			}
			//線分の端点が交差点となるので登録する
			for(double[][]p:segs){
				reg(p[0][0], p[0][1]); reg(p[1][0], p[1][1]);
			}
			//線分を整形する
			for(;;){
				boolean con = false;
				for(int i=0;!con&&i<segs.size();i++){
					double[][] p = segs.get(i);
					int idA = get(p[0][0], p[0][1]), idB = get(p[1][0], p[1][1]);
					double d = norm(p[0], p[1]);
					for(int j=0;!con&&j<segs.size();j++){
						if(i==j)continue;
						double[][] q = segs.get(j);
						int idC = get(q[0][0], q[0][1]), idD = get(q[1][0], q[1][1]);
						if(!crossing(p[0], p[1], q[0], q[1]))continue;
						double d1 = norm(p[0], q[0]), d2 = norm(p[1], q[0]);
						if(idA!=idC&&idB!=idC&&Math.abs(d-(d1+d2))<EPS){
							con = true;
							double[][] seg1 = {{p[0][0], p[0][1]}, {q[0][0], q[0][1]}}, seg2 = {{q[0][0], q[0][1]}, {p[1][0], p[1][1]}};
							segs.remove(i); segs.add(seg1); segs.add(seg2);
							break;
						}
						d1 = norm(p[0], q[1]); d2 = norm(p[1], q[1]);
						if(idA!=idD&&idB!=idD&&Math.abs(d-(d1+d2))<EPS){
							con = true;
							double[][] seg1 = {{p[0][0], p[0][1]}, {q[1][0], q[1][1]}}, seg2 = {{q[1][0], q[1][1]}, {p[1][0], p[1][1]}};
							segs.remove(i); segs.add(seg1); segs.add(seg2);
						}
					}
				}
				if(!con)break;
			}
			n = segs.size();
			int N = ID;
			wf = new double[N][N];
			e = new double[N][N];
			for(double[]a:wf)Arrays.fill(a, INF);
			for(double[]a:e)Arrays.fill(a, INF);
			for(int i=0;i<N;i++)wf[i][i]=0;
			//整形済みなので線分の端点から端点へ行けるかを調べるだけで良い
			for(double[][] p:segs){
				check(p[0], p[1]); check(p[1], p[0]);
			}
			//ワーシャルフロイド
			for(int k=0;k<N;k++)for(int i=0;i<N;i++)for(int j=0;j<N;j++)wf[i][j]=Math.min(wf[i][j], wf[i][k]+wf[k][j]);
			//到達不可能なら-1
			if(wf[0][1]==INF){
				System.out.println(-1); continue;
			}
			else{
				//ワーシャルフロイドから経路を復元
				StringBuilder res = new StringBuilder();
				int pt = 0;
				for(;;){
					int[] p = ref.get(pt);
					res.append(p[0]+" "+p[1]+"\n");
					if(pt==1)break;
					for(int k=0;k<N;k++){
						if(e[pt][k]==INF)continue;
						double d = wf[0][pt]+e[pt][k]+wf[k][1];
						if(Math.abs(d-wf[0][1])<EPS){
							pt = k; break;
						}
					}
				}
				res.append("0");
				System.out.println(res);
			}
		}
	}

	public static void main(String[] args) {
		new AOJ1279().run();
	}
}
