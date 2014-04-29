package volume11;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

//Pile Up!
public class AOJ1120 {

	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			int n = sc.nextInt();
			if(n==0)break;
			Set<Integer> floor = new TreeSet<Integer>();
			LinkedList<Stack<Integer>> pile = new LinkedList<Stack<Integer>>();
			for(int i=1;i<=n;i++)floor.add(i);
			for(;;){
				int a = sc.nextInt();
				int b = sc.nextInt();
				if((a|b)==0)break;
				if(a==b)continue;
				if(b==0){
					if(floor.contains(a))continue;
					for(Stack<Integer> s:pile){
						if(s.contains(a)){
							if(s.get(0)==a)break;
							while(s.peek()!=a){
								floor.add(s.pop());
							}
							floor.add(s.pop());
							break;
						}
					}
					continue;
				}
				int ai = -1;
				int bi = -1;
				for(int i=0;i<pile.size();i++){
					if(pile.get(i).contains(a))ai = i;
					if(pile.get(i).contains(b))bi = i;
				}
				if(ai==bi&&ai!=-1){
					Stack<Integer> s = pile.get(ai);
					int aj = s.search(a);
					int bj = s.search(b);
					if(aj<bj)continue;
					while(s.peek()!=a){
						floor.add(s.pop());
					}
					floor.remove(b);
					Stack<Integer> st = new Stack<Integer>();
					st.push(b); st.push(s.pop());
					pile.add(st);
					if(s.isEmpty())pile.remove(ai);
					continue;
				}
				if(ai!=-1){
					Stack<Integer> s = pile.get(ai);
					while(s.peek()!=a)floor.add(s.pop());
					s.pop();
					if(s.isEmpty())pile.remove(ai);
					for(int i=0;i<pile.size();i++)if(pile.get(i).contains(b))bi=i;
				}
				else floor.remove(a);
				if(bi!=-1)pile.get(bi).push(a);
				else{
					Stack<Integer> st = new Stack<Integer>();
					floor.remove(b);
					st.push(b); st.push(a);
					pile.add(st);
				}
			}
			PriorityQueue<Integer> q = new PriorityQueue<Integer>();
			for(int i=0;i<floor.size();i++)q.add(1);
			for(Stack<Integer> s:pile)q.add(s.size());
			while(!q.isEmpty())System.out.println(q.poll());
			System.out.println("end");
		}
	}
	
	public static void main(String[] args) {
		new AOJ1120().run();
	}
}
