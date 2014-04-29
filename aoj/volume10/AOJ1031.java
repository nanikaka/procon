package volume10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Simple GUI Application
public class AOJ1031 {

	class E{
		String name;
		int x1, y1, x2, y2;
		List<E> adj;
		public E(String name, int x1, int y1, int x2, int y2) {
			this.name = name;
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
			adj = new ArrayList<E>();
		}
		boolean f(int x, int y){
			boolean hit =  x1<=x&&x<=x2&&y1<=y&&y<=y2;
			if(!hit)return hit;
			boolean here = true;
			for(E e:adj)if(e.f(x, y))here = false;
			if(!here)return true;
			System.out.println(name+" "+adj.size());
			return true;
		}
	}
	
	char[] s;
	int id;
	
	char get(){
		return s[id++];
	}
	
	E tag(){
		StringBuilder sb = new StringBuilder();
		char ch = get();
		while(ch!='>'){
			sb.append(ch);
			ch = get();
		}
		E r = new E(sb.toString(), val(), val(), val(), val());
		ch = get();
		while(true){
			if(ch=='/')break;
			id--;
			r.adj.add(tag());
			ch = get();
		}
		while(ch!='>')ch = get();
		id++;
		return r;
	}
	
	int val(){
		int x = 0;
		char ch = get();
		while(Character.isDigit(ch)){
			x = x*10 + ch-'0';
			ch = get();
		}
		return x;
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			s = (sc.next()+"$").toCharArray();
			id = 1;
			E e = tag();
			while(n--!=0)if(!e.f(sc.nextInt(), sc.nextInt()))System.out.println("OUT OF MAIN PANEL 1");
		}
	}
	
	public static void main(String[] args) {
		new AOJ1031().run();
	}
}
