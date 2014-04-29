package volume02;

import java.util.Arrays;
import java.util.Scanner;

//Sergeant Rian
public class AOJ0235 {
  
	class N{
		int id, go, back, order, parent;
		boolean leaf;
		boolean[] child;
		public N(int id) {
			this.id = id;
			parent = -1;
			child = new boolean[n+1];
		}
		public void f(){
			leaf = true;
			for(int i=1;i<=n;i++){
				if(t[id][i]==1<<29||parent==i)continue;
				node[i].parent = id;
				child[i] = true;
				leaf = false;
				node[i].f();
			}
			order = visit++;
		}
		public void calc(){
			int min = 1<<29;
			for(int i=1;i<=n;i++){
				if(!child[i]||node[i].leaf||parent==i)continue;
				int cost = t[id][i] + node[i].go;
				for(int j=1;j<=n;j++){
					if(!child[j]||i==j||parent==j||node[j].leaf)continue;
					cost += t[id][j]*2 + node[j].back;
				}
				min = Math.min(min, cost);
			}
			if(min!=1<<29)go = min;
			else go = 0;
			for(int i=1;i<=n;i++){
				if(!child[i]||node[i].leaf||parent==i)continue;
				back += t[id][i]*2 + node[i].back;
			}
		}
	}
	
	int n, visit;
	N[] node;
	int[][] t;
	
	void run(){
		Scanner sc = new Scanner(System.in);
		while(true){
			n = sc.nextInt();
			if(n==0)break;
			node = new N[n+1];
			t = new int[n+1][n+1];
			for(int []a:t)Arrays.fill(a, 1<<29);
			for(int i=1;i<=n;i++)node[i]=new N(i);
			for(int i=0;i<n-1;i++){
				int a = sc.nextInt();
				int b = sc.nextInt();
				int c = sc.nextInt();
				t[a][b] = t[b][a] = c;
			}
			visit = 0;
			node[1].f();
			for(int o=0;o<n;o++)for(int i=1;i<=n;i++)if(node[i].order==o)node[i].calc();
			System.out.println(node[1].go);
		}
	}
	
	public static void main(String[] args) {
		new AOJ0235().run();
	}
}
