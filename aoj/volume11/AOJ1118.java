package volume11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//Nets of Dice
public class AOJ1118 {

	int[][][] dice = {
			{{1,0,0,0},
			 {2,3,2,3},
			 {1,0,0,0}},
			{{1,0,0,0},
			 {2,3,2,3},
			 {0,1,0,0}},
			{{1,0,0,0},
			 {2,3,2,3},
			 {0,0,1,0}},
			{{1,0,0,0},
			 {2,3,2,3},
			 {0,0,0,1}},
			{{0,1,0,0},
			 {2,3,2,3},
			 {0,1,0,0}},
			{{0,1,0,0},
			 {2,3,2,3},
			 {0,0,1,0}},
			{{1,2,1,0,0},
			 {0,0,3,2,3}},
			{{1,2,0,0},
			 {0,3,1,3},
			 {0,2,0,0}},
			{{1,2,0,0},
			 {0,3,1,3},
			 {0,0,2,0}},
			{{1,2,0,0},
			 {0,3,1,3},
			 {0,0,0,2}},
			{{1,2,0,0},
			 {0,3,1,0},
			 {0,0,2,3}}
	};
	
	int[][] rot(int[][] a){
		int h = a.length, w = a[0].length;
		int[][] res = new int[w][h];
		for(int i=0;i<h;i++)for(int j=0;j<w;j++)res[j][i]=a[i][w-j-1];
		return res;
	}
	int[][] mirror(int[][] a){
		int h = a.length, w = a[0].length;
		int[][] res = new int[h][w];
		for(int i=0;i<h;i++)for(int j=0;j<w;j++)res[i][j]=a[i][w-j-1];
		return res;
	}
	
	void run(){
		List<int[][]> l = new ArrayList<int[][]>();
		for(int k=0;k<4;k++)for(int i=0;i<11;i++){
			l.add(dice[i]);
			l.add(mirror(dice[i]));
			dice[i] = rot(dice[i]);
		}
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while(n--!=0){
			int[][] a = new int[5][5];
			int c = 0, sum = 0;
			for(int i=0;i<5;i++)for(int j=0;j<5;j++){
				a[i][j]=sc.nextInt();
				if(a[i][j]!=0){
					c++; sum+=1<<(a[i][j]-1);
				}
			}
			if(c!=6||sum!=63){
				System.out.println(false); continue;
			}
			boolean res = false;
			int[] add = new int[4];
			for(int[][] b:l){
				int h = b.length, w = b[0].length;
				for(int i=0;i+h<=5;i++)for(int j=0;j+w<=5;j++){
					Arrays.fill(add, 0);
					boolean match = true;
					for(int y=0;y<h;y++)for(int x=0;x<w;x++){
						if(b[y][x]==0&&a[i+y][j+x]!=0 || b[y][x]!=0&&a[i+y][j+x]==0)match=false;
						add[b[y][x]]+=a[i+y][j+x];
					}
					if(match&&add[1]==7&&add[2]==7&&add[3]==7)res = true;
				}
			}
			System.out.println(res);
		}
	}
	
	public static void main(String[] args) {
		new AOJ1118().run();
	}
}
