package volume12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//GIGA Universe Cup
public class AOJ1234 {

	//チームを表すクラス
	//勝ち数、Diff,ゴール数の優先順序でソートできる
	class R implements Comparable<R>{
		//nobattleはまだ試合をしていない相手のチーム番号
		int id, nobattle, point, goal, diff;
		boolean concerned;
		int[] get, lose;
		public R(int id) {
			this.id = id;
			get = new int[4];
			lose = new int[4];
		}
		//試合全体の結果を使って、勝ち数、Diff, ゴール数を計算
		void calc1(){
			point = goal = diff = 0;
			for(int i=0;i<4;i++){
				if(id==i)continue;
				point += get[i]>lose[i]?3:get[i]==lose[i]?1:0;
				goal += get[i];
				diff += get[i]-lose[i];
			}
		}
		//同じ順位のチーム同士の試合結果を使って、勝ち数、Diff、ゴール数を計算
		void calc2(){
			if(!concerned)return;
			point = goal = diff = 0;
			for(int i=0;i<4;i++){
				if(id==i||!teams[i].concerned)continue;
				point += get[i]>lose[i]?3:get[i]==lose[i]?1:0;
				goal += get[i];
				diff += get[i]-lose[i];
			}
		}
		public int compareTo(R o) {
			return point!=o.point?o.point-point:diff!=o.diff?o.diff-diff:o.goal-goal;
		}
	}

	//Listの中にfというチームがいるか
	boolean exist(int f, List<R> list){
		for(R r:list)if(r.id==f)return true;
		return false;
	}

	//あるチームの集合の中で(d),(e),(f)のソートをし、その中で最も成績の良いチームを返す
	//結果は更に同順位になりうるのでリストである
	List<R> ranking(List<R> list){
		List<R> res = new ArrayList<R>();
		for(int i=0;i<4;i++)teams[i].concerned = false;
		R[] t = new R[list.size()];
		for(int i=0;i<list.size();i++){
			t[i] = list.get(i);
			t[i].concerned = true;
		}
		for(int i=0;i<list.size();i++)t[i].calc2();
		Arrays.sort(t);
		res.add(t[0]);
		for(int i=1;i<list.size();i++)if(t[0].compareTo(t[i])==0)res.add(t[i]);
		return res;
	}

	//チーム4つ
	R[] teams;
	
	//チーム f がリーグを勝ち抜くことができる確率を返す
	double win(int f){
		double res = 0;
		R[] tmp = new R[4];
		//作業用の配列にコピー
		for(int i=0;i<4;i++)tmp[i]=teams[i];
		//(a),(b),(c)によってランク付け
		for(int i=0;i<4;i++)tmp[i].calc1();
		Arrays.sort(tmp);
		List<R> first = new ArrayList<R>();
		first.add(tmp[0]);
		for(int i=1;i<4;i++)if(tmp[0].compareTo(tmp[i])==0)first.add(tmp[i]);
		//リスト firstには4チームの中でrank 1 (同順位含む) のチームが入っている
		
		//firstが2チームである -> リーグを勝ち抜くチームは一意に決まる
		if(first.size()==2){
			res = exist(f, first)?1:0;
		}
		//チームが3チーム以上ある
		else if(first.size()>2){
			//ビリなら予選落ち確定
			if(!exist(f, first)){
				return 0;
			}
			List<R> t = new ArrayList<R>();
			for(R r:first)t.add(r);
			//ふるい落とせるだけ、(d)(e)(f)のランク付けをする
			for(;;){
				int pre = t.size();
				t = ranking(t);
				//2チームに絞れた
				if(t.size()==2){
					res = exist(f, t)?1:0;
					break;
				}
				//1チームに絞れた
				if(t.size()==1){
					//1位決定なので通過確定
					if(exist(f, t))return 1;
					int p = t.get(0).id;
					//firstから1位のチームを抜いたリスト t
					t = new ArrayList<R>();
					for(R r:first)if(p!=r.id)t.add(r);
					t = ranking(t);
					//再び(d)(e)(f)を使って絞り込む
					for(;;){
						int size = t.size();
						t = ranking(t);
						//1チームに絞れた こいつが2位通過
						if(t.size()==1){
							return res = exist(f, t)?1:0;
						}
						//絞りきれないのでくじ引き
						if(size==t.size()){
							return res = exist(f, t)?(1.0/size):0;
						}
					}
				}
				//絞りきれないのでくじ引き
				else if(pre==t.size()){
					return exist(f, t)?(2.0/pre):0;
				}
			}
		}
		//1位はどこかが分かった
		else{
			//1位なら通過確定
			if(exist(f, first))return 1;
			//firstから1位のチームを抜いたリスト t
			List<R> t = new ArrayList<R>();
			t.add(tmp[1]);
			for(int i=2;i<4;i++)if(tmp[1].compareTo(tmp[i])==0)t.add(tmp[i]);
			//絞り込む d,e,f
			for(;;){
				int size = t.size();
				t = ranking(t);
				//1チームに絞れた こいつが2位通過
				if(t.size()==1){
					res = exist(f, t)?1:0;
					break;
				}
				//絞りきれないのでくじ引き
				if(size==t.size()){
					res = exist(f, t)?(1.0/size):0;
					break;
				}
			}
		}
		return res;
	}

	void run(){
		int[] fact = new int[9];
		fact[0]=1; for(int i=1;i<=8;i++)fact[i]=fact[i-1]*i;
		//P点を試合で得点する確率
		double[] gain = new double[9];
		for(int i=0;i<=8;i++)gain[i]=fact[8]/fact[i]/fact[8-i]*Math.pow(0.25, i)*Math.pow(0.75, 8-i);
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T--!=0){
			String[] table = new String[5];
			teams = new R[4];
			for(int i=0;i<4;i++)teams[i]=new R(i);
			for(int i=0;i<5;i++)table[i]=sc.next();
			int focus = 0;
			//行の先頭が"*"で始まっているならそのチームが注目チーム
			for(int i=1;i<5;i++)if(table[i].startsWith("*"))focus = i-1;
			for(int i=0;i<4;i++)for(int j=i+1;j<4;j++){
				//得点の情報だけを抜き出す
				String sub = table[i+1].substring(6+5*j, 9+5*j);
				String[] s = sub.split("-");
				//得点の数字の場所が"_"ならまだ試合がない
				if(s[0].equals("_")){
					teams[i].nobattle = j;
					teams[j].nobattle = i;
				}
				else{
					int x = Integer.parseInt(s[0]), y = Integer.parseInt(s[1]);
					teams[i].get[j] = x; teams[i].lose[j] = y;
					teams[j].get[i] = y; teams[j].lose[i] = x;
				}
			}
			double res = 0;
			//4チームそれぞれ0～8点に固定する
			for(int a=0;a<9;a++)for(int b=0;b<9;b++)for(int c=0;c<9;c++)for(int d=0;d<9;d++){
				//この状態になる確率
				double p = gain[a]*gain[b]*gain[c]*gain[d];
				int[] e = new int[]{a,b,c,d};
				//未試合相手に対する情報を入れる
				for(int i=0;i<4;i++){
					teams[i].get[teams[i].nobattle] = e[i];
					teams[i].lose[teams[i].nobattle] = e[teams[i].nobattle];
				}
				//リーグ通過する確率を足す
				res += p*win(focus);
			}
			System.out.printf("%.7f\n", res);
		}
	}

	public static void main(String[] args) {
		new AOJ1234().run();
	}
}
