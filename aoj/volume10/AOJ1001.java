package volume10;

import java.util.Scanner;

//Binary Tree intersection And Union
public class AOJ1001 {

	public static class N{
		public N left;
		public N right;
		public N parent;
		public N() {
			left = null;
			right = null;
			parent = null;
		}
		public void copy(N v){
			if(left!=null){
				v.left = new N();
				v.left.parent = v;
				left.copy(v.left);
			}
			if(right!=null){
				v.right = new N();
				v.right.parent = v;
				right.copy(v.right);
			}
		}
		public void intersect(N v){
			if(left==null)v.left=null;
			else if(v.left!=null)left.intersect(v.left);
			if(right==null)v.right=null;
			else if(v.right!=null)right.intersect(v.right);
		}
		public void union(N v){
			if(left!=null){
				if(v.left==null){
					v.left = new N();
					v.left.parent = v;
				}
				left.union(v.left);
			}
			if(right!=null){
				if(v.right==null){
					v.right = new N();
					v.right.parent = v;
				}
				right.union(v.right);
			}
		}
		@Override
		public String toString() {
			return "("+(left==null?"":left)+","+(right==null?"":right)+")";
		}
	}

	public static int k;

	public static N f(char[] t){
		if(t[k]=='(')k++;
		N n = new N();
		if(t[k]=='('){
			N c = f(t);
			n.left = c;
			c.parent = n;
		}
		if(t[k]==',')k++;
		if(t[k]=='('){
			N c = f(t);
			n.right = c;
			c.parent = n;
		}
		if(t[k]==')'){
			k++;
		}
		return n;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			char cmd = sc.next().charAt(0);
			char[] t = sc.next().toCharArray();
			k = 0;
			N t1 = f(t);
			t = sc.next().toCharArray();
			k = 0;
			N t2 = f(t);
			N g = new N();
			t1.copy(g);
			if(cmd=='i')t2.intersect(g);
			else t2.union(g);
			System.out.println(g);
		}
	}
}
