package volume22;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Stopping Problem
public class AOJ2262 {

	boolean[][][][] u;
	int r, c;
	int[][] move = {{-1,0},{0,1},{1,0},{0,-1}};

	int ni(int i, int d){
		return (i+move[d][0]+r)%r;
	}
	int nj(int j, int d){
		return (j+move[d][1]+c)%c;
	}
	
	
	void add(int i, int j, int m, int d, List<int[]> l){
		if(!u[i][j][m][d]){
			u[i][j][m][d] = true;
			l.add(new int[]{i,j,m,d});
		}
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		char[][] m = new char[r][c];
		for(int i=0;i<r;i++)m[i]=sc.next().toCharArray();
		u = new boolean[r][c][16][4];
		boolean g = false;
		List<int[]> l = new ArrayList<int[]>();
		l.add(new int[]{0,0,0,1});
		u[0][0][0][1] = true;
		while(!g&&!l.isEmpty()){
			List<int[]> next = new ArrayList<int[]>();
			for(int a[]:l){
				int i = a[0];
				int j = a[1];
				int mem = a[2];
				int dir = a[3];
				char ch = m[i][j];
				if(ch=='<'){
					add(ni(i,3),nj(j,3),mem,3,next);
				}
				else if(ch=='>'){
					add(ni(i,1),nj(j,1),mem,1,next);
				}
				else if(ch=='^'){
					add(ni(i,0),nj(j,0),mem,0,next);
				}
				else if(ch=='v'){
					add(ni(i,2),nj(j,2),mem,2,next);
				}
				else if(ch=='_'){
					if(mem==0)add(ni(i,1),nj(j,1),mem,1,next);
					else add(ni(i,3),nj(j,3),mem,3,next);
				}
				else if(ch=='|'){
					if(mem==0)add(ni(i,2),nj(j,2),mem,2,next);
					else add(ni(i,0),nj(j,0),mem,0,next);
				}
				else if(ch=='?'){
					add(ni(i,3),nj(j,3),mem,3,next);
					add(ni(i,1),nj(j,1),mem,1,next);
					add(ni(i,0),nj(j,0),mem,0,next);
					add(ni(i,2),nj(j,2),mem,2,next);
				}
				else if(ch=='@'){
					g = true;
					break;
				}
				else if(ch=='+'){
					add(ni(i,dir),nj(j,dir),(mem+1)%16,dir,next);
				}
				else if(ch=='-'){
					add(ni(i,dir),nj(j,dir),(mem+15)%16,dir,next);
				}
				else if(Character.isDigit(ch)){
					add(ni(i,dir),nj(j,dir),ch-'0',dir,next);
				}
				else {
					add(ni(i,dir),nj(j,dir),mem,dir,next);
				}
			}
			l = next;
		}
		System.out.println(g?"YES":"NO");
	}
	
	public static void main(String[] args) {
		new AOJ2262().run();
	}
}
