package volume12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

//Map of Ninja House
public class AOJ1236 {

	class R{
		int id, door;
		List<Integer> adj;
		public R(int id, int door) {
			this.id = id;
			this.door = door;
			adj = new ArrayList<Integer>();
		}
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T--!=0){
			R room[] = new R[101];
			Stack<R> v = new Stack<R>();
			int ID = 1;
			int x = sc.nextInt();
			room[ID] = new R(ID, x);
			R now = room[ID];
			v.push(room[ID]);
			ID++;
			for(;;){
				x = sc.nextInt();
				if(x==0)break;
				while(v.peek().door==0)v.pop();
				now = v.peek();
				if(x>0){
					R next = new R(ID, x);
					now.adj.add(ID); next.adj.add(now.id);
					next.door--;
					now.door--;
					room[ID] = next;
					v.push(next);
					now = next;
					ID++;
				}
				else{
					R r = v.get(v.size()-1+x);
					r.adj.add(now.id); now.adj.add(r.id);
					now.door--;
					r.door--;
				}
			}
			for(int i=1;i<ID;i++){
				System.out.print(i+" ");
				Collections.sort(room[i].adj);
				for(int j=0;j<room[i].adj.size();j++)System.out.print(room[i].adj.get(j)+(j==room[i].adj.size()-1?"\n":" "));
			}
		}
	}
	
	public static void main(String[] args) {
		new AOJ1236().run();
	}
}
