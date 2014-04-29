package volume10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

//Mysterious Onslaught
public class AOJ1059 {

	int[] d;
	int res, M = (0x1f)<<20;
	List<Integer>[] mask;
	
	void f(int S, int depth, int k){
		if((S&M)==0){
			res = Math.min(res, depth+d[S]);
			return;
		}
		if(res<=depth+d[(0xfffff)&S]|| k==5)return;
		for(int m:mask[k]){
			f(S^m, depth+1, k+1);
		}
		f(S, depth, k+1);
	}
	
	@SuppressWarnings("unchecked")
	void run(){
		d = new int[1<<20];
		int INF = 1<<28;
		Arrays.fill(d, INF);
		d[0] = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(0);
		while(!q.isEmpty()){
			int S = q.poll();
			for(int i=0;i<4;i++)for(int j=0;j<5;j++)for(int h=i;h<4;h++)for(int w=j;w<5;w++){
				int ns = S;
				for(int y=i;y<=h;y++)for(int x=j;x<=w;x++)ns^=1<<(y*5+x);
				if(d[ns]==INF){
					d[ns] = d[S]+1;
					q.add(ns);
				}
			}
		}
		mask = new List[5];
		for(int j=0;j<5;j++){
			mask[j] = new ArrayList<Integer>();
			for(int h=4;h>=0;h--)for(int w=j;w<5;w++){
				int m = 0;
				for(int y=4;y>=h;y--)for(int x=j;x<=w;x++)m+=1<<(y*5+x);
				mask[j].add(m);
			}
		}
		Scanner sc = new Scanner(System.in);
		for(;;){
			int n = sc.nextInt();
			if(n==0)break;
			int x = 0;
			for(int i=0;i<n;i++)for(int j=0;j<n;j++)if(sc.nextInt()==1)x|=1<<(i*5+j);
			res = 9;
			if(n<=4)res=d[x];
			else f(x, 0, 0);
			while(res--!=0)System.out.print("myon");
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		new AOJ1059().run();
	}
}
