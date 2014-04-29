package volume05;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

//Paint Color
public class AOJ0531 {

	int w, h, n, r, c;
	boolean[][] m;
	int[][] move = {{-1,0},{0,1},{1,0},{0,-1}};

	void run(){
		Scanner sc = new Scanner(System.in);
		while(true){
			w = sc.nextInt();
			h = sc.nextInt();
			if((w|h)==0)break;
			n = sc.nextInt();
			PriorityQueue<Integer> qx = new PriorityQueue<Integer>();
			PriorityQueue<Integer> qy = new PriorityQueue<Integer>();
			qx.add(0);qx.add(w);
			qy.add(0);qy.add(h);
			int[][] a = new int[n][4];
			for(int i=0;i<n;i++){
				for(int j=0;j<4;j++){
					a[i][j] = sc.nextInt();
					if(j%2==0&&!qx.contains(a[i][j])){
						qx.add(a[i][j]);
					}
					else if(j%2==1&&!qy.contains(a[i][j])){
						qy.add(a[i][j]);
					}
				}
			}
			r = qy.size()-1;
			c = qx.size()-1;
			Map<Integer, Integer> mx = new HashMap<Integer, Integer>();
			Map<Integer, Integer> my = new HashMap<Integer, Integer>();
			int id = 0;
			while(!qx.isEmpty())mx.put(qx.poll(), id++);
			id = 0;
			while(!qy.isEmpty())my.put(qy.poll(), id++);
			m = new boolean[r][c];
			for(int i=0;i<n;i++){
				int x1 = mx.get(a[i][0]);
				int x2 = mx.get(a[i][2]);
				int y1 = my.get(a[i][1]);
				int y2 = my.get(a[i][3]);
				for(int j=x1;j<x2;j++)for(int k=y1;k<y2;k++)m[k][j]=true;
			}
			int ans = 0;
			for(int i=0;i<r;i++){
				for(int j=0;j<c;j++){
					if(!m[i][j]){
						ans++;
						Stack<int[]> s = new Stack<int[]>();
						s.add(new int[]{i, j});
						while(!s.isEmpty()){
							int[] p = s.pop();
							if(m[p[0]][p[1]])continue;
							m[p[0]][p[1]] = true;
							for(int k=0;k<4;k++){
								int ni = p[0]+move[k][0];
								int nj = p[1]+move[k][1];
								if(0<=ni&&ni<r&&0<=nj&&nj<c)s.add(new int[]{ni,nj});
							}
						}
					}
				}
			}
			System.out.println(ans);
		}
	}

	public static void main(String[] args) {
		new AOJ0531().run();
	}
}
