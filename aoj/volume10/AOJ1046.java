package volume10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//Ghost Buster!
public class AOJ1046 {

	public static int h;
	public static int w;
	public static char[] pattern;

	public static char[][] map;
	public static int[][] opt;
	public static int[][] move = {{1,0},{0,-1},{0,1},{-1,0},{0,0}};

	public static int dir(char c){
		return c=='2'?0:c=='4'?1:c=='6'?2:c=='8'?3:4;
	}

	public static int si;
	public static int sj;
	public static int ti;
	public static int tj;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			h = sc.nextInt();
			w = sc.nextInt();
			if(h==0&&w==0)break;
			map = new char[h][w];
			for(int i=0;i<h;i++){
				char[] s = sc.next().toCharArray();
				for(int j=0;j<w;j++){
					map[i][j] = s[j];
					if(s[j]=='A'){
						si = i;
						sj = j;
						map[i][j] = '.';
					}
					if(s[j]=='B'){
						ti = i;
						tj = j;
						map[i][j] = '.';
					}
				}
			}
			pattern = sc.next().toCharArray();
			opt = new int[h][w];
			for(int[]a:opt)Arrays.fill(a, Integer.MAX_VALUE);
			opt[si][sj] = 0;
			List<int[]> list = new ArrayList<int[]>();
			list.add(new int[]{si,sj});
			int dis = 1;
			while(!list.isEmpty()){
				List<int[]> next = new ArrayList<int[]>();
				for(int[] a : list){
					for(int k=0;k<4;k++){
						int i = a[0] + move[k][0];
						int j = a[1] + move[k][1];
						if(0<=i&&i<h&&0<=j&&j<w&&map[i][j]=='.'&&opt[i][j]==Integer.MAX_VALUE){
							opt[i][j] = dis;
							next.add(new int[]{i, j});
						}
					}
				}
				list = next;
				dis++;
			}
			int ans = 1000;
			int mi = 0;
			int mj = 0;
			int step = 0;
			while(step <= ans){
				if(opt[ti][tj]<=step){
					if(step < ans){
						ans = step;
						mi = ti;
						mj = tj;
					}
				}
				int k = dir(pattern[step%pattern.length]);
				step++;
				int ni = ti + move[k][0];
				int nj = tj + move[k][1];
				if(0<=ni&&ni<h&&0<=nj&&nj<w){
					ti = ni;
					tj = nj;
				}
			}
			System.out.println(ans==1000?"impossible":(ans+" " + mi + " " + mj));
		}
	}
}
