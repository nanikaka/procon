package volume22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//The Legendary Sword
public class AOJ2284 {

	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			int w = sc.nextInt();
			int h = sc.nextInt();
			if((w|h)==0)break;
			int[][] map = new int[h][w];
			List<int[]> l = new ArrayList<int[]>();
			int[][] dist = new int[h][w];
			int gi = -1, gj = -1;
			for(int[]a:map)Arrays.fill(a, 1<<29);
			int g = 1;
			for(int i=0;i<h;i++)for(int j=0;j<w;j++){
				String s = sc.next();
				char c = s.charAt(0);
				if(c=='S'){
					l.add(new int[]{i, j});
					dist[i][j] = 0;
					map[i][j] = 0;
				}
				else if(c=='G'){
					map[i][j] = c;
					gi = i; gj = j;
				}
				else if(c=='.'){
					map[i][j] = 0;
				}
				else{
					map[i][j] = Integer.parseInt(s);
					g = Math.max(g, map[i][j]+1);
				}
			}
			map[gi][gj] = g;
			for(int x=1;x<=g;x++){
				List<int[]> next = new ArrayList<int[]>();
				for(int i=0;i<h;i++)for(int j=0;j<w;j++){
					if(map[i][j]!=x)continue;
					next.add(new int[]{i, j});
					int min = 1<<29;
					for(int[] a:l){
						min = Math.min(min, dist[a[0]][a[1]]+Math.abs(a[0]-i)+Math.abs(a[1]-j));
					}
					dist[i][j] = min;
				}
				l = next;
			}
			System.out.println(dist[gi][gj]);
		}
	}
	
	public static void main(String[] args) {
		new AOJ2284().run();
	}
}
