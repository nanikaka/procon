package volume24;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

//You Are the Judge
public class AOJ2400 {

	int[][] wrong;
	int[] penalty, solve;
	
	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			int T = sc.nextInt(), P = sc.nextInt(), R = sc.nextInt();
			if((T|P|R)==0)break;
			solve = new int[T];
			wrong = new int[T][P+1];
			penalty = new int[T];
			while(R--!=0){
				int t = sc.nextInt()-1, p = sc.nextInt(), time = sc.nextInt();
				String m = sc.next();
				if("WRONG".equals(m))wrong[t][p]++;
				else{
					penalty[t]+=wrong[t][p]*1200+time;
					solve[t]++;
				}
			}
			PriorityQueue<Integer> q = new PriorityQueue<Integer>(T, new Comparator<Integer>() {
				public int compare(Integer o1, Integer o2) {
					return solve[o2]!=solve[o1]?solve[o2]-solve[o1]:penalty[o1]!=penalty[o2]?penalty[o1]-penalty[o2]:o1-o2;
				}
			});
			for(int i=0;i<T;i++)q.add(i);
			while(!q.isEmpty()){
				int id = q.poll();
				System.out.println((id+1)+" "+solve[id]+" "+penalty[id]);
			}
		}
	}
	
	public static void main(String[] args) {
		new AOJ2400().run();
	}
}
