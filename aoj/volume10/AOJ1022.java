package volume10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//Indian Puzzle
public class AOJ1022 {

	//式を表すクラス
	//空白の数の大きい順にソートできるようにComparableを書く
	class E implements Comparable<E>{
		//元の文 ex: A+B=5C3など
		String s;
		//含まれる空白の個数 = 埋めこんだアルファベットの個数
		int count;
		//str[0]: 左辺  str[1]:　右辺
		char[][] str;
		public E(String s) {
			this.s = s;
			count = 0;
			for(char c:s.toCharArray())if(Character.isUpperCase(c))count++;
			str = new char[2][];
			String[] t = s.split("=");
			str[0] = (t[0]+"$").toCharArray();
			str[1] = (t[1]+"$").toCharArray();
		}
		public int compareTo(E o) {
			return o.count-count;
		}
	}
	
	int n;
	char[] cand;
	int[] ref;
	boolean[] u;
	List<E> exs;
	
	char[] s;
	int id;
	
	//k番目の等式の中に割り当てていない空白(アルファベット)があれば、未使用の文字を割り当ててみる
	boolean sub(char[] t, int k, int ind){
		//割り当てが終わったら式の評価ができる
		if(ind==t.length){
			id = 0;
			s = exs.get(k).str[0];
			double ex1 = exp();
			if(ex1==1<<28)return false;
			id = 0;
			s = exs.get(k).str[1];
			double ex2 = exp();
			if(ex2==1<<28)return false;
			//両辺が等しいとき、次の等式の評価に進む
			if(Math.abs(ex1-ex2)<1e-6)return assign(k+1);
			//等しくなかったら割り当てのやり直し
			return false;
		}
		if(!Character.isUpperCase(t[ind]))return sub(t,k,ind+1);
		int x = t[ind]-'A';
		if(ref[x]!=-1)return sub(t,k,ind+1);
		for(int i=0;i<n;i++){
			if(u[i])continue;
			u[i] = true;
			ref[x] = i;
			if(sub(t,k,ind+1))return true;
			u[i] = false;
			ref[x] = -1;
		}
		return false;
	}
	
	//k番目の等式に割り当てを行う
	boolean assign(int k){
		//全ての等式の評価が行うことができたらYes
		if(k==exs.size())return true;
		return sub(exs.get(k).s.toCharArray(), k, 0);
	}
	
	//式のid番目の文字を得る
	//s[id]がアルファベットであれば参照表であるref[]から割り当て文字を取得するようにする
	char get(){
		if(Character.isUpperCase(s[id]))return cand[ref[s[id++]-'A']];
		else return s[id++];
	}
	
	//exp()が1<<28を返す=評価不能
	double exp(){
		double res = fact();
		if(res==1<<28)return res;
		while(true){
			char c = get();
			if(c=='+'){
				double a = fact();
				if(a==1<<28)return a;
				res+=a;
			}
			else if(c=='-'){
				double a = fact();
				if(a==1<<28)return a;
				res-=a;
			}
			else break;
		}
		return res;
	}
	
	//1<<28を返す=評価不能
	double fact(){
		double res = digit();
		if(res==1<<28)return res;
		while(true){
			char c = get();
			if(c=='*'){
				double a = digit();
				if(a==1<<28)return a;
				res*=a;
			}
			else if(c=='/'){
				double a = digit();
				if(a==1<<28||a==0)return a;
				res/=a;
			}
			else break;
		}
		id--;
		return res;
	}
	
	//1<<28を返す=評価不能
	double digit(){
		double res = 0;
		char c = get();
		if(!Character.isDigit(c))return 1<<28;
		char next = get();
		if(c=='0'&&'1'<=next&&next<='9')return 1<<28;
		id--;
		while(Character.isDigit(c)){
			res = res*10 + (c-'0');
			c = get();
		}
		id--;
		return res;
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		while(true){
			int h = sc.nextInt();
			int w = sc.nextInt();
			if((h|w)==0)break;
			char[][] m = new char[h][w];
			for(int i=0;i<h;i++)m[i]=sc.next().toCharArray();
			int k = 0;
			//空白を見つけたらアルファベットで順に置換
			for(int i=0;i<h;i++)for(int j=0;j<w;j++)if(m[i][j]=='.')m[i][j]=(char)(k+++'A');
			//マップの中から評価式を見つけ出す
			exs = new ArrayList<E>();
			//まず横方向の式
			for(int i=0;i<h;i++){
				for(int j=0;j<w-1;j++){
					if(m[i][j]!='#'&&m[i][j+1]!='#'){
						StringBuilder sb = new StringBuilder();
						while(j<w&&m[i][j]!='#'){
							sb.append(m[i][j++]);
						}
						exs.add(new E(sb.toString()));
					}
				}
			}
			//縦方向の式
			for(int j=0;j<w;j++){
				for(int i=0;i<h-1;i++){
					if(m[i][j]!='#'&&m[i+1][j]!='#'){
						StringBuilder sb = new StringBuilder();
						while(i<h&&m[i][j]!='#'){
							sb.append(m[i++][j]);
						}
						exs.add(new E(sb.toString()));
					}
				}
			}
			//空白の個数によるソート
			Collections.sort(exs);
			n = sc.nextInt();
			cand = new char[n];
			for(int i=0;i<n;i++)cand[i]=sc.next().charAt(0);
			ref = new int[n];
			//ref[i]: -1ならアルファベット(i+'A')に対して割り当て未定義。それ以外ならcand[ref[i]]が割り当て文字
			Arrays.fill(ref, -1);
			u = new boolean[n];
			System.out.println(assign(0)?"Yes":"No");
		}
	}
	
	public static void main(String[] args) {
		new AOJ1022().run();
	}
}
