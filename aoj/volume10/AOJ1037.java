package volume10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Midnight Teatime
public class AOJ1037 {

	class R{
		int id, x;
		char ch;
		R l, r;
		boolean leaf;
		public R(int id, boolean leaf) {
			this.id = id;
			this.leaf = leaf;
			l = r = null;
			x = 0;
		}
		int get(){
			if(leaf)return x;
			if(ch=='A')return l.get()&r.get();
			else if(ch=='O')return l.get()|r.get();
			else return l.get()^r.get();
		}
	}
	
	int ID, c;
	R[] v;
	R root;
	List<R> leafs;
	
	char[] s;
	int id;
	char get(){
		return s[id++];
	}
	
	R exp(){
		char ch = get();
		if(ch!='('){
			int x = ch-'0';
			R res = new R(x, true);
			leafs.add(res);
			return res;
		}
		R res = new R(ID, false);
		v[ID++] = res;
		res.l = exp();
		get();
		res.r = exp();
		get();
		return res;
	}
	
	void dfs(int k){
		if(k==ID){
			int x = root.get();
			if(x==15)c++;
			return;
		}
		v[k].ch = 'A'; dfs(k+1);
		v[k].ch = 'O'; dfs(k+1);
		v[k].ch = 'X'; dfs(k+1);
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			s = (sc.nextLine()+"$").toCharArray();
			if(s[0]=='E')break;
			id = 0;
			v = new R[8];
			leafs = new ArrayList<R>();
			ID = 0;
			root = exp();
			int n = sc.nextInt();
			for(int i=1;i<=n;i++){
				int x = 0;
				for(int j=0;j<4;j++){
					x += sc.nextInt()<<j;
				}
				for(R r:leafs)if(r.id==i)r.x = x;
			}
			sc.nextLine();
			c = 0;
			dfs(0);
			System.out.println(c);
		}
	}
	
	public static void main(String[] args) {
		new AOJ1037().run();
	}
}
