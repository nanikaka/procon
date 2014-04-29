package volume0;

import java.util.Scanner;

//Path on a Grid
public class AOJ0037 {

	void run(){
		int[][] move = {{-1,0},{0,1},{1,0},{0,-1}};
		char[] ch = {'U','R','D','L'};
		Scanner sc = new Scanner(System.in);
		boolean[][] e = new boolean[25][25];
		int h = 0, t = 0;
		for(int x=0;x<9;x++){
			char[] s = sc.next().toCharArray();
			for(int j=0;j<s.length;j++){
				if(s[j]=='0')continue;
				if(t==0)e[h*5+j][h*5+j+1] = e[h*5+j+1][h*5+j] = true;
				else e[h*5+j][(h+1)*5+j] = e[(h+1)*5+j][h*5+j] = true;
			}
			if(t==1)h++;
			t=(t+1)%2;
		}
		int i=0, j=0, d=1;
		StringBuilder sb = new StringBuilder();
		boolean con = true;
		while(con){
			for(int k=3;k<=6;k++){
				int nd = (d+k)%4;
				int ni = i+move[nd][0];
				int nj = j+move[nd][1];
				if(0<=ni&&ni<5&&0<=nj&&nj<5&&e[i*5+j][ni*5+nj]){
					sb.append(ch[nd]);
					i = ni; j = nj; d = nd;
					if(i==0&&j==0)con = false;
					break;
				}
			}
		}
		System.out.println(sb);
	}
	
	public static void main(String[] args) {
		new AOJ0037().run();
	}
}
