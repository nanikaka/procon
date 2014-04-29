package volume13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

//Towns along a Highway
public class AOJ1307 {
	
	int n;
	int[] rs;
	int[][] a;
	int[] p, c;
	Set<String> res;
	Set<String> v;
	
	boolean check(){
		String k = trans(p);
		if(v.contains(k))return false;
		v.add(k);
		return true;
	}
	
	void dfs(int k, int l, int r){
		if(k<0){
			res.add(trans(p)); return;
		}
		if(c[k]==0){
			dfs(k-1, l, r); return;
		}
		if(!check())return;
		int d = k;
		if(p[0]==-1){
			a[0][n-1]=a[n-1][0]=d;
			p[0] = 0; p[n-1] = d; c[d]--; dfs(k, l+1, r-1);
			p[0] = d; p[n-1] = 0; dfs(k, l+1, r-1); c[d]++;
			return;
		}
		for(int i=0;i<n;i++){
			if(p[i]!=-1||(i!=l&&i!=r))continue;
			for(int j=0;j<n;j++){
				if(p[j]==-1)continue;
				int pos = p[j]-d;
				if(0<=pos&&pos<=400){
					boolean ok = true;
					for(int m=0;m<n;m++){
						if(p[m]==-1)continue;
						int dif = Math.abs(p[m]-pos);
						a[i][m]=a[m][i]=dif;
						c[dif]--;
						if(c[dif]<0)ok = false;
					}
					if(ok){
						boolean f = i==l;
						p[i] = pos; dfs(k, f?l+1:l, f?r:r-1); p[i] = -1;
					}
					for(int m=0;m<n;m++){
						if(p[m]==-1)continue;
						int dif = Math.abs(p[m]-pos);
						a[i][m]=a[m][i]=-1;
						c[dif]++;
					}
				}
				pos = p[j]+d;
				if(0<=pos&&pos<=400){
					boolean ok = true;
					for(int m=0;m<n;m++){
						if(p[m]==-1)continue;
						int dif = Math.abs(p[m]-pos);
						a[i][m]=a[m][i]=dif;
						c[dif]--;
						if(c[dif]<0)ok = false;
					}
					if(ok){
						boolean f = i==l;
						p[i] = pos; dfs(k, f?l+1:l, f?r:r-1); p[i] = -1;
					}
					for(int m=0;m<n;m++){
						if(p[m]==-1)continue;
						int dif = Math.abs(p[m]-pos);
						a[i][m]=a[m][i]=-1;
						c[dif]++;
					}
				}
			}
		}
	}
	
	String trans(int[] p){
		String r = "";
		int[] t = p.clone();
		Arrays.sort(t);
		for(int i=1;i<n;i++)r+=String.format("%03d", t[i]-t[i-1]);
		return r;
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			n = sc.nextInt();
			if(n==0)break;
			a = new int[n][n];
			v = new HashSet<String>();
			for(int[]b:a)Arrays.fill(b, -1);
			c = new int[401];
			rs = new int[n*(n-1)/2];
			int k = 0;
			for(int i=0;i<n;i++)for(int j=i+1;j<n;j++){
				int d = sc.nextInt();
				rs[k++] = d;
				c[d]++;
			}
			p = new int[n];
			Arrays.fill(p, -1);
			res = new HashSet<String>();
			dfs(400, 0, n-1);
			PriorityQueue<String> q = new PriorityQueue<String>();
			for(String t:res)q.add(t);
			while(!q.isEmpty()){
				String t = q.poll();
				List<Integer> l = new ArrayList<Integer>();
				for(int i=0;i<t.length();i+=3)l.add(Integer.parseInt(t.substring(i, i+3)));
				for(int i=0;i<l.size();i++)System.out.print(l.get(i)+(i==l.size()-1?"\n":" "));
			}
			System.out.println("-----");
		}
	}
	
	public static void main(String[] args) {
		new AOJ1307().run();
	}
}
