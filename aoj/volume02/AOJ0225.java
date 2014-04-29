package volume02;

import java.util.Scanner;

//Kobutanukitsuneko
public class AOJ0225 {

	static class N{
		int id, ind, outd;
		boolean v;
		public N(int id) {
			this.id = id;
			v = true;
		}
		public void visit(){
			v = true;
			for(int i=0;i<26;i++){
				if(e[id][i]&&!node[i].v)node[i].visit();
			}
		}
	}
	
	static N[] node;
	static boolean[][] e;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			node = new N[26];
			for(int i=0;i<26;i++)node[i]=new N(i);
			e = new boolean[26][26];
			for(int i=0;i<n;i++){
				char[] s = sc.next().toCharArray();
				int f = s[0]-'a';
				int t = s[s.length-1]-'a';
				node[f].outd++;
				node[t].ind++;
				node[f].v = node[t].v = false;
				e[f][t] = true;
			}
			boolean f = true;
			for(int i=0;i<26;i++){
				if(node[i].ind!=node[i].outd){
					f = false;
					break;
				}
			}
			if(f){
				for(int i=0;i<26;i++){
					if(!node[i].v){
						node[i].visit();
						break;
					}
				}
				for(int i=0;i<26;i++){
					if(!node[i].v)f = false;
				}
			}
			System.out.println(f?"OK":"NG");
		}
	}
}
