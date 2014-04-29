package volume05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Cheese
public class AOJ0558 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] move = {{0,1},{0,-1},{1,0},{-1,0}};
		int h = sc.nextInt();
		int w = sc.nextInt();
		int n = sc.nextInt();
		char[][] m = new char[h][w];
		int si = 0;
		int sj = 0;
		for(int i=0;i<h;i++){
			char[] s = sc.next().toCharArray();
			for(int j=0;j<w;j++){
				m[i][j] = s[j];
				if(s[j]=='S'){
					si = i;
					sj = j;
				}
			}
		}
		int ans = 0;
		for(int x=1;x<=n;x++){
			boolean[][] used = new boolean[h][w];
			used[si][sj] = true;
			List<int[]> l = new ArrayList<int[]>();
			l.add(new int[]{si,sj});
			int step = 0;
			while(!l.isEmpty()){
				List<int[]> next = new ArrayList<int[]>();
				for(int[]a:l){
					int i = a[0];
					int j = a[1];
					if(m[i][j]==(char)(x+'0')){
						ans += step;
						si = i;
						sj = j;
						next.clear();
						break;
					}
					for(int k=0;k<4;k++){
						int ni = i+move[k][0];
						int nj = j+move[k][1];
						if(0<=ni&&ni<h&&0<=nj&&nj<w&&m[ni][nj]!='X'&&!used[ni][nj]){
							used[ni][nj] = true;
							next.add(new int[]{ni,nj});
						}
					}
				}
				step++;
				l = next;
			}
		}
		System.out.println(ans);
	}
}
