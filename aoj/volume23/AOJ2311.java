package volume23;

import java.util.Scanner;

//Dessert Witch
public class AOJ2311 {

	char[][] s;
	int[][] d = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
	
	int[] put(int i, int j, char c){
		int[] r = new int[8];
		char foe = c=='o'?'x':'o';
		for(int k=0;k<8;k++){
			int ni = i+d[k][0], nj = j+d[k][1], len = 0;
			while(0<=ni&&ni<8&&0<=nj&&nj<8){
				if(s[ni][nj]==foe){
					len++; ni+=d[k][0]; nj+=d[k][1];
				}
				else if(s[ni][nj]==c){
					r[k] = len; break;
				}
				else break;
			}
		}
		return r;
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		s = new char[8][];
		for(int i=0;i<8;i++)s[i]=sc.next().toCharArray();
		for(;;){
			boolean f1 = false, f2 = false;
			int pi = -1, pj = -1, max = 0;
			for(int i=0;i<8;i++)for(int j=0;j<8;j++){
				if(s[i][j]!='.')continue;
				int[] r = put(i, j, 'o');
				int c = 0;
				for(int x:r)c+=x;
				if(max<c){
					max = c; pi = i; pj = j;
				}
			}
			if(max==0)f1 = true;
			else{
				s[pi][pj] = 'o';
				int[] r = put(pi, pj, 'o');
				for(int k=0;k<8;k++){
					if(r[k]==0)continue;
					int ni = pi+d[k][0], nj = pj+d[k][1];
					while(0<=ni&&ni<8&&0<=nj&&nj<8&&s[ni][nj]=='x'){
						s[ni][nj] = 'o'; ni+=d[k][0]; nj+=d[k][1];
					}
				}
			}
			max = 0;
			for(int i=7;i>=0;i--)for(int j=7;j>=0;j--){
				if(s[i][j]!='.')continue;
				int[] r = put(i, j, 'x');
				int c = 0;
				for(int x:r)c+=x;
				if(max<c){
					max = c; pi = i; pj = j;
				}
			}
			if(max==0)f2 = true;
			else{
				s[pi][pj] = 'x';
				int[] r = put(pi, pj, 'x');
				for(int k=0;k<8;k++){
					if(r[k]==0)continue;
					int ni = pi+d[k][0], nj = pj+d[k][1];
					while(0<=ni&&ni<8&&0<=nj&&nj<8&&s[ni][nj]=='o'){
						s[ni][nj] = 'x'; ni+=d[k][0]; nj+=d[k][1];
					}
				}
			}
			if(f1&&f2)break;
		}
		for(int i=0;i<8;i++)System.out.println(new String(s[i]));
	}
	
	public static void main(String[] args) {
		new AOJ2311().run();
	}
}
