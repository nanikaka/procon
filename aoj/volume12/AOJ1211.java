package volume12;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

//Trapezoids
public class AOJ1211 {

	int h;
	char[][] map;
	int[] move = {-1,0,1};

	void run(){
		Scanner sc = new Scanner(System.in);
		boolean f = true;
		while(true){
			h = sc.nextInt();
			if(h==0)break;
			if(!f)System.out.println("----------");
			f = false;
			Map<Integer, Integer> ans = new HashMap<Integer, Integer>();
			map = new char[h][];
			sc.nextLine();
			for(int i=0;i<h;i++)map[i]=sc.nextLine().toCharArray();
			for(int i=0;i<h;i++){
				for(int j=0;j<map[i].length;j++){
					if(map[i][j]!='*')continue;
					int a = 1;
					map[i][j] = ' ';
					int k = j+1;
					while(k<map[i].length&&map[i][k]=='*'){
						map[i][k++] = ' ';
						a++;
					}
					k--;
					int height = 1;
					int b = 1;
					for(int d=0;d<3;d++){
						int w = j+move[d];
						if(0<=w&&w<map[i+1].length&&map[i+1][w]=='*'){
							int y = i+1;
							while(y<h&&0<=w&&w<map[y].length&&map[y][w]=='*'){
								height++;
								map[y][w] = ' ';
								y++;
								w += move[d];
							}
							y--;
							w-=move[d];
							w++;
							while(w<map[y].length&&map[y][w]=='*'){
								b++;
								map[y][w] = ' ';
								w++;
							}
							w--;
							int dir = w<k?0:w==k?1:2;
							y = i+1;
							w = k + move[dir];
							while(w<map[y].length&&y<h&&map[y][w]=='*'){
								map[y][w] = ' ';
								y++;
								w+=move[dir];
							}
							break;
						}
					}
					int area = (a+b)*height/2;
					if(ans.containsKey(area)){
						ans.put(area, ans.get(area)+1);
					}
					else{
						ans.put(area, 1);
					}
				}
			}
			PriorityQueue<Integer> q = new PriorityQueue<Integer>();
			for(Integer i:ans.keySet())q.add(i);
			while(!q.isEmpty()){
				int area = q.poll();
				System.out.println(area+" "+ans.get(area));
			}
		}
	}

	public static void main(String[] args) {
		new AOJ1211().run();
	}
}
