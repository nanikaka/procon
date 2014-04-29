package volume10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Dominating Set
public class AOJ1015 {

	int n, m, res, INF = 1<<29;
	List<Integer>[] adj;
	int[] cover;
	boolean[] special;
	
	void f(int k, int num){
		if(res <= num)return;
		if(k==n){
			boolean ok = true;
			for(int i=0;i<n&&ok;i++)ok&=cover[i]!=0;
			if(ok)res = Math.min(res, num);
			return;
		}
		//スペシャルマークがついている場所は振る舞いが決定している
		if(special[k]){
			f(k+1, num); return;
		}
		//[0, k)の頂点に、「カバーされていない && 隣接点が全てk未満」 なものがあった場合、もう支配集合は作れないので枝刈り
		for(int i=0;i<k;i++)if(cover[i]==0){
			boolean e = false;
			for(int x:adj[i])if(k<=x){
				e = true; break;
			}
			if(!e)return;
		}
		//kの頂点を採用する場合としない場合で枝分かれする
		//試す順番を分けている
		//kの頂点がカバーされていない OR 隣接点が多い(適当にn/5個以上とした)場合は取った方が得そうなので、kを採用する場合を先に試している
		if(cover[k]==0 || n/5 <= adj[k].size()){
			cover[k]++;
			for(int x:adj[k])cover[x]++;
			f(k+1, num+1);
			cover[k]--;
			for(int x:adj[k])cover[x]--;
			f(k+1, num);
		}
		else{
			f(k+1, num);
			cover[k]++;
			for(int x:adj[k])cover[x]++;
			f(k+1, num+1);
			cover[k]--;
			for(int x:adj[k])cover[x]--;
		}
	}
	
	@SuppressWarnings("unchecked")
	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			n = sc.nextInt(); m = sc.nextInt();
			if((n|m)==0)break;
			adj = new List[n];
			for(int i=0;i<n;i++)adj[i]=new ArrayList<Integer>();
			while(m--!=0){
				int s = sc.nextInt(), t = sc.nextInt();
				adj[s].add(t); adj[t].add(s);
			}
			cover = new int[n];
			special = new boolean[n];
			res = INF;
			int c = 0;
			for(int i=0;i<n;i++){
				if(adj[i].isEmpty()){
					c++;
					cover[i]++;
					special[i] = true;
					continue;
				}
				boolean f = false;
				for(int x:adj[i])if(adj[x].size()==1 && !special[x]){
					f = true; break;
				}
				if(f){
					c++;
					special[i] = true;
					cover[i]++;
					for(int x:adj[i])cover[x]++;
				}
			}
			f(0, c);
			System.out.println(res);
		}
	}
	
	public static void main(String[] args) {
		new AOJ1015().run();
	}
}
