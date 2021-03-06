package volume13;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//Driving an Icosahedral Rover
public class AOJ1319 {

	int[][] move = {
			{5, 13, 15},
			{14, 16, 3},
			{17, 4, 12},
			
			{20, 8, 1},
			{6, 2, 18},
			{0, 19, 7},
			
			{4, 22, 11},
			{23, 9, 5},
			{10, 3, 21},
			
			{12, 7, 24},
			{8, 25, 13},
			{26, 14, 6},
			
			{9, 28, 2},
			{29, 0, 10},
			{1, 11, 27},
			
			{32, 34, 0},
			{35, 1, 30},
			{2, 31, 33},
			
			{34, 37, 4},
			{38, 5, 35},
			{3, 33, 36},
			
			{37, 40, 8},
			{41, 6, 38},
			{7, 36, 39},
			
			{40, 43, 9},
			{44, 10, 41},
			{11, 39, 42},
			
			{43, 32, 14},
			{30, 12, 44},
			{13, 42, 31},
			
			{28, 46, 16},
			{47, 17, 29},
			{15, 27, 45},
			
			{50, 20, 17},
			{18, 15, 48},
			{16, 49, 19},
			
			{53, 23, 20},
			{21, 18, 51},
			{19, 52, 22},
			
			{56, 26, 23},
			{24, 21, 54},
			{22, 55, 25},
			
			{59, 29, 26},
			{27, 24, 57},
			{25, 58, 28},
			
			{58, 50, 32},
			{48, 30, 59},
			{31, 57, 49},
			
			{46, 53, 34},
			{51, 35, 47},
			{33, 45, 52},
			
			{49, 56, 37},
			{54, 38, 50},
			{36, 48, 55},
			
			{52, 59, 40},
			{57, 41, 53},
			{39, 51, 58},
			
			{55, 47, 43},
			{45, 44, 56},
			{42, 54, 46}
	};
	
	void run(){
		Scanner sc = new Scanner(System.in);
		int[][][] d = new int[201][201][60];
		for(int i=0;i<201;i++)for(int j=0;j<201;j++)for(int k=0;k<60;k++)d[i][j][k] = 150;
		d[100][100][0] = 0;
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[]{100, 100, 0});
		while(!q.isEmpty()){
			int[] V = q.poll();
			int x = V[0], y = V[1], s = V[2];
			if(d[x][y][s]==100)break;
			int nx = x+1, ny = y, ns = ((x+y)&1)==0?move[s][0]:move[s][1];
			if(0<=nx&&nx<=200&&0<=ny&&ny<=200&&d[x][y][s]+1 < d[nx][ny][ns]){
				d[nx][ny][ns] = d[x][y][s]+1; q.add(new int[]{nx, ny, ns});
			}
			nx = x-1; ny = y; ns = ((x+y)&1)==0?move[s][1]:move[s][0];
			if(0<=nx&&nx<=200&&0<=ny&&ny<=200&&d[x][y][s]+1 < d[nx][ny][ns]){
				d[nx][ny][ns] = d[x][y][s]+1; q.add(new int[]{nx, ny, ns});
			}
			nx = x; ny = ((x+y)&1)==0?(y+1):(y-1); ns = move[s][2];
			if(0<=nx&&nx<=200&&0<=ny&&ny<=200&&d[x][y][s]+1 < d[nx][ny][ns]){
				d[nx][ny][ns] = d[x][y][s]+1; q.add(new int[]{nx, ny, ns});
			}
		}
		for(;;){
			int x = sc.nextInt(), y = sc.nextInt(), N = sc.nextInt();
			if((x|y|N)==0)break;
			x+=100; y+=100;
			int k = 3*N;
			System.out.println(Math.min(d[x][y][k], Math.min(d[x][y][k+1], d[x][y][k+2])));
		}
	}
	
	public static void main(String[] args) {
		new AOJ1319().run();
	}
}
