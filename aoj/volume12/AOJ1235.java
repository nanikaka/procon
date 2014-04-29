package volume12;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

//Life Line
public class AOJ1235 {

	class R{
		Set<Integer> s, empty;
		public R() {
			s = new HashSet<Integer>();
			empty = new HashSet<Integer>();
		}
	}
	
	int N, C, n, max;
	int[] map, depth;
	boolean[] top, bottom, left, right;
	boolean[] u;

	R bfs(int focus, int i){
		R res = new R();
		List<Integer> list = new ArrayList<Integer>();
		list.add(i);
		u[i] = true;
		while(!list.isEmpty()){
			List<Integer> next = new ArrayList<Integer>();
			for(int j:list){
				if(map[j]==0){
					res.empty.add(j); continue;
				}
				res.s.add(j);
				int d = depth[j];
				if(!top[j]&&!left[j]&&!u[j-d]&&(map[j-d]==0||map[j-d]==focus)){
					if(map[j-d]==focus)u[j-d] = true;
					next.add(j-d);
				}
				if(!top[j]&&!right[j]&&!u[j-d+1]&&(map[j-d+1]==0||map[j-d+1]==focus)){
					if(map[j-d+1]==focus)u[j-d+1] = true;
					next.add(j-d+1);
				}
				if(!left[j]&&!u[j-1]&&(map[j-1]==0||map[j-1]==focus)){
					if(map[j-1]==focus)u[j-1] = true;
					next.add(j-1);
				}
				if(!right[j]&&!u[j+1]&&(map[j+1]==0||map[j+1]==focus)){
					if(map[j+1]==focus)u[j+1] = true;
					next.add(j+1);
				}
				if(!bottom[j]&&!u[j+d]&&(map[j+d]==0||map[j+d]==focus)){
					if(map[j+d]==focus)u[j+d] = true;
					next.add(j+d);
				}
				if(!bottom[j]&&!u[j+d+1]&&(map[j+d+1]==0||map[j+d+1]==focus)){
					if(map[j+d+1]==focus)u[j+d+1] = true;
					next.add(j+d+1);
				}
			}
			list = next;
		}
		return res;
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			N = sc.nextInt(); C = sc.nextInt();
			if((N|C)==0)break;
			n = N*(N+1)/2;
			map = new int[n]; depth = new int[n];
			top = new boolean[n]; bottom = new boolean[n]; left = new boolean[n]; right = new boolean[n];
			int d = 1, k = 0;
			for(int i=0;i<n;i++){
				map[i] = sc.nextInt();
				depth[i] = d;
				top[i] = d==1; bottom[i] = d==N;
				left[i] = k==0; right[i] = k==d-1;
				k++;
				if(k==d){
					k = 0; d++;
				}
			}
			u = new boolean[n];
			List<R> l = new ArrayList<R>();
			for(int i=0;i<n;i++){
				if(u[i]||map[i]==C||map[i]==0)continue;
				l.add(bfs(map[i], i));
			}
			int max = -n;
			for(int i=0;i<n;i++){
				if(map[i]!=0)continue;
				map[i] = C;
				List<R> mine = new ArrayList<R>();
				u = new boolean[n];
				for(int j=0;j<n;j++){
					if(u[j]||map[j]!=C)continue;
					mine.add(bfs(C, j));
				}
				int p = 0;
				for(R r:l)if(r.empty.size()==1&&r.empty.contains(i))p+=r.s.size();
				for(R r:mine)if(r.empty.isEmpty())p-=r.s.size();
				max = Math.max(max, p);
				map[i] = 0;
			}
			System.out.println(max);
		}
	}
	
	public static void main(String[] args) {
		new AOJ1235().run();
	}
}
