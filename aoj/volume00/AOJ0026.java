package volume0;

import java.util.Scanner;

//Dropping Ink
public class AOJ0026 {

	public static int[][] map;
	public static boolean[][] used;
	public static int[][] move = {{0,1},{1,0},{-1,0},{0,-1}};
	public static int[][] move2 = {{1,1},{1,-1},{-1,1},{-1,-1}};
	public static int dx;
	public static int dy;
	public static int d;
	
	public static void f(int x, int y, int z){
		if(!(0<=x&&x<10&&0<=y&&y<10))return;
		if(Math.abs(dx-x)+Math.abs(dy-y)>z)return;
		if(used[x][y])return;
		map[x][y]++;
		used[x][y] = true;
		for(int k=0;k<4;k++){
			f(x+move[k][0], y+move[k][1], z);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		map = new int[10][10];
		while(sc.hasNext()){
			String[] s = sc.next().split(",");
			dx = Integer.parseInt(s[0]);
			dy = Integer.parseInt(s[1]);
			d = Integer.parseInt(s[2]);
			used = new boolean[10][10];
			f(dx, dy, (d==3?2:1));
			if(d==2){
				for(int k=0;k<4;k++){
					int x = dx+move2[k][0];
					int y = dy+move2[k][1];
					if(0<=x&&x<10&&0<=y&&y<10)map[x][y]++;
				}
			}
		}
		int c = 0;
		int max = 0;
		for(int x=0;x<10;x++){
			for(int y=0;y<10;y++){
				c+=map[x][y]==0?1:0;
				max = Math.max(max, map[x][y]);
			}
		}
		System.out.println(c);
		System.out.println(max);
	}
}
