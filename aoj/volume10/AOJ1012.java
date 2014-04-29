package volume10;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

//Operations with Finite Sets
public class AOJ1012 {

	boolean[][] set;
	boolean[] u;
	Map<Integer, Integer> ref;
	int n;
	
	char[] s;
	int id;
	char get(){
		return s[id++];
	}
	
	boolean[] exp(){
		boolean[] res = new boolean[n];
		res = fact();
		for(;;){
			char ch = get();
			boolean[] x;
			if(ch=='u'){
				x = fact();
				for(int i=0;i<n;i++)res[i]=res[i]|x[i];
			}
			else if(ch=='i'){
				x = fact();
				for(int i=0;i<n;i++)res[i]=res[i]&x[i];
			}
			else if(ch=='d'){
				x = fact();
				for(int i=0;i<n;i++)res[i]=res[i]&&!x[i];
			}
			else if(ch=='s'){
				x = fact();
				for(int i=0;i<n;i++)res[i]=res[i]^x[i];
			}
			else break;
		}
		return res;
	}
	
	boolean[] fact(){
		boolean[] res = new boolean[n];
		char ch = get();
		if(Character.isUpperCase(ch)){
			if(ch=='U'){
				Arrays.fill(res, true);
				return res;
			}
			for(int i=0;i<n;i++)res[i] = set[ch-'A'][i];
			return res;
		}
		if(ch=='('){
			return exp();
		}
		ch = s[id];
		boolean[] x;
		if(ch=='('){
			get();
			x = exp();
		}
		else x = fact();
		for(int i=0;i<n;i++)res[i]=!x[i];
		return res;
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			set = new boolean[5][500];
			u = new boolean[500];
			ref = new HashMap<Integer, Integer>();
			n = 0;
			int[] rev = new int[500];
			for(;;){
				char ch = sc.next().charAt(0);
				int k = sc.nextInt();
				if(ch=='R')break;
				while(k--!=0){
					int x = sc.nextInt();
					if(!ref.containsKey(x)){
						rev[n] = x;
						ref.put(x, n++);
					}
					set[ch-'A'][ref.get(x)] = true;
				}
			}
			s = (sc.next()+"$").toCharArray();
			id = 0;
			Arrays.fill(u, true);
			boolean[] res = exp();
			PriorityQueue<Integer> q = new PriorityQueue<Integer>();
			for(int i=0;i<n;i++)if(res[i])q.add(rev[i]);
			if(q.isEmpty())System.out.println("NULL");
			else {
				System.out.print(q.poll());
				while(!q.isEmpty())System.out.print(" "+q.poll());
				System.out.println();
			}
		}
	}
	
	public static void main(String[] args) {
		new AOJ1012().run();
	}
}
