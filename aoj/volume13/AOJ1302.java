package volume13;

import java.util.Arrays;
import java.util.BitSet;
import java.util.Scanner;

//Twenty Questions
public class AOJ1302 {

	int n, m;
	int[] s;
	BitSet[] yes, no;
	int[][] mem;
	
	int f(int S, int SY){
		if(mem[S][SY]!=-1)return mem[S][SY];
		int res = m;
		BitSet bs = new BitSet(n);
		bs.set(0, n, true);
		for(int j=0;j<m;j++)if(((S>>j)&1)>0){
			if(((SY>>j)&1)>0)bs.and(yes[j]);
			else bs.and(no[j]);
		}
		if(bs.cardinality()<=1)return mem[S][SY] = 0;
		for(int j=0;j<m;j++)if(((S>>j)&1)==0){
			res = Math.min(res, Math.max(f(S|1<<j, SY|1<<j), f(S|1<<j, SY))+1);
		}
		return mem[S][SY] = res;
	}

	void run(){
		Scanner sc = new Scanner(System.in);
		mem = new int[1<<11][1<<11];
		for(;;){
			m = sc.nextInt(); n = sc.nextInt();
			if((m|n)==0)break;
			s = new int[n];
			yes = new BitSet[m];
			no = new BitSet[m];
			for(int i=0;i<m;i++){
				yes[i] = new BitSet(n);
				no[i] = new BitSet(n);
			}
			for(int i=0;i<n;i++){
				s[i] = Integer.parseInt(sc.next(), 2);
				for(int j=0;j<m;j++){
					if(((s[i]>>j)&1)==0)no[j].set(i, true);
					else yes[j].set(i, true);
				}
			}
			for(int[]m:mem)Arrays.fill(m, -1);
			System.out.println(f(0, 0));
		}
	}

	public static void main(String[] args) {
		new AOJ1302().run();
	}
}
