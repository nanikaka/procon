package volume12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Pathological Paths
public class AOJ1251 {

	class F{
		int id;
		String name;
		public F(int id, String name) {
			this.id = id;
			this.name = name;
		}
	}
	
	class D{
		String name;
		D parent;
		List<D> dir;
		List<F> file;
		public D(String name, D parent) {
			this.name = name;
			this.parent = parent;
			dir = new ArrayList<D>();
			file = new ArrayList<F>();
		}
		void add(String[] s, int d, int id){
			if(s.length-1==d){
				file.add(new F(id, s[d])); return;
			}
			for(D v:dir){
				if(v.name.equals(s[d])){
					v.add(s, d+1, id); return;
				}
			}
			D v = new D(s[d], this);
			dir.add(v);
			v.add(s, d+1, id);
		}
		int find(String[] s, int d){
			//最後のパス名
			if(d==s.length-1){
				//カレントディレクトリのindex.htmlを指している
				if("".equals(s[d])||".".equals(s[d])){
					for(F f:file){
						if("index.html".equals(f.name))return f.id;
					}
					return -1;
				}
				//親のindex.htmlを指している
				else if("..".equals(s[d])){
					if(parent==null)return -1;
					for(F f:parent.file){
						if("index.html".equals(f.name))return f.id;
					}
					return -1;
				}
				//カレントディレクトリのFileを検索
				for(F f:file){
					if(s[d].equals(f.name))return f.id;
				}
				//ディレクトリの検索
				for(D v:dir){
					if(s[d].equals(v.name)){
						//見つかったらその中にindex.htmlがあるか
						for(F f:v.file){
							if("index.html".equals(f.name))return f.id;
						}
					}
				}
				return -1;
			}
			//カレントディレクトリは変わらない
			if(".".equals(s[d]))return find(s, d+1);
			//親ディレクトリに処理を任せる
			if("..".equals(s[d])){
				if(parent==null)return -1;
				return parent.find(s, d+1);
			}
			//ディレクトリを検索する
			for(D v:dir){
				if(v.name.equals(s[d])){
					return v.find(s, d+1);
				}
			}
			return -1;
		}
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			int n = sc.nextInt(), m = sc.nextInt();
			if((n|m)==0)break;
			D root = new D("", null);
			while(n--!=0){
				root.add(sc.next().split("/"), 1, n);
			}
			while(m--!=0){
				String s = sc.next();
				boolean f = false;
				// /.../で終わっている場合でもs[0]="", s[1]=... s[2]=""とさせるための小細工
				if(s.charAt(s.length()-1)=='/'){
					s+=" "; f = true;
				}
				String[] t = s.split("/");
				if(f)t[t.length-1] = "";
				int a = root.find(t, 1);
				s = sc.next();
				f = false;
				if(s.charAt(s.length()-1)=='/'){
					s+=" ";
					f = true;
				}
				t = s.split("/");
				if(f)t[t.length-1] = "";
				int b = root.find(t, 1);
				System.out.println(a==-1||b==-1?"not found":a==b?"yes":"no");
			}
		}
	}
	
	public static void main(String[] args) {
		new AOJ1251().run();
	}
}
