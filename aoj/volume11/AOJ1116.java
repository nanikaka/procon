package volume11;

import java.util.Scanner;

//Jigsaw Puzzles for Computers
public class AOJ1116 {

	int trans(char ch){
		return ch=='R'?1:
			ch=='r'?-1:
			ch=='G'?2:
			ch=='g'?-2:
			ch=='B'?3:
			ch=='b'?-3:
			ch=='W'?4:-4;	
	}
	
	class R{
		int a[], top;
		public R(int[] a, int top) {
			this.a = a;
			this.top = top;
		}
	}
	
	R[][] assign;
	boolean[] u;
	int c;
	R[][] piece;
	
	void dfs(int k){
		if(k==9){
			c++;return;
		}
		int i=k/3;
		int j=k%3;
		for(int use=0;use<9;use++){
			if(u[use])continue;
			for(int d=0;d<4;d++){
				R r = piece[use][d];
				if(i>0){
					R up = assign[i-1][j];
					if(r.a[r.top]+up.a[(up.top+2)%4]!=0)continue;
				}
				if(j>0){
					R left = assign[i][j-1];
					if(r.a[(r.top+3)%4]+left.a[(left.top+1)%4]!=0)continue;
				}
				u[use] = true;
				assign[i][j] = r;
				dfs(k+1);
				u[use] = false;
			}
		}
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		while(N--!=0){
			piece = new R[9][4];
			for(int i=0;i<9;i++){
				char[] s = sc.next().toCharArray();
				int[] a = new int[4];
				for(int j=0;j<4;j++)a[j]=trans(s[j]);
				for(int j=0;j<4;j++)piece[i][j]=new R(a, j);
			}
			c = 0;
			u = new boolean[9];
			assign = new R[3][3];
			dfs(0);
			System.out.println(c);
		}
	}
	
	public static void main(String[] args) {
		new AOJ1116().run();
	}
}
