package volume24;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//The Enemy of My Enemy is My Friend
public class AOJ2403 {

	Map<String, Integer> ref;
	int ID;
	int reg(String s){
		if(ref.containsKey(s))return ref.get(s);
		ref.put(s, ID);
		return ID++;
	}
	
	int N, res;
	int[] sum, B;
	long[] adj;
	
	void f(int k, int score, long mask){
		res = Math.max(res, score);
		if(k==N)return;
		if(score+sum[k]<=res)return;
		if(((mask>>k)&1)==0)f(k+1, score+B[k], mask|adj[k]);
		f(k+1, score, mask);
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			N = sc.nextInt();
			if(N==0)break;
			ref = new HashMap<String, Integer>();
			ID = 0;
			adj = new long[N];
			B = new int[N];
			for(int i=0;i<N;i++){
				int id = reg(sc.next());
				B[id] = sc.nextInt();
				int m = sc.nextInt();
				while(m--!=0)adj[id]+=1L<<reg(sc.next());
			}
			sum = new int[N+1];
			for(int i=N-1;i>=0;i--)sum[i]=sum[i+1]+B[i];
			res = 0;
			f(1, B[0], adj[0]);
			System.out.println(res);
		}
	}

	public static void main(String[] args) {
		new AOJ2403().run();
	}
}
