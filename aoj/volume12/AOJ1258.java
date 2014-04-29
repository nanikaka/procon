package volume12;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

//Book Replacement
public class AOJ1258 {

	@SuppressWarnings("unchecked")
	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			int m = sc.nextInt(), c = sc.nextInt(), n = sc.nextInt();
			if((m|c|n)==0)break;
			int[] k = new int[n];
			int[][] req = new int[n][50];
			for(int i=0;i<n;i++){
				k[i] = sc.nextInt();
				for(int j=0;j<k[i];j++)req[i][j]=sc.nextInt();
			}
			Queue<Integer> D1 = new LinkedList<Integer>();
			Set<Integer>[] d = new Set[m+1];
			for(int i=2;i<=m;i++)d[i]=new HashSet<Integer>();
			int res = 0;
			for(int j=0;j<50;j++)for(int i=0;i<n;i++){
				if(k[i]<=j)continue;
				int r = req[i][j];
				if(D1.contains(r)){
					res += 2; D1.remove(r); D1.add(r);
					continue;
				}
				boolean shelf = true;
				for(int a=2;a<=m;a++){
					if(d[a].contains(r)){
						shelf = false;
						d[a].remove(r); res+=a;
						break;
					}
				}
				if(shelf)res+=m+1;
				if(D1.size()<c){
					res+=1; D1.add(r);
					continue;
				}
				int pos = -1;
				for(int a=2;a<=m;a++){
					if(d[a].size()<c){
						pos = a; res+=a; d[a].add(r); break;
					}
				}
				if(pos==-1)res+=m+1;
				int old = D1.poll();
				res+=1;
				shelf = true;
				for(int a=2;a<=m;a++){
					if(d[a].size()<c){
						shelf = false;
						d[a].add(old); res+=a;
						break;
					}
				}
				if(shelf)res+=m+1;
				if(pos!=-1){
					d[pos].remove(r); res+=pos;
				}
				else res+=m+1;
				D1.add(r); res+=1;
			}
			System.out.println(res);
		}
	}
	
	public static void main(String[] args) {
		new AOJ1258().run();
	}
}
