package volume01;

import java.util.Scanner;

//Magical Tiles
public class AOJ0104 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int h = sc.nextInt();
			int w = sc.nextInt();
			if(h==0&&w==0)break;
			boolean[][] visit = new boolean[h][w];
			char[][] map = new char[h][w];
			for(int i=0;i<h;i++)map[i]=sc.next().toCharArray();
			int x = 0;
			int y = 0;
			boolean loop = false;
			boolean goal = false;
			while(!loop && !goal){
				if(visit[y][x]){
					loop = true;
					break;
				}
				visit[y][x] = true;
				switch(map[y][x]){
				case '>': x++;break;
				case '<': x--;break;
				case '^': y--;break;
				case 'v': y++;break;
				case '.': goal = true;break;
				}
			}
			System.out.println(loop?"LOOP":x+" "+y);
		}
	}
}
