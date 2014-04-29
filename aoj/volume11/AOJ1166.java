package volume11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Amazing Mazes
public class AOJ1166 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] move = {{0,1},{0,-1},{1,0},{-1,0}};
		while(true){
			int w = sc.nextInt();
			int h = sc.nextInt();
			if((w|h)==0)break;
			sc.nextLine();
			boolean[][] map = new boolean[h][w];
			int[][] wall = new int[2*h-1][];
			for(int i=0;i<2*h-1;i++){
				if(i%2==0){
					wall[i] = new int[w-1];
					for(int j=0;j<w-1;j++)wall[i][j]=sc.nextInt();
				}
				else{
					wall[i] = new int[w];
					for(int j=0;j<w;j++)wall[i][j]=sc.nextInt();
				}
			}
			int step = 1;
			int ans = 0;
			List<int[]> list = new ArrayList<int[]>();
			list.add(new int[]{0, 0});
			map[0][0]=true;
			while(!list.isEmpty()){
				List<int[]> next = new ArrayList<int[]>();
				for(int[] a:list){
					if(a[0]==h-1 && a[1]==w-1){
						ans = step;
						break;
					}
					for(int k=0;k<4;k++){
						int ni = a[0]+move[k][0];
						int nj = a[1]+move[k][1];
						if(0<=ni&&ni<h&&0<=nj&&nj<w&&!map[ni][nj]){
							if(k==0 && wall[a[0]*2][a[1]]==0){
								map[ni][nj] = true;
								next.add(new int[]{ni,nj});
							}
							else if(k==1 && wall[ni*2][nj]==0){
								map[ni][nj] = true;
								next.add(new int[]{ni,nj});
							}
							else if(k==2 && wall[a[0]*2+1][a[1]]==0){
								map[ni][nj] = true;
								next.add(new int[]{ni,nj});
							}
							else if(k==3 && wall[ni*2+1][nj]==0){
								map[ni][nj] = true;
								next.add(new int[]{ni,nj});
							}
						}
					}
				}
				list = next;
				step++;
			}
			System.out.println(ans);
		}
	}
}
