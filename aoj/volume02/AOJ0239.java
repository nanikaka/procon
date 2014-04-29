package volume02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Calorie Counting
public class AOJ0239 {

	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			int n = sc.nextInt();
			if(n==0)break;
			int[] id = new int[n], p = new int[n], q = new int[n], r = new int[n];
			for(int i=0;i<n;i++){
				id[i] = sc.nextInt();
				p[i] = sc.nextInt();
				q[i] = sc.nextInt();
				r[i] = sc.nextInt();
			}
			List<Integer> l = new ArrayList<Integer>();
			int P = sc.nextInt(), Q = sc.nextInt(), R = sc.nextInt(), C = sc.nextInt();
			for(int i=0;i<n;i++){
				if(p[i]<=P && q[i]<=Q && r[i]<=R && p[i]*4+q[i]*9+r[i]*4<=C)l.add(id[i]);
			}
			if(l.isEmpty())System.out.println("NA");
			else for(int x:l)System.out.println(x);
		}
	}
	
	public static void main(String[] args) {
		new AOJ0239().run();
	}
}
