package volume05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

//String With Rings
public class AOJ0508 {

	List<Integer>[] e;
	int res;
	boolean[] v;
	
	void dfs(int k, int d){
		res = Math.max(res, d);
		for(int x:e[k])if(!v[x]){
			v[x] = true;
			dfs(x, d+1);
			v[x] = false;
		}
	}
	
	@SuppressWarnings("unchecked")
	void run(){
		Scanner sc = new Scanner(System.in);
		Random rand = new Random(1334259345907L);
		for(;;){
			int n = sc.nextInt();
			if(n==0)break;
			e = new List[101];
			for(int i=1;i<101;i++)e[i]=new ArrayList<Integer>();
			boolean[] u = new boolean[101];
			while(n--!=0){
				int a = sc.nextInt(), b = sc.nextInt();
				u[a] = u[b] = true;
				e[a].add(b); e[b].add(a);
			}
			v = new boolean[101];
			res = 0;
			int[] a = new int[100];
			int id = 0;
			for(int i=1;i<101;i++)if(!e[i].isEmpty())a[id++] = i;
			//開始点を全部試すとつらいからN/3個だけランダムにチョイスして絞るという迷走っぷり
			for(int i=0;i<=id/3;i++){
				Arrays.fill(v, false);
				int s = rand.nextInt(id);
				v[a[s]] = true;
				dfs(a[s], 1);
			}
			System.out.println(res);
		}
	}

	public static void main(String[] args) {
		new AOJ0508().run();
	}
}
