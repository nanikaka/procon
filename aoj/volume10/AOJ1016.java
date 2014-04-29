package volume10;

import java.util.PriorityQueue;
import java.util.Scanner;

//Fibonacci Sets
public class AOJ1016 {

	void run(){
		Scanner sc = new Scanner(System.in);
		int N = 1001;
		int[] f = new int[N+1];
		f[0] = 1;
		f[1] = 2;
		for(int i=2;i<=N;i++)f[i] = (f[i-1]+f[i-2])%N;
		while(sc.hasNext()){
			int v = sc.nextInt();
			int d = sc.nextInt();
			PriorityQueue<Integer> q = new PriorityQueue<Integer>();
			for(int i=1;i<=v;i++)q.add(f[i]);
			int p = q.poll();
			int c = 1;
			while(!q.isEmpty()){
				int x = q.poll();
				if(x-p>=d)c++;
				p = x;
			}
			System.out.println(c);
		}
	}
	
	public static void main(String[] args) {
		new AOJ1016().run();
	}
}
