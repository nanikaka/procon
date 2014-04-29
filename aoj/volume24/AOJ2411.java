package volume24;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

//Acceleration of Network
public class AOJ2411 {

	long[] w;
	int[] t, x;
	Map<Integer, Set<Integer>> s0 = new HashMap<Integer, Set<Integer>>(), s1 = new HashMap<Integer, Set<Integer>>(), s2 = new HashMap<Integer, Set<Integer>>();
	Map<Integer, Set<Integer>> e0 = new HashMap<Integer, Set<Integer>>(), e1 = new HashMap<Integer, Set<Integer>>(), e2 = new HashMap<Integer, Set<Integer>>();

	void reg(Map<Integer, Set<Integer>> set, int day, int id){
		if(set.containsKey(day))set.get(day).add(id);
		else{
			Set<Integer> s = new HashSet<Integer>();
			s.add(id);
			set.put(day, s);
		}
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), Q = sc.nextInt(), L = 3652425;
		w = new long[N];
		t = new int[N]; x = new int[N];
		PriorityQueue<Integer> qw = new PriorityQueue<Integer>(N+1, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return Long.signum(w[o1]-w[o2]);
			}
		});
		int[] res = new int[N];
		long[] y = new long[L+1];
		Arrays.fill(res, L+1);
		long d1 = 0, d2 = 0, dt1 = 0, dt2 = 0;
		int n0 = 0, n2 = 0;
		for(int i=0;i<N;i++){
			w[i] = sc.nextLong(); t[i] = sc.nextInt(); x[i] = sc.nextInt();
			if(w[i]==0){
				res[i] = 0;
				if(t[i]==0){
					reg(s0, 1, i);
					reg(e0, x[i]+1, i);
				}
				else if(t[i]==1){
					reg(s1, 1, i);
					reg(e1, x[i]+1, i);
				}
				else{
					reg(s2, 1, i);
					reg(e2, x[i]+1, i);
				}
			}
			else qw.add(i);
		}
		for(int i=1;i<=L;i++){
			y[i] = y[i-1]+1;
			if(s0.containsKey(i)){
				n0+=s0.get(i).size();
			}
			if(e0.containsKey(i)){
				n0-=e0.get(i).size();
			}
			y[i]+=n0;
			if(s1.containsKey(i)){
				dt1+=s1.get(i).size();
			}
			if(e1.containsKey(i)){
				dt1-=e1.get(i).size();
				for(int id:e1.get(i))d1-=x[id];
			}
			d1+=dt1;
			y[i]+=d1;
			if(s2.containsKey(i)){
				int D = s2.get(i).size();
				n2+=D;
				dt2-=D;
			}
			if(e2.containsKey(i)){
				int D = e2.get(i).size();
				for(int id:e2.get(i)){
					dt2-=2*x[id]-1;
					d2-=x[id]*x[id];
				}
				n2-=D;
			}
			dt2+=2*n2;
			d2+=dt2;
			y[i]+=d2;
			while(!qw.isEmpty() && w[qw.peek()]<=y[i]){
				int id = qw.poll();
				res[id] = i;
				if(t[id]==0){
					reg(s0, i+1, id);
					reg(e0, i+x[id]+1, id);
				}
				else if(t[id]==1){
					reg(s1, i+1, id);
					reg(e1, i+x[id]+1, id);
				}
				else{
					reg(s2, i+1, id);
					reg(e2, i+x[id]+1, id);
				}
			}
		}
		for(int i=0;i<N;i++)System.out.println(L<res[i]?"Many years later":res[i]);
		while(Q--!=0)System.out.println(y[sc.nextInt()]);
	}
	
	public static void main(String[] args) {
		new AOJ2411().run();
	}
}
